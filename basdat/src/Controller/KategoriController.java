package Controller;
import Entity.*;
import Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class KategoriController extends ObjectModelController{
    public KategoriController (){}
    
    public ArrayList <KategoriEntity>showDataKategori()
    {
        return ObjectModelController.kategori.showDataKategori();
    }
    
    public ArrayList<KategoriEntity> getDataKategori() {
        return ObjectModelController.kategori.getDataKategori();
    }
    public DefaultTableModel dataKategori() {
        DefaultTableModel dataDaftarKategori = new DefaultTableModel();
        Object[] kolom = {"ID KATEGORI","NAMA KATEGORI", };
        dataDaftarKategori.setColumnIdentifiers(kolom);
        int size = getDataKategori().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[8];
            data[0] = ObjectModelController.kategori.getDataKategori().get(i).getId_kategori();
            data[1] = ObjectModelController.kategori.getDataKategori().get(i).getNama_kategori();
            dataDaftarKategori.addRow(data);
        }
        return dataDaftarKategori;
    }
}
