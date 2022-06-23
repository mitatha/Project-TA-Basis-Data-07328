package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PunyaCustomer extends ComponentGUI {
    JTable tabelcustomer = new JTable();
    JScrollPane spcustomer = new JScrollPane(tabelcustomer);
    JTextField textpilih = new JTextField();
    int kode;
    
    public PunyaCustomer(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("DATA CUSTOMER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        spcustomer.setBounds(20, 50, 500, 350);
        tabelcustomer.setModel(AllObjectController.customer.dataCustomer());
        add(spcustomer);
        
        btnpilih.setBounds(550, 50, 130, 25);
        btnpilih.setFocusPainted(false);
        btnpilih.setBorder(null);
        btnpilih.setBackground(Color.black);
        btnpilih.setForeground(Color.white);
        add(btnpilih);
        
        btntambahcustomer.setBounds(550, 95, 130, 25);
        btntambahcustomer.setFocusPainted(false);
        btntambahcustomer.setBorder(null);
        btntambahcustomer.setBackground(Color.black);
        btntambahcustomer.setForeground(Color.white);
        add(btntambahcustomer);
        
        btnupdatecustomer.setBounds(550, 135, 130, 25);
        btnupdatecustomer.setFocusPainted(false);
        btnupdatecustomer.setBorder(null);
        btnupdatecustomer.setBackground(Color.black);
        btnupdatecustomer.setForeground(Color.white);
        add(btnupdatecustomer);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        tabelcustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelcustomer.getSelectedRow();
                textpilih.setText(AllObjectController.customer.dataCustomer().getValueAt(i, 0).toString());
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuKasir(cek).setVisible(true);
            }
        });
        
       btntambahcustomer.addActionListener(e ->{
            dispose();
            new TambahCustomer(cek).setVisible(true);
        });
        
         btnupdatecustomer.addActionListener(e ->{
            dispose();
            new UpdateCustomer(textpilih.getText(),cek).setVisible(true);
        });
         
        btnpilih.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                kode = Integer.valueOf(textpilih.getText());
                PunyaTransaksi daftar = new PunyaTransaksi(cek, kode);
                dispose();
                daftar.setVisible(true);
            }
        });
}
}