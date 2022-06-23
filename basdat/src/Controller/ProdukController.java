package Controller;
import Entity.*;
import GUI.AllObjectController;
import Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ProdukController extends ObjectModelController {
    public ProdukController (){}
    
    public void produkEntity(ProdukEntity produk)
    {
        System.out.println(produk.getId_produk());
        ObjectModelController.produk.insertData(produk);
    }
    public ArrayList <ProdukEntity>showDataProduk()
    {
        return ObjectModelController.produk.showDataProduk();
    }
    public void update(int index, int harga)
    {
        ObjectModelController.produk.update(index, harga);
    }
    public void delete(int index)
    {
        ObjectModelController.produk.deleteData(index);
    }
    
    public ArrayList<ProdukEntity> getDataProduk() {
        return ObjectModelController.produk.getDataProduk();
    }
    public DefaultTableModel dataProduk() {
        DefaultTableModel dataDaftarProduk = new DefaultTableModel();
        Object[] kolom = {"ID PRODUK ", "NAMA PRODUK", "HARGA"};
        dataDaftarProduk.setColumnIdentifiers(kolom);
        int size = getDataProduk().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[3];
            data[0] = ObjectModelController.produk.getDataProduk().get(i).getId_produk();
            data[1] = ObjectModelController.produk.getDataProduk().get(i).getNama_produk();
            data[2] = ObjectModelController.produk.getDataProduk().get(i).getHarga();
            dataDaftarProduk.addRow(data);
        }
        return dataDaftarProduk;
    }
    
    public ArrayList<ProdukEntity> getDataProduk1() {
        return ObjectModelController.produk.getDataProduk1();
    }
    public DefaultTableModel dataProduk1() {
        DefaultTableModel dataDaftarProduk1 = new DefaultTableModel();
        Object[] kolom = {"ID PRODUK ", "NAMA PRODUK", "DESKRIPSI PRODUK","HARGA","NAMA KATEGORI","NAMA SUPLIER"};
        dataDaftarProduk1.setColumnIdentifiers(kolom);
        int size = getDataProduk().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[6];
            data[0] = ObjectModelController.produk.getDataProduk1().get(i).getId_produk();
            data[1] = ObjectModelController.produk.getDataProduk1().get(i).getNama_produk();
            data[2] = ObjectModelController.produk.getDataProduk1().get(i).getDeskripsi_produk();
            data[3] = ObjectModelController.produk.getDataProduk1().get(i).getHarga();
            data[4] = ObjectModelController.produk.getDataProduk1().get(i).getNama_kategori();
            data[5] = ObjectModelController.produk.getDataProduk1().get(i).getNama_suplier();
            dataDaftarProduk1.addRow(data);
        }
        return dataDaftarProduk1;
    }
    
    public int getHarga(int id_produk){return ObjectModelController.produk.getHarga(id_produk);}
}
