package GUI;
import Entity.SuplierEntity;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UpdateSuplier extends ComponentGUI {
    String nama,notelp;
    
    public UpdateSuplier (String notelp,int cek) {
        initComponent(notelp,cek);
    }
    
    void initComponent(String notelp,int cek){
        setTitle("UPDATE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setVisible(true);
        
        for(SuplierEntity suplier : AllObjectController.suplier.showDataSuplier()) 
        {
            this.nama  = suplier.getNama();
            this.notelp = suplier.getNoTelp();
        }
        
        btnupdatesuplier.setBounds(150, 115, 120, 45);
        btnupdatesuplier.setBackground(Color.black);
        btnupdatesuplier.setForeground(Color.white);
        btnupdatesuplier.setBorder(null);
        btnupdatesuplier.setFocusPainted(false);
        add(btnupdatesuplier);
        
        btnback.setBounds(35, 200, 80, 25);
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
        
        btnupdatesuplier.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String update = JOptionPane.showInputDialog("Masukkan No.Telp baru");
                    if(update.length() > 0){
                        AllObjectController.suplier.update(notelp,update);
                        PunyaSuplier punyaSuplier = new PunyaSuplier(cek);
                        punyaSuplier.setVisible(true);
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