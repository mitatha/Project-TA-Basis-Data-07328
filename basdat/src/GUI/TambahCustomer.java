package GUI;
import Entity.CustomerEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class TambahCustomer extends ComponentGUI {
    
     public TambahCustomer(int cek) 
    {
        initComponent(cek);
    }
     
     void initComponent(int cek){
        setTitle("Tambah Data Customer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelidcustomer.setBounds(35, 95, 80, 25);
        add(labelidcustomer);
        fieldid.setBounds(130, 95, 130, 25);
        add(fieldid);
        
        labelnama.setBounds(35, 140, 40, 25);
        add(labelnama);
        fieldnama.setBounds(130, 140, 130, 25);
        add(fieldnama);
        
        labelalamat.setBounds(35, 185, 40, 25);
        add(labelalamat);
        fieldalamat.setBounds(130, 185, 130, 25);
        add(fieldalamat);
        
        labelnotelp.setBounds(35, 230, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(130, 230, 130, 25);
        add(fieldnotelp);
        
        btntambahcustomer.setBounds(80, 350, 140, 25);
        btntambahcustomer.setBorder(null);
        btntambahcustomer.setBackground(Color.black);
        btntambahcustomer.setForeground(Color.white);
        btntambahcustomer.setFocusPainted(false);
        add(btntambahcustomer);
        
        btnback.setBounds(35, 400, 80, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setBorder(null);
        btnback.setFocusPainted(false);
        add(btnback);
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new PunyaCustomer(cek).setVisible(true);
            }
        });
        
        btntambahcustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btntambahcustomer.setForeground(Color.black);
                btntambahcustomer.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btntambahcustomer.setForeground(Color.white);
                btntambahcustomer.setBackground(Color.black);
            }
        });
        
        btntambahcustomer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id = Integer.valueOf(fieldid.getText());
                String nama = fieldnama.getText();
                String alamat = fieldalamat.getText();
                String notelp = fieldnotelp.getText();
                if(fieldid.getText().length()!=0 && nama.length() != 0 && alamat.length() !=0 &&  notelp.length() != 0 )
                {
                    AllObjectController.customer.customerEntity(new CustomerEntity(id, nama,alamat, notelp));
                    JOptionPane.showMessageDialog(null, "Data Berhasil ditambah");
                    dispose();
                    new PunyaCustomer(cek).setVisible(true);
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
}
}