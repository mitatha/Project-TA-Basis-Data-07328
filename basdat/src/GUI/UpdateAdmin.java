package GUI;
import Entity.AdminEntity;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UpdateAdmin extends ComponentGUI {
    String nama,pw;
    
    public UpdateAdmin (String nama,int cek) {
        initComponent(nama,cek);
    }
    void initComponent(String nama,int cek){
        setTitle("UPDATE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.MAGENTA);
        setLayout(null);
        setVisible(true);
        
        for(AdminEntity admin : AllObjectController.admin.showDataAdmin()) 
        {
            this.nama  = admin.getNama();
            this.pw = admin.getPw();
        }
        
        btnupdateadmin.setBounds(150, 75, 80, 25);
        btnupdateadmin.setBackground(Color.black);
        btnupdateadmin.setForeground(Color.white);
        btnupdateadmin.setBorder(null);
        btnupdateadmin.setFocusPainted(false);
        add(btnupdateadmin);
        
        btnback.setBounds(35, 200, 80, 25);
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
        
        btnupdateadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String update = JOptionPane.showInputDialog("Masukkan Nama baru");
                    if(update.length() > 0){
                        AllObjectController.admin.update(nama, update);
                        PunyaAdmin punyaAdmin = new PunyaAdmin(cek);
                        punyaAdmin.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex) {        
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
}
}
