package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PunyaAdmin extends ComponentGUI {
    
    JTable tabeladmin = new JTable();
    JScrollPane spadmin = new JScrollPane(tabeladmin);
    JTextField textpilih = new JTextField();
    int kode;
    
    public PunyaAdmin(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("DATA ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setVisible(true);
        
        spadmin.setBounds(20, 50, 500, 350);
        tabeladmin.setModel(AllObjectController.admin.dataAdmin());
        add(spadmin);
        
        btndelete.setBounds(550, 50, 130, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btntambahadmin.setBounds(550, 95, 130, 25);
        btntambahadmin.setFocusPainted(false);
        btntambahadmin.setBorder(null);
        btntambahadmin.setBackground(Color.black);
        btntambahadmin.setForeground(Color.white);
        add(btntambahadmin);
        
        btnupdateadmin.setBounds(550, 135, 130, 25);
        btnupdateadmin.setFocusPainted(false);
        btnupdateadmin.setBorder(null);
        btnupdateadmin.setBackground(Color.black);
        btnupdateadmin.setForeground(Color.white);
        add(btnupdateadmin);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        tabeladmin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabeladmin.getSelectedRow();
                textpilih.setText(AllObjectController.admin.dataAdmin().getValueAt(i, 0).toString());
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuAdmin(cek).setVisible(true);
            }
        });
        
        btndelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                AllObjectController.admin.delete(textpilih.getText());
                tabeladmin.setModel(AllObjectController.admin.dataAdmin());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });
        
        btntambahadmin.addActionListener(e ->{
            dispose();
            new TambahAdmin(cek).setVisible(true);
        });
        
         btnupdateadmin.addActionListener(e ->{
            dispose();
            new UpdateAdmin(textpilih.getText(),cek).setVisible(true);
        });
        
}
}
