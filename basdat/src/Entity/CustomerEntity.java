package Entity;


public class CustomerEntity extends ManusiaEntity{
    private int id_customer;
    private String alamat_customer;

    public CustomerEntity(int id_customer,  String nama, String alamat_customer,String noTelp) {
        super(nama, noTelp);
        this.id_customer = id_customer;
        this.alamat_customer = alamat_customer;
    }

    public CustomerEntity() {}

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getAlamat_customer() {
        return alamat_customer;
    }

    public void setAlamat_customer(String alamat_customer) {
        this.alamat_customer = alamat_customer;
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
