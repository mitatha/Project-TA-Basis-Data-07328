package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MenuAdmin extends ComponentGUI
{

    public MenuAdmin(int cek) 
    {
        initComponent(cek);
    }
    
    void initComponent(int cek)
    {
        setTitle("Menu Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setVisible(true);

        btnadmin.setBounds(80, 50, 140, 25);
        btnadmin.setBorder(null);
        btnadmin.setBackground(Color.black);
        btnadmin.setForeground(Color.white);
        btnadmin.setFocusPainted(false);
        add(btnadmin);
        
        btnkasir.setBounds(80, 90, 140, 25);
        btnkasir.setBorder(null);
        btnkasir.setBackground(Color.black);
        btnkasir.setForeground(Color.white);
        btnkasir.setFocusPainted(false);
        add(btnkasir);
        
        btnsuplier.setBounds(80, 130, 140, 25);
        btnsuplier.setBorder(null);
        btnsuplier.setBackground(Color.black);
        btnsuplier.setForeground(Color.white);
        btnsuplier.setFocusPainted(false);
        add(btnsuplier);
        
        btnproduk.setBounds(80, 170, 140, 25);
        btnproduk.setBorder(null);
        btnproduk.setBackground(Color.black);
        btnproduk.setForeground(Color.white);
        btnproduk.setFocusPainted(false);
        add(btnproduk);
        
        btnkategori.setBounds(80, 210, 140, 25);
        btnkategori.setBorder(null);
        btnkategori.setBackground(Color.black);
        btnkategori.setForeground(Color.white);
        btnkategori.setFocusPainted(false);
        add(btnkategori);
        
        btnhistory.setBounds(80, 250, 140, 25);
        btnhistory.setBorder(null);
        btnhistory.setBackground(Color.black);
        btnhistory.setForeground(Color.white);
        btnhistory.setFocusPainted(false);
        add(btnhistory);
        
        btnpenjualan.setBounds(80, 290, 140, 25);
        btnpenjualan.setBorder(null);
        btnpenjualan.setBackground(Color.black);
        btnpenjualan.setForeground(Color.white);
        btnpenjualan.setFocusPainted(false);
        add(btnpenjualan);
        
        btnback.setBounds(35, 350, 80, 25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setBorder(null);
        btnback.setFocusPainted(false);
        add(btnback);
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login().setVisible(true);
            }
        });
        
      btnadmin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                PunyaAdmin punyaAdmin = new PunyaAdmin(cek);
                punyaAdmin.setVisible(true);
                dispose();
            }
        });
      btnkasir.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                PunyaKasir punyaKasir = new PunyaKasir(cek);
                punyaKasir.setVisible(true);
                dispose();
            }
        });
      btnproduk.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                PunyaProduk punyaProduk = new PunyaProduk(cek);
                punyaProduk.setVisible(true);
                dispose();
            }
        });
      btnkategori.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                PunyaKategori punyaKategori = new PunyaKategori(cek);
                punyaKategori.setVisible(true);
                dispose();
            }
        });
      btnhistory.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                PunyaHistory punyaHistory = new PunyaHistory();
                punyaHistory.setVisible(true);
                dispose();
            }
        });
       btnpenjualan.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                PunyaPenjualan punyaPenjualan = new PunyaPenjualan(cek);
                punyaPenjualan.setVisible(true);
                dispose();
            }
        });
       
        btnsuplier.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                PunyaSuplier punyaSuplier = new PunyaSuplier(cek);
                punyaSuplier.setVisible(true);
                dispose();
            }
        });
    }

}
