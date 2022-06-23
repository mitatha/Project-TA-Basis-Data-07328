package GUI;
import Entity.KasirEntity;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UpdateKasir extends ComponentGUI {
    String nama,pw;
    
    public UpdateKasir (String nama,int cek) {
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
        
        for(KasirEntity kasir : AllObjectController.kasir.showDataKasir()) 
        {
            this.nama  = kasir.getNama_kasir();
            this.pw = kasir.getPw_kasir();
        }
        
        btnupdatekasir.setBounds(150, 75, 80, 25);
        btnupdatekasir.setBackground(Color.black);
        btnupdatekasir.setForeground(Color.white);
        btnupdatekasir.setBorder(null);
        btnupdatekasir.setFocusPainted(false);
        add(btnupdatekasir);
        
        btnback.setBounds(35, 200, 80, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setBorder(null);
        btnback.setFocusPainted(false);
        add(btnback);
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new PunyaKasir(cek).setVisible(true);
            }
        });
        
        btnupdatekasir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String update = JOptionPane.showInputDialog("Masukkan Nama baru");
                    if(update.length() > 0){
                        AllObjectController.kasir.update(nama, update);
                        PunyaKasir punyaKasir = new PunyaKasir(cek);
                        punyaKasir.setVisible(true);
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