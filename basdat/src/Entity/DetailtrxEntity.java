package Entity;


public class DetailtrxEntity 
{
    protected int id_produk,id_transaksi,jumlah_pembelian,jumlah_harga;
    protected String nama_produk;
    public DetailtrxEntity(int id_produk, int id_transaksi, int jumlah_pembelian, int jumlah_harga,String nama_produk) {
        this.id_produk = id_produk;
        this.id_transaksi = id_transaksi;
        this.jumlah_pembelian = jumlah_pembelian;
        this.jumlah_harga = jumlah_harga;
        this.nama_produk=nama_produk;
    }
    
    public DetailtrxEntity (){}

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getJumlah_pembelian() {
        return jumlah_pembelian;
    }

    public void setJumlah_pembelian(int jumlah_pembelian) {
        this.jumlah_pembelian = jumlah_pembelian;
    }

    public int getJumlah_harga() {
        return jumlah_harga;
    }

    public void setJumlah_harga(int jumlah_harga) {
        this.jumlah_harga = jumlah_harga;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }
    
    
}
