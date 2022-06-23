package GUI;
import Entity.CustomerEntity;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UpdateCustomer extends ComponentGUI {
    String notelp;
    int id;
    
    public UpdateCustomer (String notelp,int cek) {
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
        
        for(CustomerEntity customer : AllObjectController.customer.showDataCustomer()) 
        {
            this.id = customer.getId_customer();
            this.notelp = customer.getNoTelp();
        }
        btnupdatecustomer.setBounds(150, 115, 120, 45);
        btnupdatecustomer.setBackground(Color.black);
        btnupdatecustomer.setForeground(Color.white);
        btnupdatecustomer.setBorder(null);
        btnupdatecustomer.setFocusPainted(false);
        add(btnupdatecustomer);
        
        btnback.setBounds(35, 200, 80, 25);
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
        
        btnupdatecustomer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String update = JOptionPane.showInputDialog("Masukkan No.Telp baru");
                    if(update.length() > 0){
                        AllObjectController.customer.update(notelp,update);
                        PunyaCustomer punyaCustomer = new PunyaCustomer(cek);
                        punyaCustomer.setVisible(true);
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