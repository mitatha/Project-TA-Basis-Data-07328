package Entity;
import Entity.*;

public class PenjualanEntity {
    public static int ID_TERAKHIR;
    protected int id_trx,id_kasir,id_customer,id_produk,total_harga;
    protected String tgl_pesan,tgl_penjualan;
    protected String nama_kasir,nama_customer;

    public PenjualanEntity(int id_trx, String tgl_pesan, String tgl_penjualan, int total_harga,int id_kasir,int id_customer,int id_produk,String nama_kasir,String nama_customer) {
        this.id_trx = id_trx;
        this.tgl_pesan = tgl_pesan;
        this.tgl_penjualan = tgl_penjualan;
        this.total_harga = total_harga;
        this.id_kasir= id_kasir;
        this.id_customer = id_customer;
        this.nama_kasir = nama_kasir;
        this.nama_customer = nama_customer;
    }
    
//    public PenjualanEntity(int id_cust,int total_harga,int id_kasir,int id_customer) {
//        this.id_customer = id_cust;
//        this.total_harga = total_harga;
//        this.id_kasir= id_kasir;
//        this.id_customer = id_customer;
//    }

    public PenjualanEntity() {}

    public int getId_trx() {
        return id_trx;
    }

    public void setId_trx(int id_trx) {
        this.id_trx = id_trx;
    }

    public String getTgl_pesan() {
        return tgl_pesan;
    }

    public void setTgl_pesan(String tgl_pesan) {
        this.tgl_pesan = tgl_pesan;
    }

    public String getTgl_penjualan() {
        return tgl_penjualan;
    }

    public void setTgl_penjualan(String tgl_penjualan) {
        this.tgl_penjualan = tgl_penjualan;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public int getId_kasir() {
        return id_kasir;
    }

    public void setId_kasir(int id_kasir) {
        this.id_kasir = id_kasir;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getNama_kasir() {
        return nama_kasir;
    }

    public void setNama_kasir(String nama_kasir) {
        this.nama_kasir = nama_kasir;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }
    
    
    
}
