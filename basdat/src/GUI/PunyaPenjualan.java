package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PunyaPenjualan extends ComponentGUI{
    JTable tabelpenjualan = new JTable();
    JScrollPane sppenjualan = new JScrollPane(tabelpenjualan);
    JTextField textpilih = new JTextField();
    
    public PunyaPenjualan(int cek) {
        initComponent(cek);
    }
    
     void initComponent(int cek){
        setTitle("DATA PENJUALAN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        sppenjualan.setBounds(20,50, 700, 400);
        tabelpenjualan.setModel(AllObjectController.penjualan.dataPenjualan());
        add(sppenjualan);
        
        btnback.setBounds(30, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuAdmin(cek).setVisible(true);
            }
        });
        
        tabelpenjualan.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelpenjualan.getSelectedRow();
                textpilih.setText(AllObjectController.penjualan.dataPenjualan().getValueAt(i, 0).toString());
            }
        });
}
}
