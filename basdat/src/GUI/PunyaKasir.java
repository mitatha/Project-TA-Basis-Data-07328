package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PunyaKasir extends ComponentGUI
{
    JTable tabelkasir = new JTable();
    JScrollPane spkasir = new JScrollPane(tabelkasir);
    JTextField textpilih = new JTextField();
    
    public PunyaKasir(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("DATA KASIR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        spkasir.setBounds(20, 50, 500, 350);
        tabelkasir.setModel(AllObjectController.kasir.dataKasir());
        add(spkasir);
        
        btndelete.setBounds(550, 50, 130, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btntambahkasir.setBounds(550, 95, 130, 25);
        btntambahkasir.setFocusPainted(false);
        btntambahkasir.setBorder(null);
        btntambahkasir.setBackground(Color.black);
        btntambahkasir.setForeground(Color.white);
        add(btntambahkasir);
        
        btnupdatekasir.setBounds(550, 135, 130, 25);
        btnupdatekasir.setFocusPainted(false);
        btnupdatekasir.setBorder(null);
        btnupdatekasir.setBackground(Color.black);
        btnupdatekasir.setForeground(Color.white);
        add(btnupdatekasir);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        tabelkasir.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelkasir.getSelectedRow();
                textpilih.setText(AllObjectController.kasir.dataKasir().getValueAt(i, 0).toString());
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
                AllObjectController.kasir.delete(textpilih.getText());
                tabelkasir.setModel(AllObjectController.kasir.dataKasir());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });
        
        btntambahkasir.addActionListener(e ->{
            dispose();
            new TambahKasir(cek).setVisible(true);
        });
        
         btnupdatekasir.addActionListener(e ->{
            dispose();
            new UpdateKasir(textpilih.getText(),cek).setVisible(true);
        });

}
}