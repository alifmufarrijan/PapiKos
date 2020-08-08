package id.ac.binus;

import java.util.Date;

public class Pelanggan {
    String idPelanggan;
    String namaPelanggan;
    String alamat;
    String noHP;
    String email;
    Date tanggalLahir;

    public Pelanggan() {
    }

    public Pelanggan(String idPelanggan, String namaPelanggan, String alamat, String noHP, String email, Date tanggalLahir) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.alamat = alamat;
        this.noHP = noHP;
        this.email = email;
        this.tanggalLahir = tanggalLahir;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pelanggan{" +
                "namaPelanggan='" + idPelanggan + '\'' +
                ", namaPelanggan='" + namaPelanggan + '\'' +
                ", alamatKos='" + alamat + '\'' +
                ", noHP='" + noHP + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
