package Model;
import Entity.PenjualanEntity;
import Entity.KasirEntity;
import Entity.CustomerEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class PenjualanModel 
{
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<PenjualanEntity> PenjualanEntity = new ArrayList<>();
        
    public PenjualanModel() {}
    
    public int insertData(PenjualanEntity penjualan)
    {
        int rows = 0;
        try
        {
            sql="select id_trx from penjualan order by id_trx desc limit 1";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs=stat.executeQuery();
            if(rs.next())
                rows = rs.getInt("id_trx");
            
            rows += 1;
            //System.out.println("row s : " + rows);

            penjualan.setId_trx(rows);
            
            sql="INSERT INTO penjualan (id_trx, total_harga, id_kasir, id_customer) VALUES (?,?,?,?)";
            stat = conn.prepareStatement(sql);
            stat.setInt(1, rows);
            stat.setInt(2, penjualan.getTotal_harga());
            stat.setInt(3, penjualan.getId_kasir());
            stat.setInt(4, penjualan.getId_customer());
            stat.executeUpdate();
            
            //System.out.println(rows);
            //System.out.println(penjualan.getId_kasir());
            
            //System.out.println("row" + rows);
            
            return rows;
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
        return rows;
    }
    
    public ArrayList<PenjualanEntity> showDataPenjualan(int index){
        try{
            sql = "SELECT *FROM Penjualan";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, index);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                PenjualanEntity penjualan = new PenjualanEntity();
                penjualan.setId_trx(rs.getInt("id_trx"));
                penjualan.setTotal_harga(rs.getInt("total_harga"));
                penjualan.setTgl_penjualan(rs.getString("tgl_penjualan"));
                PenjualanEntity.add(penjualan);
            }
        }catch(SQLException e){
                System.out.println(e);
        } return PenjualanEntity;
    }
    
    public ArrayList<PenjualanEntity> showDataPenjualan1(){
        try{
            sql = "SELECT *FROM Penjualan";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                PenjualanEntity penjualan = new PenjualanEntity();
                penjualan.setId_trx(rs.getInt("id_trx"));
                penjualan.setTotal_harga(rs.getInt("total_harga"));
                penjualan.setTgl_penjualan(rs.getString("tgl_penjualan"));
                PenjualanEntity.add(penjualan);
            }
        }catch(SQLException e){
                System.out.println(e);
        } return PenjualanEntity;
    }
    
    
    public void deleteData(int index)
    {
        try 
        {
            sql = "DELETE FROM penjualan where id_trx =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, index);
            stat.executeUpdate();
        } catch (SQLException e) 
        {
            System.out.println("GAGAL HAPUS DATA!!!");
        }
    }
    
    public ArrayList<PenjualanEntity> getDataPenjualan() {
        ArrayList<PenjualanEntity> arraylistpenjualan = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM penjualan";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                PenjualanEntity penjualan = new PenjualanEntity();
                penjualan.setId_trx(rs.getInt("id_trx"));
                penjualan.setTotal_harga(rs.getInt("total_harga"));
                penjualan.setTgl_penjualan(rs.getString("tgl_penjualan"));
                penjualan.setId_kasir(rs.getInt("id_kasir"));
                penjualan.setId_customer(rs.getInt("id_customer"));
                arraylistpenjualan.add(penjualan);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistpenjualan;
    }
    
    public int getId(int id_customer,int id_kasir)
    {
        int id=0;
        try
        {
            sql ="select id_trx from penjualan where id_customer=? and id_kasir=? order by tgl_penjualan DESC LIMIT 1";
            PreparedStatement stat=conn.prepareStatement(sql);
            stat.setInt(1, id_customer);
            stat.setInt(2, id_kasir);
            ResultSet rs = stat.executeQuery();
            if(rs.next())
            {
                return rs.getInt("id_trx");
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return id;
    }
    
    public String getCustomer(int id_trx)
    {
        String nama = " ";
        try
        {
            sql ="select customer.nama_customer from penjualan INNER JOIN customer ON penjualan.id_customer=customer.id_customer where id_trx=?";
            PreparedStatement stat=conn.prepareStatement(sql);
            stat.setInt(1, id_trx);
            ResultSet rs = stat.executeQuery();
            if(rs.next())
            {
                return rs.getString("nama_customer");
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return nama;
    }
    
    public int Transaksi(int id_kasir,int id_customer,int total)
    {
        String sql;
        int rows=0;
        Connection conn=KoneksiDb.getconection();
        try
        {
            sql="select id_trx from penjualan order by id_trx desc limit 1";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs=stat.executeQuery();
            if(rs.next()){
                rows = rs.getInt("id_trx");
                rows += 1;
            }
            sql="INSERT INTO penjualan (id_trx, total_harga, id_kasir, id_customer) VALUES (?,?,?,?)";
            stat = conn.prepareStatement(sql);
            stat.setInt(1, rows);
            stat.setInt(2, total );
            stat.setInt(3, id_kasir);
            stat.setInt(4, id_customer);
            stat.executeUpdate();
            return rows;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static void main(String[] args) {
        PenjualanModel model = new PenjualanModel();
        model.Transaksi(301, 414, 175000);
    }
    
}
        