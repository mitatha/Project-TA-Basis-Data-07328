package Entity;

public class AdminEntity extends ManusiaEntity
{
    private String pw;
    private int id;

    public AdminEntity(int id, String pw, String nama, String noTelp) {
        super(nama, noTelp);
        this.id = id;
        this.pw = pw;
    }
    public AdminEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
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
