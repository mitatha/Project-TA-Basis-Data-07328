package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
    
public class PunyaProduk extends ComponentGUI
{
    JTable tabelproduk1 = new JTable();
    JScrollPane spproduk1 = new JScrollPane(tabelproduk1);
    JTextField textpilih = new JTextField();
    
    public PunyaProduk(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("DATA PRODUK");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setVisible(true);
        
        spproduk1.setBounds(20, 50, 500, 350);
        tabelproduk1.setModel(AllObjectController.produk.dataProduk1());
        add(spproduk1);
        
        btndelete.setBounds(550, 50, 130, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btntambahproduk.setBounds(550, 95, 130, 25);
        btntambahproduk.setFocusPainted(false);
        btntambahproduk.setBorder(null);
        btntambahproduk.setBackground(Color.black);
        btntambahproduk.setForeground(Color.white);
        add(btntambahproduk);
        
        btnupdateproduk.setBounds(550, 135, 130, 25);
        btnupdateproduk.setFocusPainted(false);
        btnupdateproduk.setBorder(null);
        btnupdateproduk.setBackground(Color.black);
        btnupdateproduk.setForeground(Color.white);
        add(btnupdateproduk);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        tabelproduk1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelproduk1.getSelectedRow();
                textpilih.setText(AllObjectController.produk.dataProduk1().getValueAt(i, 0).toString());
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
                int index = Integer.parseInt(textpilih.getText());
                AllObjectController.produk.delete(index);
                tabelproduk1.setModel(AllObjectController.produk.dataProduk1());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });
        
        btntambahproduk.addActionListener(e ->{
            dispose();
            new TambahProduk(cek).setVisible(true);
        });
        
        btnupdateproduk.addActionListener(e ->{
            dispose();
            int indexproduk = Integer.parseInt(textpilih.getText());
            new UpdateProduk(indexproduk,cek).setVisible(true);
        });
        
}
}