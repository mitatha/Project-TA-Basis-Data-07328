package Model;
import Entity.ProdukEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class ProdukModel 
{
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<ProdukEntity> ProdukEntity = new ArrayList<>();
        
    public ProdukModel() {}
    
    public void insertData(ProdukEntity produk)
    {
        try
        {
            sql="INSERT INTO produk (id_produk,nama_produk,deskripsi_produk,harga,id_kategori,id_suplier) Values(?,?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, produk.getId_produk());
            stat.setString(2, produk.getNama_produk());
            stat.setString(3, produk.getDeskripsi_produk());
            stat.setInt(4, produk.getHarga());
            stat.setInt(5, produk.getId_kategori());
            stat.setInt(6, produk.getId_suplier());
            
            int rows=stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    
    public ArrayList<ProdukEntity> showDataProduk(){
        try{
            sql = "SELECT *FROM produk";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                ProdukEntity produk = new ProdukEntity();
                produk.setId_produk(rs.getInt("id_produk"));
                produk.setId_kategori(rs.getInt("id_kategori"));
                produk.setId_suplier(rs.getInt("id_suplier"));
                produk.setNama_produk(rs.getString("nama_produk"));
                produk.setDeskripsi_produk(rs.getString("deskripsi_produk"));
                produk.setHarga(rs.getInt("harga"));
                ProdukEntity.add(produk);
            }
        }catch(SQLException e){
                System.out.println(e);
        } return ProdukEntity;
    }
    
    public void update(int index, int harga)
    {
        try 
        {
            sql = "UPDATE produk SET harga = ? WHERE id_produk =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            System.out.println("harga" + harga);
            System.out.println("id" + index);
            stat.setInt(1, index);
            stat.setInt(2, harga);
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL RUBAH HARGA!!!");
            System.out.println(e);
        }
    }
    
    public void deleteData(int index)
    {
        try 
        {
            sql = "DELETE FROM produk where id_produk =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, index);
            stat.executeUpdate();
        } catch (SQLException e) 
        {
            System.out.println("GAGAL HAPUS DATA!!!");
        }
    }
    
    public ArrayList<ProdukEntity> getDataProduk() {
        ArrayList<ProdukEntity> arraylistproduk = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM produk";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                ProdukEntity produk = new ProdukEntity();
                produk.setId_produk(rs.getInt("id_produk"));
                produk.setNama_produk(rs.getString("nama_produk"));
                produk.setHarga(rs.getInt("harga"));
                arraylistproduk.add(produk);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistproduk;
    }
    
    public ArrayList<ProdukEntity> getDataProduk1() {
        ArrayList<ProdukEntity> arraylistproduk1 = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "select produk.id_produk,produk.nama_produk,produk.deskripsi_produk,produk.harga,kategori.nama_kategori,suplier.nama_suplier from produk INNER JOIN kategori ON (kategori.id_kategori=produk.id_kategori)INNER JOIN suplier ON (suplier.id_suplier=produk.id_suplier) ORDER BY id_produk ASC";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                ProdukEntity produk = new ProdukEntity();
                produk.setId_produk(rs.getInt("id_produk"));
                produk.setNama_produk(rs.getString("nama_produk"));
                produk.setDeskripsi_produk(rs.getString("deskripsi_produk"));
                produk.setHarga(rs.getInt("harga"));
                produk.setNama_kategori(rs.getString("nama_kategori"));
                produk.setNama_suplier(rs.getString("nama_suplier"));
                arraylistproduk1.add(produk);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistproduk1;
    }

    public int getHarga (int id_produk)
     {
         int harga=0;
         try{
             sql= "SELECT harga from produk where id_produk=?";
             PreparedStatement stat = conn.prepareStatement(sql);
             stat.setInt(1, id_produk);
             ResultSet rs = stat.executeQuery();
             if(rs.next())
             {
                 return rs.getInt("harga");
             }
         }
         catch (SQLException e){
             System.out.println(e);
         }
         return harga;
     }
     
}
