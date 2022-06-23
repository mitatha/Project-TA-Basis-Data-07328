package GUI;
import Entity.SuplierEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class TambahSuplier extends ComponentGUI {
    public TambahSuplier(int cek) 
    {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("Tambah Data Suplier");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelidsuplier.setBounds(35, 95, 80, 25);
        add(labelidsuplier);
        fieldid.setBounds(130, 95, 130, 25);
        add(fieldid);
        
        labelnama.setBounds(35, 140, 40, 25);
        add(labelnama);
        fieldnama.setBounds(130, 140, 130, 25);
        add(fieldnama);
        
        labelnotelp.setBounds(35, 185, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(130, 185, 130, 25);
        add(fieldnotelp);
        
        btntambahsuplier.setBounds(80, 350, 140, 25);
        btntambahsuplier.setBorder(null);
        btntambahsuplier.setBackground(Color.black);
        btntambahsuplier.setForeground(Color.white);
        btntambahsuplier.setFocusPainted(false);
        add(btntambahsuplier);
        
        btnback.setBounds(35, 400, 80, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setBorder(null);
        btnback.setFocusPainted(false);
        add(btnback);
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new PunyaSuplier(cek).setVisible(true);
            }
        });
        
        btntambahsuplier.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btntambahsuplier.setForeground(Color.black);
                btntambahsuplier.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btntambahsuplier.setForeground(Color.white);
                btntambahsuplier.setBackground(Color.black);
            }
        });
        
        btntambahsuplier.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id = Integer.valueOf(fieldid.getText());
                String nama = fieldnama.getText();
                String notelp = fieldnotelp.getText();
                if(fieldid.getText().length()!=0 && nama.length() != 0 &&  notelp.length() != 0 )
                {
                    AllObjectController.suplier.suplierEntity(new SuplierEntity(id, nama, notelp));
                    JOptionPane.showMessageDialog(null, "Data Berhasil ditambah");
                    dispose();
                    new PunyaSuplier(cek).setVisible(true);
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