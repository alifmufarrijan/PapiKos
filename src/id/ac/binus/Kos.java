package id.ac.binus;

public class Kos {
    String idKos;
    String namaKos;
    String alamatKos;
    float hargaSewa;
    String fasilitas;
    String daerah;
    int jmlKamar;

    public Kos(String idKos, String namaKos, String alamatKos, float hargaSewa, String fasilitas, String daerah, int jmlKamar) {
        this.idKos = idKos;
        this.namaKos = namaKos;
        this.alamatKos = alamatKos;
        this.hargaSewa = hargaSewa;
        this.fasilitas = fasilitas;
        this.daerah = daerah;
        this.jmlKamar = jmlKamar;
    }

    public Kos() {
    }

    public Kos(Kos kos){
        this.idKos = kos.getIdKos();
        this.namaKos = kos.getNamaKos();
        this.alamatKos = kos.getAlamatKos();
        this.hargaSewa = kos.getHargaSewa();
        this.fasilitas = kos.getFasilitas();
        this.daerah = kos.getDaerah();
        this.jmlKamar = kos.getJmlKamar();
    }

    public String getIdKos() {
        return idKos;
    }

    public void setIdKos(String idKos) {
        this.idKos = idKos;
    }

    public String getNamaKos() {
        return namaKos;
    }

    public void setNamaKos(String namaKos) {
        this.namaKos = namaKos;
    }

    public String getAlamatKos() {
        return alamatKos;
    }

    public void setAlamatKos(String alamatKos) {
        this.alamatKos = alamatKos;
    }

    public float getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(float hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public int getJmlKamar() {
        return jmlKamar;
    }

    public void setJmlKamar(int jmlKamar) {
        this.jmlKamar = jmlKamar;
    }

    @Override
    public String toString() {
        return "Kos{" +
                "idKos='" + idKos + '\'' +
                ", namaKos='" + namaKos + '\'' +
                ", alamatKos='" + alamatKos + '\'' +
                ", hargaSewa=" + hargaSewa +
                ", fasilitas='" + fasilitas + '\'' +
                ", daerah='" + daerah + '\'' +
                ", jmlKamar=" + jmlKamar +
                '}';
    }
}
