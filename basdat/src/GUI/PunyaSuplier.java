package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PunyaSuplier extends ComponentGUI {
    JTable tabelsuplier = new JTable();
    JScrollPane spsuplier = new JScrollPane(tabelsuplier);
    JTextField textpilih = new JTextField();
    
    public PunyaSuplier(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("DATA SUPLIER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setVisible(true);
        
        spsuplier.setBounds(20, 50, 500, 350);
        tabelsuplier.setModel(AllObjectController.suplier.dataSuplier());
        add(spsuplier);
        
        btndelete.setBounds(550, 50, 130, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btntambahsuplier.setBounds(550, 95, 130, 25);
        btntambahsuplier.setFocusPainted(false);
        btntambahsuplier.setBorder(null);
        btntambahsuplier.setBackground(Color.black);
        btntambahsuplier.setForeground(Color.white);
        add(btntambahsuplier);
        
        btnupdatesuplier.setBounds(550, 135, 130, 25);
        btnupdatesuplier.setFocusPainted(false);
        btnupdatesuplier.setBorder(null);
        btnupdatesuplier.setBackground(Color.black);
        btnupdatesuplier.setForeground(Color.white);
        add(btnupdatesuplier);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);

        
        tabelsuplier.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelsuplier.getSelectedRow();
                textpilih.setText(AllObjectController.suplier.dataSuplier().getValueAt(i, 0).toString());
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
                AllObjectController.suplier.delete(index);
                tabelsuplier.setModel(AllObjectController.suplier.dataSuplier());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });
        
        btntambahsuplier.addActionListener(e ->{
            dispose();
            new TambahSuplier(cek).setVisible(true);
        });
        
         btnupdatesuplier.addActionListener(e ->{
            dispose();
            new UpdateSuplier(textpilih.getText(),cek).setVisible(true);
        });
}
}