package Controller;
import Entity.*;
import Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class AdminController extends ObjectModelController {
    public AdminController() {}
    
    public int login(int id, String password)
    {
       return ObjectModelController.admin.cekData(id, password);
    }
    public void adminEntity(AdminEntity admin)
    {
        ObjectModelController.admin.insertData(admin);
    }
    public ArrayList <AdminEntity>showDataAdmin()
    {
        return ObjectModelController.admin.showDataAdmin();
    }
    public void update(String index, String nama)
    {
        ObjectModelController.admin.update(index, nama);
    }
    public void delete(String nama)
    {
        ObjectModelController.admin.deleteData(nama);
    }
    
    public ArrayList<AdminEntity> getDataAdmin() {
        return ObjectModelController.admin.getData();
    }
    public DefaultTableModel dataAdmin() {
        DefaultTableModel dataDaftarAdmin = new DefaultTableModel();
        Object[] kolom = {"NAMA", "NO TELP"};
        dataDaftarAdmin.setColumnIdentifiers(kolom);
        int size = getDataAdmin().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[8];
            data[0] = ObjectModelController.admin.getData().get(i).getNama();
            data[1] = ObjectModelController.admin.getData().get(i).getNoTelp();
            dataDaftarAdmin.addRow(data);
        }
        return dataDaftarAdmin;
    }
}
        
