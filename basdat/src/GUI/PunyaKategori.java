package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PunyaKategori extends ComponentGUI
{
    JTable tabelkategori = new JTable();
    JScrollPane spkategori = new JScrollPane(tabelkategori);
    JTextField textpilih = new JTextField();
    
    public PunyaKategori(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("DATA KATEGORI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        spkategori.setBounds(20, 50, 400, 200);
        tabelkategori.setModel(AllObjectController.kategori.dataKategori());
        add(spkategori);
        
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
        
        tabelkategori.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelkategori.getSelectedRow();
                textpilih.setText(AllObjectController.kategori.dataKategori().getValueAt(i, 0).toString());
            }
        });
}
}