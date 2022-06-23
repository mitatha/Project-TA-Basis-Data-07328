package GUI;
import Entity.ProdukEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class TambahProduk extends ComponentGUI {
    JTable tabelproduk1 = new JTable();
    
    public TambahProduk(int cek) 
    {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("Tambah Data Produk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelidproduk.setBounds(50, 95, 80, 25);
        add(labelidproduk);
        fieldidproduk.setBounds(200, 95, 130, 25);
        add(fieldidproduk);
        
        labelnamaproduk.setBounds(50, 140, 80, 25);
        add(labelnamaproduk);
        fieldnamaproduk.setBounds(200, 140, 130, 25);
        add(fieldnamaproduk);
        
        labeldesk.setBounds(50, 185, 100, 25);
        add(labeldesk);
        fielddesk.setBounds(200, 185, 130, 25);
        add(fielddesk);
        
        labelharga.setBounds(50, 230, 80, 25);
        add(labelharga);
        fieldharga.setBounds(200, 230, 130, 25);
        add(fieldharga);
        
        labelidkategori.setBounds(50, 275, 80, 25);
        add(labelidkategori);
        fieldkategori.setBounds(200, 275, 130, 25);
        add(fieldkategori);
        
        labelidsuplier.setBounds(50, 315, 80, 25);
        add(labelidsuplier);
        fieldsuplier.setBounds(200, 315, 130, 25);
        add(fieldsuplier);
        
        btntambahproduk.setBounds(210, 400, 140, 25);
        btntambahproduk.setBorder(null);
        btntambahproduk.setBackground(Color.black);
        btntambahproduk.setForeground(Color.white);
        btntambahproduk.setFocusPainted(false);
        add(btntambahproduk);
        
        btnback.setBounds(35, 400, 80, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setBorder(null);
        btnback.setFocusPainted(false);
        add(btnback);
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new PunyaProduk(cek).setVisible(true);
            }
        });
        
        btntambahproduk.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btntambahproduk.setForeground(Color.black);
                btntambahproduk.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btntambahproduk.setForeground(Color.white);
                btntambahproduk.setBackground(Color.black);
            }
        });
        
        btntambahproduk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int idpro = Integer.parseInt(fieldidproduk.getText());
                String nama = fieldnamaproduk.getText();
                String desk = fielddesk.getText();
                int harga = Integer.parseInt(fieldharga.getText());
                int idkat = Integer.parseInt(fieldkategori.getText());
                int idsup = Integer.parseInt(fieldsuplier.getText());
                
                if(fieldidproduk.getText().length()!=0 && 
                        fieldnamaproduk.getText().length()!=0 &&
                        fielddesk.getText().length()!=0 && 
                        fieldharga.getText().length()!=0 && 
                        fieldsuplier.getText().length()!=0  && 
                        fieldkategori.getText().length()!=0  ){   
                    
                    
                    AllObjectController.produk.produkEntity(new ProdukEntity(idpro, nama,desk,harga,idkat,idsup));
                    JOptionPane.showMessageDialog(null, "Data Berhasil ditambah");
                    tabelproduk1.setModel(AllObjectController.produk.dataProduk1());
                    dispose();
                    new PunyaProduk(cek).setVisible(true);
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