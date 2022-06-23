package Controller;
import Entity.*;
import Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class KasirController extends ObjectModelController{
    public KasirController() {}
    
    public int loginkasir(int id, String password)
    {
       return ObjectModelController.kasir.cekData(id, password);
    }
    public void kasirEntity(KasirEntity kasir)
    {
        ObjectModelController.kasir.insertData(kasir);
    }
    public ArrayList <KasirEntity>showDataKasir()
    {
        return ObjectModelController.kasir.showDataKasir();
    }
    public void update(String index, String nama)
    {
        ObjectModelController.kasir.update(index, nama);
    }
    public void delete(String nama)
    {
        ObjectModelController.kasir.delete(nama);
    }
    
    public ArrayList<KasirEntity> getDataKasir() {
        return ObjectModelController.kasir.getDataKasir();
    }
    public DefaultTableModel dataKasir() {
        DefaultTableModel dataDaftarKasir = new DefaultTableModel();
        Object[] kolom = {"Nama Kasir","Id Kasir","Alamat Kasir"};
        dataDaftarKasir.setColumnIdentifiers(kolom);
        int size = getDataKasir().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[8];
            data[0] = ObjectModelController.kasir.getDataKasir().get(i).getNama_kasir();
            data[1] = ObjectModelController.kasir.getDataKasir().get(i).getId_kasir();           
            data[2] = ObjectModelController.kasir.getDataKasir().get(i).getAlamat_kasir();
            dataDaftarKasir.addRow(data);
        }
        return dataDaftarKasir;
    }
}
