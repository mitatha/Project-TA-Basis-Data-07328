package GUI;
import Entity.AdminEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class TambahAdmin extends ComponentGUI {
    public TambahAdmin(int cek) 
    {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("Tambah Data Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelidadmin.setBounds(35, 140, 80, 25);
        add(labelidadmin);
        fieldidadmin.setBounds(130, 140, 130, 25);
        add(fieldidadmin);
        
        labelnama.setBounds(35, 95, 40, 25);
        add(labelnama);
        fieldnama.setBounds(130, 95, 130, 25);
        add(fieldnama);
        
        labelnotelp.setBounds(35, 185, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(130, 185, 130, 25);
        add(fieldnotelp);
        
        labelpass.setBounds(35, 220, 80, 25);
        add(labelpass);
        fieldpass.setBounds(130, 220, 130, 25);
        add(fieldpass);
        
        btntambahadmin.setBounds(80, 350, 140, 25);
        btntambahadmin.setBorder(null);
        btntambahadmin.setBackground(Color.black);
        btntambahadmin.setForeground(Color.white);
        btntambahadmin.setFocusPainted(false);
        add(btntambahadmin);
        
        btnback.setBounds(35, 400, 80, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setBorder(null);
        btnback.setFocusPainted(false);
        add(btnback);
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new PunyaAdmin(cek).setVisible(true);
            }
        });
        
        btntambahadmin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btntambahadmin.setForeground(Color.black);
                btntambahadmin.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btntambahadmin.setForeground(Color.white);
                btntambahadmin.setBackground(Color.black);
            }
        });
        
        btntambahadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String nama = fieldnama.getText();
                int id = Integer.valueOf(fieldidadmin.getText());
                String pass = fieldpass.getText();    
                String notelp = fieldnotelp.getText();
                if(fieldidadmin.getText().length()!=0 && nama.length() != 0 &&  notelp.length() != 0 && pass.length() != 0)
                {
                    AllObjectController.admin.adminEntity(new AdminEntity(id,pass, nama, notelp));
                    JOptionPane.showMessageDialog(null, "Data Berhasil ditambah");
                    dispose();
                    new PunyaAdmin(cek).setVisible(true);
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