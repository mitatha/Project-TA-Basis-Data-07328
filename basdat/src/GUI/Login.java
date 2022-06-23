package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Login extends ComponentGUI
{
    public Login() 
    {
        initComponent();
    }
    
    void initComponent()
    {
        setTitle("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelidlogin.setBounds(35, 290, 60, 25);
        add(labelidlogin);
        fieldid.setBounds(130, 290, 130, 25);
        add(fieldid);
        
        labelpasslogin.setBounds(35, 335, 100, 25);
        add(labelpasslogin);
        fieldpass.setBounds(130, 335, 130, 25);
        add(fieldpass);
        
        btnlogin.setBounds(130,400 , 60, 25);
        btnlogin.setForeground(Color.white);
        btnlogin.setBackground(Color.black);
        btnlogin.setFocusPainted(false);
        btnlogin.setBorder(null);
        add(btnlogin);
        
        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int cek1;
                int cek2; 
                int id = Integer.parseInt(fieldid.getText());
                String pass = fieldpass.getText();
                cek1=AllObjectController.admin.login(id, pass);
                cek2=AllObjectController.kasir.loginkasir(id, pass);
                if(pass.isEmpty()||fieldid.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Tidak Boleh kosong");
                }
                else
                {
                    if(cek1>0){
                        JOptionPane.showMessageDialog(null,"Login Sebagai Admin");
                        dispose();
                        new MenuAdmin(cek1) ;
                    }else if(cek2>0){
                        JOptionPane.showMessageDialog(null,"Login Sebagai Kasir");
                        new MenuKasir(cek2);
                    }else{
                        JOptionPane.showMessageDialog(null,"ID/PASS SALAH");
                    }
                }
            }
        });
        
        
        btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnlogin.setForeground(Color.WHITE);
                btnlogin.setBackground(Color.PINK);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });
        
        bingkaigambar.setBounds(30,50,250,250);
        add(bingkaigambar);
        
        String pathicon = "./src/Images/salon.jpeg";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
    }
}
