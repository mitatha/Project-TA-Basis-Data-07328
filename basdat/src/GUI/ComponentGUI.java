package GUI;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ComponentGUI extends JFrame
{
    protected JButton btnlogin = new JButton("Login");
    protected JButton btnpilih = new JButton("Pilih");
    protected JButton btnaddtrx = new JButton("Tambah Transaksi");
    protected JButton btnlihattrx = new JButton("Lihat Transaksi");
    protected JButton btnkeluar = new JButton("Keluar");
    protected JButton btnadmin = new JButton("Admin");
    protected JButton btnkasir = new JButton("Kasir");
    protected JButton btnsuplier = new  JButton("Suplier");
    protected JButton btnproduk = new JButton("Produk");
    protected JButton btnkategori = new JButton("Kategori");
    protected JButton btnhistory = new JButton("History");
    protected JButton btnpenjualan = new JButton("Penjualan");
    protected JButton btnubah = new JButton("Ubah");
    protected JButton btnupdateadmin = new JButton("Update Admin");
    protected JButton btnupdatecustomer = new JButton("Update Customer");
    protected JButton btnupdatekasir = new JButton("Update Kasir");
    protected JButton btnupdatesuplier = new JButton("Update Suplier");
    protected JButton btnupdateproduk = new JButton("Update Produk");
    protected JButton btntambahadmin = new JButton("Tambah Admin");
    protected JButton btntambahcustomer = new JButton("Tambah Customer");
    protected JButton btntambahkasir = new JButton("Tambah Kasir");
    protected JButton btntambahproduk = new JButton("Tambah Produk");
    protected JButton btntambahsuplier = new JButton("Tambah Suplier");
    protected JButton btndelete = new JButton("DELETE DATA");
    protected JButton btnback = new JButton("<< BACK");
    protected JButton btntambah = new JButton("CheckOut");
    protected JButton btncetak = new JButton ("Cetak");
    protected JButton btnkeranjang = new JButton ("Masukkan Keranjang");
    
    
    protected JLabel labellogin = new JLabel("SALON KECANTIKAN");
    protected JLabel labelkasir = new JLabel("KASIR");
    protected JLabel labeladmin = new JLabel("ADMIN");
    protected JLabel labeltadmin = new JLabel("TABLE ADMIN");
    protected JLabel labeltkasir = new JLabel("TABLE KASIR");
    protected JLabel labeltsuplier = new JLabel("TABLE SUPLIER");
    protected JLabel labeltproduk = new JLabel("TABLE PRODUK");
    protected JLabel labeltkategori = new JLabel("TABLE KATEGORI");
    protected JLabel labelthistory = new JLabel("TABLE HISTORY");
    protected JLabel labeltpenjualan = new JLabel("TABLE TRANSAKSI");
    protected JLabel labeltambahadmin = new JLabel("TAMBAH DATA ADMIN");
    protected JLabel labelupdateadmin = new JLabel("UPDATE ADMIN");
    protected JLabel labelupdatekasir = new JLabel("UPDATE KASIR");
    protected JLabel labelupdatesuplier = new JLabel("UPDATE SUPLIER");
    protected JLabel labelupdateproduk = new JLabel("UPDATE PRODUK");
    protected JLabel labeldeleteadmin = new JLabel("DELETE ADMIN");
    protected JLabel labeldeletekasir = new JLabel("DELETE KASIR");
    protected JLabel labeldeletesuplier = new JLabel("DELETE SUPLIER");
    protected JLabel labeldeleteproduk = new JLabel("DELETE PRODUK");
    protected JLabel labeldeletepenjualan = new JLabel("DELETE TRANSAKSI");
    protected JLabel labelviewtambahadmin = new JLabel("TAMBAH ADMIN");
    protected JLabel labelviewtambahkasir = new JLabel("TAMBAH KASIR");
    protected JLabel labelviewtambahsuplier = new JLabel("TAMBAH SUPLIER");
    protected JLabel labelviewtambahproduk = new JLabel("TAMBAH PRODUK");
    protected JLabel labelviewtambahpenjualan = new JLabel("TAMBAH TRANSAKSI");
    protected JLabel labeltrx = new JLabel("NOMOR TRANSAKSI");
    protected JLabel labelidlogin = new JLabel("Id");
    protected JLabel labelidadmin = new JLabel("Id");
    protected JLabel labelidproduk = new JLabel("Id");
    protected JLabel labelidsuplier = new JLabel("Id Suplier");
    protected JLabel labelidcustomer = new JLabel("Id");
    protected JLabel labelpasslogin = new JLabel("PASSWORD");
    protected JLabel bingkaigambar = new JLabel();
    protected JLabel labelnama = new JLabel("Nama");
    protected JLabel labelalamat = new JLabel("Alamat");
    protected JLabel labelidkasir = new JLabel("Id");
    protected JLabel labelnotelp = new JLabel("NoTelp");
    protected JLabel labelpass = new JLabel("Password");
    protected JLabel labelpassbaru = new JLabel("Password Baru");
    protected JLabel labelnamaproduk=new JLabel ("Nama Produk");
    protected JLabel labeldesk=new JLabel ("Deskripsi Produk");
    protected JLabel labelharga=new JLabel ("Harga");
    protected JLabel labelidkategori=new JLabel ("Id Kategori");
    protected JLabel labelnotrx=new JLabel ("Id Kategori");
    protected JLabel labeltotal=new JLabel ("TOTAL");
    
    
    
    
    
    protected JTextField fieldid = new JTextField();
    protected JTextField fieldidadmin = new JTextField();
    protected JTextField fieldalamat = new JTextField();
    protected JTextField fieldnama = new JTextField();
    protected JTextField fieldnamaproduk = new JTextField();
    protected JTextField fieldharga = new JTextField();
    protected JTextField fieldnotelp = new JTextField();
    protected JTextField fieldPass = new JTextField();
    protected JTextField fieldpassbaru = new JTextField();
    protected JPasswordField fieldpass = new JPasswordField();
    protected JTextField fielddesk = new JTextField();
    protected JTextField fieldkategori = new JTextField();
    protected JTextField fieldsuplier = new JTextField();
    protected JTextField fieldidproduk = new JTextField();
    BufferedImage bufferedImage = null;
    Image gambarresize;
    
    void kosong()
     {
        fieldid.setText(null);
        fieldpass.setText(null);
        fieldnama.setText(null);
        fieldnotelp.setText(null);
        fieldnamaproduk.setText(null);
        fieldkategori.setText(null);
        fieldsuplier.setText(null);
        fieldalamat.setText(null);
     }
}
