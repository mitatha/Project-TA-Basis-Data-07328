package Controller;
import Entity.*;
import Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class SuplierController extends ObjectModelController{
    public SuplierController(){}
    
    public void suplierEntity(SuplierEntity suplier)
    {
        ObjectModelController.suplier.insertData(suplier);
    }
    public ArrayList <SuplierEntity>showDataSuplier()
    {
        return ObjectModelController.suplier.showDataSuplier();
    }
    public void update(String index, String notelp)
    {
        ObjectModelController.suplier.update(index, notelp);
    }
    public void delete(int index)
    {
        ObjectModelController.suplier.deleteData(index);
    }
    
    public ArrayList<SuplierEntity> getDataSuplier() {
        return ObjectModelController.suplier.getDataSuplier();
    }
    public DefaultTableModel dataSuplier() {
        DefaultTableModel dataDaftarSuplier = new DefaultTableModel();
        Object[] kolom = {"ID SUPLIER ", "NAMA", "NO TELP"};
        dataDaftarSuplier.setColumnIdentifiers(kolom);
        int size = getDataSuplier().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[8];
            data[0] = ObjectModelController.suplier.getDataSuplier().get(i).getId_suplier();
            data[1] = ObjectModelController.suplier.getDataSuplier().get(i).getNama();
            data[2] = ObjectModelController.suplier.getDataSuplier().get(i).getNoTelp();
            dataDaftarSuplier.addRow(data);
        }
        return dataDaftarSuplier;
    }
}
