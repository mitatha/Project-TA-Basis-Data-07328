package Model;
import Entity.AdminEntity;
import Entity.CustomerEntity;
import Helper.KoneksiDb;
import java.sql.*;
import java.util.ArrayList;

public class CustomerModel
{
    private String sql;
    public Connection conn = KoneksiDb.getconection();
    public ArrayList<CustomerEntity> CustomerEntity = new ArrayList<>();
    public CustomerModel() {}
    
    public ArrayList<CustomerEntity> getCustomerEntity()
    {
        try
        {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM pembeli";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                CustomerEntity customer = new CustomerEntity();
                customer.setId_customer(rs.getInt("id_customer"));
                customer.setNama(rs.getString("nama_customer"));
                customer.setAlamat_customer(rs.getString("alamat_customer"));
                customer.setNoTelp(rs.getString("noTelp_customer"));
            }
        }catch(SQLException e){
                System.out.println(e);
        }
        return CustomerEntity;
    }
    
    public void insertData(CustomerEntity customer){
        try{
            sql="INSERT INTO customer (id_customer, nama_customer, alamat_customer, noTelp_customer) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, customer.getId_customer());
            stat.setString(2, customer.getNama());
            stat.setString(3, customer.getAlamat_customer());
            stat.setString(4, customer.getNoTelp());
            
            int rows=stat.executeUpdate();
            System.out.println(rows + "row(s) updated !");
        }catch(SQLException e){
            System.out.println("GAGAL INPUT DATA !!!");
            e.printStackTrace();
        }
    }
    
    public ArrayList <CustomerEntity> getCustomer(String index)
    {
        try{
            sql = "SELECT * FROM customer where id_customer = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, index);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                CustomerEntity customer = new CustomerEntity();
                customer.setId_customer(rs.getInt("id_customer"));
                customer.setNama(rs.getString("nama_customer"));
                customer.setNoTelp(rs.getString("noTelp_customer"));
                customer.setAlamat_customer(rs.getString("alamat_customer"));
                CustomerEntity.add(customer);
            }
            }catch(SQLException e){
                    System.out.println(e);
                    }
            return CustomerEntity;
    }
    
    public ArrayList<CustomerEntity> showDataCustomer(){
        try{
            sql = "SELECT *FROM customer";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                CustomerEntity customer = new CustomerEntity();
                customer.setNama(rs.getString("nama_customer"));
                customer.setId_customer(rs.getInt("id_customer"));
                customer.setAlamat_customer(rs.getString("alamat_customer"));
                customer.setNoTelp(rs.getString("notelp_admin"));
                CustomerEntity.add(customer);
            }
        }catch(SQLException e){
                System.out.println(e);
        } return CustomerEntity;
    }
    
    public void update(String index, String notelp)
    {
        try 
        {
            sql = "UPDATE customer SET noTelp_customer =? WHERE id_customer =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, notelp);
            stat.setString(2, index);
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL RUBAH NAMA!!!");
            System.out.println(e);
        }
    }
   
    
    public ArrayList<CustomerEntity> getDataCustomer() {
        ArrayList<CustomerEntity> arraylistcustomer = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM customer";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                CustomerEntity customer = new CustomerEntity();
                customer.setId_customer(rs.getInt("id_customer"));
                customer.setNama(rs.getString("nama_customer"));
                customer.setAlamat_customer(rs.getString("alamat_customer"));
                customer.setNoTelp(rs.getString("noTelp_customer"));
                arraylistcustomer.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistcustomer;
    }
   
            
}
