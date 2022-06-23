package Entity;


public class HistoryEntity 
{
  
    protected int id_history,id_admin,id_produk,harga_sebelum,harga_sesudah;;

    public HistoryEntity(int harga_sebelum, int harga_sesudah, int id_history, int id_admin, int id_produk) {
        this.harga_sebelum = harga_sebelum;
        this.harga_sesudah = harga_sesudah;
        this.id_history = id_history;
        this.id_admin = id_admin;
        this.id_produk = id_produk;
    }
    
    public HistoryEntity (){}

    public int getHarga_sebelum() {
        return harga_sebelum;
    }

    public void setHarga_sebelum(int harga_sebelum) {
        this.harga_sebelum = harga_sebelum;
    }

    public int getHarga_sesudah() {
        return harga_sesudah;
    }

    public void setHarga_sesudah(int harga_sesudah) {
        this.harga_sesudah = harga_sesudah;
    }

    public int getId_history() {
        return id_history;
    }

    public void setId_history(int id_history) {
        this.id_history = id_history;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    
}
