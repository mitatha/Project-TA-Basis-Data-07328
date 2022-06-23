package Model;
import Entity.AdminEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class AdminModel 
{
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<AdminEntity> AdminEntity = new ArrayList<>();
        
    public AdminModel() {}
    
    public void insertData(AdminEntity admin)
    {
        System.out.println(admin.getId());
        System.out.println(admin.getPw());
        System.out.println(admin.getNama());
        System.out.println(admin.getNoTelp());
        try
        {
            sql="INSERT INTO admin (id_admin,pw_admin,nama_admin,notelp_admin) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, admin.getId());
            stat.setString(2, admin.getPw());
            stat.setString(3, admin.getNama());
            stat.setString(4, admin.getNoTelp());
            
            int rows=stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    
    public int cekData(int id, String password)
    {
        
        try 
        {
            sql = "SELECT *FROM admin where id_admin =? and pw_admin = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
               return rs.getInt("id_admin");
                
            }
        } catch (Exception e){
            e.printStackTrace();
        } 
        return -1;
    }
    
    public ArrayList<AdminEntity> showDataAdmin(){
        try{
            sql = "SELECT *FROM admin";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                AdminEntity admin = new AdminEntity();
                admin.setNama(rs.getString("nama_admin"));
                admin.setId(rs.getInt("id_admin"));
                admin.setPw(rs.getString("pw_admin"));
                admin.setNoTelp(rs.getString("notelp_admin"));
                AdminEntity.add(admin);
            }
        }catch(SQLException e){
                System.out.println(e);
        } return AdminEntity;
    }
    
     public void update(String index, String nama)
    {
        try 
        {
            sql = "UPDATE admin SET nama_admin =? WHERE nama_admin =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setString(2, index);
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL RUBAH NAMA!!!");
            System.out.println(e);
        }
    }
     
     public void deleteData(String nama)
    {
        try 
        {
            sql = "DELETE FROM admin where nama_admin =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.executeUpdate();
        } catch (SQLException e) 
        {
            System.out.println("GAGAL HAPUS DATA!!!");
        }
    }
     
    public ArrayList<AdminEntity> getData() {
        ArrayList<AdminEntity> arraylistadmin = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM admin";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                AdminEntity admin = new AdminEntity();
                admin.setNama(rs.getString("nama_admin"));
                admin.setNoTelp(rs.getString("notelp_admin"));
                arraylistadmin.add(admin);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistadmin;
    }
    
}
