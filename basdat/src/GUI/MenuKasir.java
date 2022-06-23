package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuKasir extends ComponentGUI {
    public MenuKasir(){}
    public MenuKasir(int cek) 
    {
        initComponent(cek);
    }
    
    void initComponent(int cek)
    {
        setTitle("Menu Kasir");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setVisible(true);
        
        btnaddtrx.setBounds(80, 150, 140, 25);
        btnaddtrx.setBorder(null);
        btnaddtrx.setBackground(Color.black);
        btnaddtrx.setForeground(Color.white);
        btnaddtrx.setFocusPainted(false);
        add(btnaddtrx);
        
        btnlihattrx.setBounds(80, 200, 140, 25);
        btnlihattrx.setBorder(null);
        btnlihattrx.setBackground(Color.black);
        btnlihattrx.setForeground(Color.white);
        btnlihattrx.setFocusPainted(false);
        add(btnlihattrx);
        
        btnback.setBounds(35, 250, 80, 25);
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
        
        btnaddtrx.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                PunyaCustomer punyaCustomer = new PunyaCustomer(cek);
                punyaCustomer.setVisible(true);
                dispose();
            }
        });
        
        /*btnlihattrx.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                PunyaCustomer punyaCustomer = new PunyaCustomer(cek);
                punyaCustomer.setVisible(true);
                dispose();
            }
        });*/

    }
}
