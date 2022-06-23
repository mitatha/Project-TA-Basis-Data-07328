package Model;
import Entity.DetailtrxEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class DetailtrxModel 
{
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<DetailtrxEntity> DetailtrxEntity = new ArrayList<>();
        
    public DetailtrxModel() {}
    
     public void insertData(DetailtrxEntity detail)
    {
        try
        {
            sql="INSERT INTO detail_transaksi (id_produk,id_penjualan,jumlah_pembelian,jumlah_harga) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, detail.getId_produk());
            stat.setInt(2, detail.getId_transaksi());
            stat.setInt(3, detail.getJumlah_pembelian());
            stat.setInt(4, detail.getJumlah_harga());
            
            int rows=stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
     
     public void delete(int index)
    {
        try 
        {
            sql = "DELETE FROM detail_transaksi where id_produk =? AND id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, index);
            stat.executeUpdate();
        } catch (SQLException e) 
        {
            System.out.println("GAGAL HAPUS DATA!!!");
        }
    }
     
     public ArrayList<DetailtrxEntity> showDataDetail(int index){
        try{
            sql = "SELECT *FROM detail_transaksi where id_produk =? AND id_transaksi = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, index);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                DetailtrxEntity detail = new DetailtrxEntity();
                detail.setId_produk(rs.getInt("id_produk"));
                detail.setId_transaksi(rs.getInt("id_transaksi"));
                detail.setJumlah_harga(rs.getInt("jumlah_harga"));
                detail.setJumlah_pembelian(rs.getInt("jumlah_pembelian"));
                DetailtrxEntity.add(detail);
            }
        }catch(SQLException e){
                System.out.println(e);
        } return DetailtrxEntity;
    }
     
     public ArrayList<DetailtrxEntity> getDataDetail() {
        ArrayList<DetailtrxEntity> arraylistdetail = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT detail_transaksi.jumlah_pembelian, produk.nama_produk,detail_transaksi.jumlah_harga FROM detail_transaksi "
                    + "INNER JOIN produk ON detail_transaksi.id_produk = produk.id_produk ORDER BY detail_transaksi.id_penjualan DESC";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                DetailtrxEntity detail = new DetailtrxEntity();
                detail.setJumlah_pembelian(rs.getInt("jumlah_pembelian"));
                detail.setNama_produk(rs.getString("nama_produk"));
                detail.setJumlah_harga(rs.getInt("jumlah_harga"));
                arraylistdetail.add(detail);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistdetail;
    }
}
