package Entity;
import Entity.*;

public class ProdukEntity {
    protected String nama_produk,deskripsi_produk,nama_kategori,nama_suplier;
    protected int id_produk,id_kategori,id_suplier,harga;
    
    public ProdukEntity(int id_produk, String nama_produk, String deskripsi_produk, int harga, int id_kategori, int id_suplier,String nama_kategori,String nama_suplier) {
        this.id_produk = id_produk;
        this.nama_produk = nama_produk;
        this.deskripsi_produk = deskripsi_produk;
        this.harga = harga;
        this.id_kategori = id_kategori;
        this.id_suplier = id_suplier;
        this.nama_kategori=nama_kategori;
        this.nama_suplier=nama_suplier;
    }
    
    public ProdukEntity(int id_produk,String nama_produk,int harga )
    {
        this.id_kategori=id_produk;
        this.nama_produk=nama_produk;
        this.harga=harga;
    }
    
    public ProdukEntity(int id_produk,String nama_produk,String deskripsi_produk,int harga,int id_kategori,int id_suplier )
    {
        this.id_produk=id_produk;
        this.nama_produk=nama_produk;
        this.deskripsi_produk=deskripsi_produk;
        this.harga=harga;
        this.id_kategori=id_kategori;
        this.id_suplier=id_suplier;
    }
    
    public ProdukEntity(){}

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getDeskripsi_produk() {
        return deskripsi_produk;
    }

    public void setDeskripsi_produk(String deskripsi_produk) {
        this.deskripsi_produk = deskripsi_produk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public int getId_suplier() {
        return id_suplier;
    }

    public void setId_suplier(int id_suplier) {
        this.id_suplier = id_suplier;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getNama_suplier() {
        return nama_suplier;
    }

    public void setNama_suplier(String nama_suplier) {
        this.nama_suplier = nama_suplier;
    }

    
    
    
    
}
