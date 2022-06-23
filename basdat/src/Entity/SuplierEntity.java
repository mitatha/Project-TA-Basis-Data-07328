
package Entity;

public class SuplierEntity extends ManusiaEntity {
    private int id_suplier;

    public SuplierEntity(int id_suplier, String nama, String noTelp) {
        super(nama, noTelp);
        this.id_suplier = id_suplier;
    }
    
    public SuplierEntity (){}

    public int getId_suplier() {
        return id_suplier;
    }

    public void setId_suplier(int id_suplier) {
        this.id_suplier = id_suplier;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
    
    
}
