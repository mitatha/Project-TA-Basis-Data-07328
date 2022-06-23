package Model;
import Entity.HistoryEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class HistoryModel 
{
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<HistoryEntity> HistoryEntity = new ArrayList<>();
        
    public HistoryModel() {}
    
    public void insertData(HistoryEntity history){
        try{
            sql="INSERT INTO history (id_customer, nama_customer, alamat_customer, noTelp_customer) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            /*stat.setInt(1, history.getId_customer());
            stat.setString(2, history.getNama());
            stat.setString(3, history.getAlamat_customer());
            stat.setString(4, history.getNoTelp());*/
            
            int rows=stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    
   public ArrayList<HistoryEntity> showDataHistory(){
        try{
            sql = "SELECT *FROM history ";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                HistoryEntity history = new HistoryEntity();
                history.setId_history(rs.getInt("id_history"));
                history.setId_admin(rs.getInt("id_admin"));
                history.setId_produk(rs.getInt("id_produk"));
                history.setHarga_sebelum(rs.getInt("harga_sebelum"));
                history.setHarga_sesudah(rs.getInt("harga_sesudah"));
                HistoryEntity.add(history);
            }
        }catch(SQLException e){
                System.out.println(e);
        } return HistoryEntity;
    }
}
