package Entity;


public class KasirEntity{
    protected String nama_kasir,pw_kasir,alamat_kasir;
    protected int id_kasir;

    public KasirEntity(int id_kasir, String pw_kasir, String nama_kasir,  String alamat_kasir ) {
        this.id_kasir = id_kasir;
        this.pw_kasir = pw_kasir;
        this.nama_kasir = nama_kasir;
        this.alamat_kasir = alamat_kasir;
        
    }
    
    public KasirEntity(){}

    public String getNama_kasir() {
        return nama_kasir;
    }

    public void setNama_kasir(String nama_kasir) {
        this.nama_kasir = nama_kasir;
    }

    public String getPw_kasir() {
        return pw_kasir;
    }

    public void setPw_kasir(String pw_kasir) {
        this.pw_kasir = pw_kasir;
    }

    public String getAlamat_kasir() {
        return alamat_kasir;
    }

    public void setAlamat_kasir(String alamat_kasir) {
        this.alamat_kasir = alamat_kasir;
    }

    public int getId_kasir() {
        return id_kasir;
    }

    public void setId_kasir(int id_kasir) {
        this.id_kasir = id_kasir;
    }
    

    
}
