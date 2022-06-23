package Controller;
import Entity.*;
import Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PenjualanController {
    public PenjualanController (){}
    
    public void PenjualanEntity(PenjualanEntity penjualan)
    {
        ObjectModelController.penjualan.insertData(penjualan);
    }
    public ArrayList <PenjualanEntity>showDataPenjualan(int index)
    {
        return ObjectModelController.penjualan.showDataPenjualan(index);
    }
    public ArrayList <PenjualanEntity>showDataPenjualan1()
    {
        return ObjectModelController.penjualan.showDataPenjualan1();
    }
    public void delete(int index)
    {
        ObjectModelController.penjualan.deleteData(index);
    }
    public int insertPenjualan(int id_cus,int id_kasir,int total){
        PenjualanEntity penjualan = new PenjualanEntity();
        penjualan.setId_customer(id_cus);
        penjualan.setId_kasir(id_kasir);
        penjualan.setTotal_harga(total);
        return ObjectModelController.penjualan.insertData(penjualan); 
    }
    
    public int getId (int id_customer, int id_kasir){return ObjectModelController.penjualan.getId(id_customer,id_kasir);}
    public String getCustomer (int id_trx){return ObjectModelController.penjualan.getCustomer(id_trx);}
    
    public ArrayList<PenjualanEntity> getDataPenjualan() {
        return ObjectModelController.penjualan.getDataPenjualan();
    }
    public DefaultTableModel dataPenjualan() {
        DefaultTableModel dataDaftarKategori = new DefaultTableModel();
        Object[] kolom = {"ID TRANSAKSI","TOTAL HARGA","Tgl_PENJUALAN","ID KASIR","ID CUSTOMER" };
        dataDaftarKategori.setColumnIdentifiers(kolom);
        int size = getDataPenjualan().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[6];
            data[0] = ObjectModelController.penjualan.getDataPenjualan().get(i).getId_trx();
            data[1] = ObjectModelController.penjualan.getDataPenjualan().get(i).getTotal_harga();
            data[2] = ObjectModelController.penjualan.getDataPenjualan().get(i).getTgl_penjualan();
            data[3] = ObjectModelController.penjualan.getDataPenjualan().get(i).getId_kasir();
            data[4] = ObjectModelController.penjualan.getDataPenjualan().get(i).getId_customer();
            dataDaftarKategori.addRow(data);
        }
        return dataDaftarKategori;
    }
    
    
}
