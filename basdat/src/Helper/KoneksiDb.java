package Helper;
import java.sql.*;

public class KoneksiDb {    
    public static Connection getconection(){
        Connection conn = null;
        String driver_mitha = "com.mysql.cj.jdbc.Driver";
        String url_mitha= "jdbc:mysql://localhost:3306/db_salon";
        String user_mitha = "root";
        String pass_mitha ="";
        try{
            Class.forName(driver_mitha);
            conn=DriverManager.getConnection(url_mitha, user_mitha, pass_mitha);
//            System.out.println("Berhasil Koneksi Database");
        }catch(Exception e){
//            System.out.println("Gagal Koneksi Database");
            e.printStackTrace();
        }
        return conn;
    }
}
