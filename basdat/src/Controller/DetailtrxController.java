package Controller;
import Entity.*;
import GUI.AllObjectController;
import Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DetailtrxController extends ObjectModelController {
    public DetailtrxController() {}
    
    public void detailtrxEntity(DetailtrxEntity detail)
    {
        ObjectModelController.detail.insertData(detail);
    }
    public ArrayList <DetailtrxEntity>showDataDetail(int index)
    {
        return ObjectModelController.detail.showDataDetail(index);
    }
    public void delete(int index)
    {
        ObjectModelController.detail.delete(index);
    }
    
    public void insertData (int id_produk,int id_penjualan,int jumlah_pembelian,int jumlah_harga)
    {
        DetailtrxEntity detailtrx = new DetailtrxEntity();
        detailtrx.setId_produk(id_produk);
        detailtrx.setId_transaksi(id_penjualan);
        detailtrx.setJumlah_pembelian(jumlah_pembelian);
        detailtrx.setJumlah_harga(jumlah_harga);
        ObjectModelController.detail.insertData(detailtrx);
    }
    public ArrayList<DetailtrxEntity> getDataDetail() {
        return ObjectModelController.detail.getDataDetail();
    }
        
        public DefaultTableModel dataDetail(int id) {
        DefaultTableModel dataDaftarDetail = new DefaultTableModel();
        Object[] kolom = {"BANYAK ", "PRODUK", "SUB TOTAL"};
        dataDaftarDetail.setColumnIdentifiers(kolom);
        int size = getDataDetail().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[3];
            data[0] = ObjectModelController.detail.getDataDetail().get(i).getJumlah_pembelian();
            data[1] = ObjectModelController.detail.getDataDetail().get(i).getNama_produk();
            data[2] = ObjectModelController.detail.getDataDetail().get(i).getJumlah_harga();
            dataDaftarDetail.addRow(data);
        }
        return dataDaftarDetail;
    }
}
