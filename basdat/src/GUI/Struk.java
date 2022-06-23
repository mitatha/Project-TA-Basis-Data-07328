package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Struk extends ComponentGUI{
    JTable tabeldetail = new JTable();
    JScrollPane spdetail = new JScrollPane(tabeldetail);

    
    JTextField textpilih = new JTextField();
    
    protected JLabel labelnama = new JLabel();
    protected JLabel labelnotelp = new JLabel();
    protected JLabel labeltanggal = new JLabel();
    protected JLabel labelnotrx = new JLabel();
    protected JLabel labeltotal = new JLabel();
    protected JButton btnback = new JButton("Back To Menu");
    
    int kode;
    
    public Struk(int cek, int id_trx) {
        initComponent(cek, id_trx);
    }
    void initComponent(int cek, int id_trx){
        setTitle("STRUK PEMBELIAN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 510);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelnotrx.setBounds(24, 80, 300, 30);
        labelnotrx.setText("NO.Nota"+id_trx);
        add(labelnotrx);
        
        labeltanggal.setBounds(240, 38, 180, 30);
        labeltanggal.setText("Date Penjualan"+AllObjectController.penjualan.getDataPenjualan().get(kode).getTgl_penjualan());
        add(labeltanggal);
        
        labelnama.setBounds(240, 50, 150, 30);
        labelnama.setText("Customer"+AllObjectController.penjualan.getCustomer(id_trx));
        add(labelnama);
        
        spdetail.setBounds(25, 110, 420, 150);
        tabeldetail.setModel(AllObjectController.detail.dataDetail(id_trx));
        tabeldetail.setDefaultEditor(Object.class, null);
        add(spdetail);
        
        
    }
    
    
}
