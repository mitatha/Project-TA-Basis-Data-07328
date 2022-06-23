package Controller;
import Entity.*;
import Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CustomerController extends ObjectModelController {
    public ArrayList <CustomerEntity> customerEntity(String index)
    {
        return ObjectModelController.customer.getCustomer(index);
    }
    public ArrayList <CustomerEntity> getCustomer()
    {
        return ObjectModelController.customer.getCustomerEntity();
    }
    public void customerEntity(CustomerEntity customer)
    {
        ObjectModelController.customer.insertData(customer);
    }
    public ArrayList <CustomerEntity>showDataCustomer()
    {
        return ObjectModelController.customer.showDataCustomer();
    }
    public void update(String index, String notelp)
    {
        ObjectModelController.customer.update(index,notelp);
    }
    
    public ArrayList<CustomerEntity> getDataCustomer() {
        return ObjectModelController.customer.getDataCustomer();
    }
    public DefaultTableModel dataCustomer() {
        DefaultTableModel dataDaftarCustomer = new DefaultTableModel();
        Object[] kolom = {"Id Customer","Nama Customer","Alamat Customer","Notelp Customer"};
        dataDaftarCustomer.setColumnIdentifiers(kolom);
        int size = getDataCustomer().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[4];
            data[0] = ObjectModelController.customer.getDataCustomer().get(i).getId_customer();
            data[1] = ObjectModelController.customer.getDataCustomer().get(i).getNama();           
            data[2] = ObjectModelController.customer.getDataCustomer().get(i).getAlamat_customer();
            data[3] = ObjectModelController.customer.getDataCustomer().get(i).getNoTelp();
            dataDaftarCustomer.addRow(data);
        }
        return dataDaftarCustomer;
    }
}
