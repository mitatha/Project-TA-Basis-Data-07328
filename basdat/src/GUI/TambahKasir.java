package GUI;
import Entity.KasirEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class TambahKasir extends ComponentGUI {
    public TambahKasir(int cek) 
    {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("Tambah Data Kasir");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelidkasir.setBounds(35, 140, 80, 25);
        add(labelidkasir);
        fieldid.setBounds(130, 140, 130, 25);
        add(fieldid);
        
        labelnama.setBounds(35, 95, 40, 25);
        add(labelnama);
        fieldnama.setBounds(130, 95, 130, 25);
        add(fieldnama);
        
        labelalamat.setBounds(35, 185, 80, 25);
        add(labelalamat);
        fieldalamat.setBounds(130, 185, 130, 25);
        add(fieldalamat);
        
        labelpass.setBounds(35, 220, 80, 25);
        add(labelpass);
        fieldpass.setBounds(130, 220, 130, 25);
        add(fieldpass);
        
        btntambahkasir.setBounds(80, 350, 140, 25);
        btntambahkasir.setBorder(null);
        btntambahkasir.setBackground(Color.black);
        btntambahkasir.setForeground(Color.white);
        btntambahkasir.setFocusPainted(false);
        add(btntambahkasir);
        
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
        
        btntambahkasir.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btntambahkasir.setForeground(Color.black);
                btntambahkasir.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btntambahkasir.setForeground(Color.white);
                btntambahkasir.setBackground(Color.black);
            }
        });
        
        btntambahkasir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id = Integer.valueOf(fieldid.getText());
                String pass = fieldpass.getText(); 
                String nama = fieldnama.getText();
                String alamat = fieldalamat.getText();
                if(fieldid.getText().length()!=0 && pass.length() != 0 && nama.length() != 0 &&  alamat.length() != 0 )
                {
                    AllObjectController.kasir.kasirEntity(new KasirEntity(id, pass, nama, alamat));
                    JOptionPane.showMessageDialog(null, "Data Berhasil ditambah");
                    dispose();
                    new PunyaKasir(cek).setVisible(true);
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