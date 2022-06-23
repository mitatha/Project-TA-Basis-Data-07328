package Model;
import Entity.KasirEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class KasirModel 
{
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<KasirEntity> KasirEntity = new ArrayList<>();
        
    public KasirModel() {}
    
    public void insertData(KasirEntity kasir)
    {
        try
        {
            sql="INSERT INTO kasir (id_kasir,pw_kasir,nama_kasir,alamat_kasir) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, kasir.getId_kasir());
            stat.setString(2, kasir.getPw_kasir());
            stat.setString(3, kasir.getNama_kasir());
            stat.setString(4, kasir.getAlamat_kasir());
            
            int rows=stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    
    public int cekData(int id, String password)
    {
        int cek = 0;
        try 
        {
            sql = "SELECT *FROM kasir where id_kasir =? and pw_kasir = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("id_kasir");
                
            } else 
            {
                cek=0;
            }
        } catch (Exception e){
            e.printStackTrace();
        } 
        return cek;
    }
    
    public ArrayList<KasirEntity> showDataKasir(){
        try{
            sql = "SELECT *FROM kasir";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                KasirEntity kasir = new KasirEntity();
                kasir.setNama_kasir(rs.getString("nama_kasir"));
                kasir.setId_kasir(rs.getInt("id_kasir"));
                kasir.setPw_kasir(rs.getString("pw_kasir"));
                kasir.setAlamat_kasir(rs.getString("alamat_kasir"));
                KasirEntity.add(kasir);
            }
        }catch(SQLException e){
                System.out.println(e);
        } return KasirEntity;
    }
    
   public void update(String index, String nama)
    {
        try 
        {
            sql = "UPDATE kasir SET nama_kasir =? WHERE nama_kasir =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setString(2, index);
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL RUBAH NAMA!!!");
            System.out.println(e);
        }
    }
    
    public void delete(String nama)
    {
        try 
        {
            sql = "DELETE FROM kasir where nama_kasir =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama );
            stat.executeUpdate();
        } catch (SQLException e) 
        {
            System.out.println("GAGAL HAPUS DATA!!!");
        }
    }
    
    public ArrayList<KasirEntity> getDataKasir() {
        ArrayList<KasirEntity> arraylistkasir = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM kasir";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                KasirEntity kasir = new KasirEntity();
                kasir.setId_kasir(rs.getInt("id_kasir"));
                kasir.setNama_kasir(rs.getString("nama_kasir"));
                kasir.setAlamat_kasir(rs.getString("alamat_kasir"));
                arraylistkasir.add(kasir);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistkasir;
    }
}
