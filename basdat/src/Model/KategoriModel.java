package Model;
import Entity.KategoriEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class KategoriModel
{
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<KategoriEntity> KategoriEntity = new ArrayList<>();
        
    public KategoriModel() {}
    
    public ArrayList<KategoriEntity> showDataKategori(){
        try{
            sql = "SELECT *FROM kategori ";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                KategoriEntity kategori = new KategoriEntity();
                kategori.setId_kategori(rs.getInt("id_kategori"));
                kategori.setNama_kategori(rs.getString("nama_kategori"));
                KategoriEntity.add(kategori);
            }
        }catch(SQLException e){
                System.out.println(e);
        } return KategoriEntity;
    }
    
    public ArrayList<KategoriEntity> getDataKategori() {
        ArrayList<KategoriEntity> arraylistkategori = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM kategori";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                KategoriEntity kategori = new KategoriEntity();
                kategori.setId_kategori(rs.getInt("id_kategori"));
                kategori.setNama_kategori(rs.getString("nama_kategori"));
                arraylistkategori.add(kategori);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistkategori;
    }
}
