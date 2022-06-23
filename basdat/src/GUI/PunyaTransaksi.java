package GUI;
import Entity.*;
import Helper.KoneksiDb;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PunyaTransaksi extends ComponentGUI{
    JTable tabelproduk = new JTable();
    JScrollPane spproduk = new JScrollPane(tabelproduk);
    JTable tabelkeranjang = new JTable();
    JScrollPane spkeranjang = new JScrollPane(tabelkeranjang);
    DefaultTableModel model = new DefaultTableModel();
    JTextField textpilih = new JTextField();
    JTextField fieldidd = new JTextField();
    JTextField fieldnama = new JTextField();
    JTextField fieldharga = new JTextField();
    JTextField fieldjumlahharga = new JTextField();
    JTextField fieldtotal = new JTextField();
    JTextField fieldjumlahbeli = new JTextField();
    
    int id_trx;
    
    public PunyaTransaksi(int cek,int kode) {
        initComponent(cek,kode);
    }
    
    void initComponent(int cek,int kode){
        setTitle("DATA TRANSASKI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300,550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        spproduk.setBounds(20, 50, 500, 350);
        tabelproduk.setModel(AllObjectController.produk.dataProduk());
        add(spproduk);
        
        Object[]kolom = {"id","Nama","Harga","Jumlah","Jumlah Harga"};
        spkeranjang.setBounds(710, 50, 500, 350);
        model.setColumnIdentifiers(kolom);
        tabelkeranjang.setModel(model);
        add(spkeranjang);
        
        
        btntambah.setBounds(550, 95, 130, 25);
        btntambah.setFocusPainted(false);
        btntambah.setBorder(null);
        btntambah.setBackground(Color.black);
        btntambah.setForeground(Color.white);
        add(btntambah);
        
        btnkeranjang.setBounds(176, 421, 220, 48);
        btnkeranjang.setFocusPainted(false);
        btnkeranjang.setBorder(null);
        btnkeranjang.setBackground(Color.black);
        btnkeranjang.setForeground(Color.white);
        add(btnkeranjang);
        
        
        labeltotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labeltotal.setBounds(800, 421, 220, 48);
        this.add(labeltotal);

      
        fieldtotal.setColumns(10);
        fieldtotal.setBounds(860, 421, 220, 48);
        fieldtotal.setEditable(false);
        this.add(fieldtotal);
        
        tabelproduk.addMouseListener(new MouseAdapter(){
            private String nama_barang;
            private int harga,qty,jumlah_harga,id;
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelproduk.getSelectedRow();
                textpilih.setText(AllObjectController.produk.dataProduk().getValueAt(i, 0).toString());
                id=AllObjectController.produk.getDataProduk().get(i).getId_produk();
                nama_barang=AllObjectController.produk.getDataProduk().get(i).getNama_produk();
                harga=AllObjectController.produk.getDataProduk().get(i).getHarga();
                fieldid.setText(String.valueOf(id));
                fieldnama.setText(String.valueOf(nama_barang));
                fieldharga.setText(String.valueOf(harga));
                
            }
        });
        
        btntambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
              Transaksi(cek,kode);
                 
            }
        });
        
        btnkeranjang.addActionListener(new ActionListener()
        {
            Object[]row = new Object[6];
            int total=0;
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int banyak = Integer.parseInt(JOptionPane.showInputDialog(null,"Masukkan Banyak Produk"));
                row[0]=fieldid.getText();
                row[1]=fieldnama.getText();
                row[2]=fieldharga.getText();
                row[3]=banyak;
                fieldjumlahbeli.setText(String.valueOf(banyak));
                int harga=Integer.parseInt(fieldharga.getText());
                int jumlah_harga=harga*banyak;
                row[4]=jumlah_harga;
                
                model.addRow(row);
                int size=tabelkeranjang.getRowCount();
                int sum=0;
                for(int i=0;i<size;i++)
                {
                    sum +=Integer.parseInt(String.valueOf(tabelkeranjang.getValueAt(i,4 )));
                }
                fieldtotal.setText(String.valueOf(sum));
                
            }
            
        }
        );
}
    
    public void Transaksi(int id_kasir,int id_customer)
    {
        String sql;
        int rows=0;
        int total=Integer.parseInt(fieldtotal.getText());
        Connection conn=KoneksiDb.getconection();
        
        try
        {
            sql="select id_trx from penjualan order by id_trx desc limit 1";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs=stat.executeQuery();
            if(rs.next()){
                rows = rs.getInt("id_trx");
                rows += 1;
            }
            sql="INSERT INTO penjualan (id_trx, total_harga, id_kasir, id_customer) VALUES (?,?,?,?)";
            stat = conn.prepareStatement(sql);
            stat.setInt(1, rows);
            stat.setInt(2, total );
            stat.setInt(3, id_kasir);
            stat.setInt(4, id_customer);
            stat.executeUpdate();
            DetailTransaksi(rows);
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void DetailTransaksi(int id_penjualan)
    {
        String sql;
        Connection conn=KoneksiDb.getconection();
        
        try
        {
            sql="insert into detail_transaksi(id_produk,id_penjualan,jumlah_pembelian,jumlah_harga) VALUES (?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat = conn.prepareStatement(sql);
            int id_produk,jumlah_pembelian,jumlah_harga;
            
            int size=tabelkeranjang.getRowCount();
            for(int i=0;i<size;i++)
            {
                 id_produk=Integer.parseInt(String.valueOf(tabelkeranjang.getValueAt(i, 0)));
                 jumlah_pembelian=Integer.parseInt(String.valueOf(tabelkeranjang.getValueAt(i, 3)));
                 jumlah_harga=Integer.parseInt(String.valueOf(tabelkeranjang.getValueAt(i, 4)));
                 stat.setInt(1, id_produk);
                 stat.setInt(2, id_penjualan);
                 stat.setInt(3, jumlah_pembelian);
                 stat.setInt(4, jumlah_harga);
                 stat.executeUpdate();
            }
            
        }catch(SQLException e)
        {
            e.printStackTrace();;
        }
    }
    
    
    }

