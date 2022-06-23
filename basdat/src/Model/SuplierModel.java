package Model;
import Entity.SuplierEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class SuplierModel 
{
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<SuplierEntity> SuplierEntity = new ArrayList<>();
        
    public SuplierModel() {}
    
    public void insertData(SuplierEntity suplier)
    {
        try
        {
            sql="INSERT INTO suplier (id_suplier,nama_suplier,notelp_suplier) Values(?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, suplier.getId_suplier());
            stat.setString(2, suplier.getNama());
            stat.setString(3, suplier.getNoTelp());
            
            int rows=stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    
    public ArrayList<SuplierEntity> showDataSuplier(){
        try{
            sql = "SELECT *FROM suplier";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                SuplierEntity suplier = new SuplierEntity();
                suplier.setId_suplier(rs.getInt("id_suplier"));
                suplier.setNama(rs.getString("nama_kategori"));
                suplier.setNoTelp(rs.getString("notelp_suplier"));
                SuplierEntity.add(suplier);
            }
        }catch(SQLException e){
                System.out.println(e);
        } return SuplierEntity;
    }
    
    public void update(String index, String notelp)
    {
        try 
        {
            sql = "UPDATE suplier SET notelp_suplier =? WHERE id_suplier =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, notelp);
            stat.setString(2, index);
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL RUBAH PASSWORD!!!");
            System.out.println(e);
        }
    }
    
    public void deleteData(int index)
    {
        try 
        {
            sql = "DELETE FROM suplier where id_suplier =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, index);
            stat.executeUpdate();
        } catch (SQLException e) 
        {
            System.out.println("GAGAL HAPUS DATA!!!");
        }
    }
    
    public ArrayList<SuplierEntity> getDataSuplier() {
        ArrayList<SuplierEntity> arraylistsuplier = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM suplier";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                SuplierEntity suplier = new SuplierEntity();
                suplier.setId_suplier(rs.getInt("id_suplier"));
                suplier.setNama(rs.getString("nama_suplier"));
                suplier.setNoTelp(rs.getString("notelp_suplier"));
                arraylistsuplier.add(suplier);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistsuplier;
    }
}
