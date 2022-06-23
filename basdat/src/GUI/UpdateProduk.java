package GUI;
import Entity.ProdukEntity;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class UpdateProduk extends ComponentGUI{
    int harga,id;
    JTable tabelproduk1 = new JTable();
    
    public UpdateProduk (int indexproduk,int cek) {
        initComponent(indexproduk,cek);
    }
    
    void initComponent(int indexproduk,int cek){
        setTitle("UPDATE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setVisible(true);
        
        for(ProdukEntity produk : AllObjectController.produk.showDataProduk()) 
        {
            this.id = produk.getId_produk();
            this.harga = produk.getHarga();
        }
        
        btnupdateproduk.setBounds(150, 115, 120, 45);
        btnupdateproduk.setBackground(Color.black);
        btnupdateproduk.setForeground(Color.white);
        btnupdateproduk.setBorder(null);
        btnupdateproduk.setFocusPainted(false);
        add(btnupdateproduk);
        
        btnback.setBounds(35, 200, 80, 25);
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
        
        btnupdateproduk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int update = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Harga baru"));
                    if(update > 0){
                        System.out.println(update);
                        AllObjectController.produk.update(update, indexproduk);
                        PunyaProduk punyaProduk = new PunyaProduk(cek);
                        tabelproduk1.setModel(AllObjectController.produk.dataProduk1());
                        punyaProduk.setVisible(true);
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