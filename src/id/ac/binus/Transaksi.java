package id.ac.binus;

import java.util.Date;

public class Transaksi {
    String idTransaksi;
    Date tglTransaksi;
    String kos;
    String noKamar;
    float hargaTotal;
    String namaPelanggan;

    public Transaksi() {
    }

    public Transaksi(String idTransaksi, Date tglTransaksi, float hargaTotal, String namaPelanggan, String kos, String noKamar) {
        this.idTransaksi = idTransaksi;
        this.tglTransaksi = tglTransaksi;
        this.hargaTotal = hargaTotal;
        this.namaPelanggan = namaPelanggan;
        this.kos = kos;
        this.noKamar = noKamar;
    }

    public String getKos() {
        return kos;
    }

    public void setKos(String kos) {
        this.kos = kos;
    }

    public String getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(String noKamar) {
        this.noKamar = noKamar;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public float getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(float hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "idTransaksi='" + idTransaksi + '\'' +
                ", tglTransaksi=" + tglTransaksi +
                ", hargaTotal=" + hargaTotal +
                ", namaPelanggan='" + namaPelanggan + '\'' +
                '}';
    }
}
