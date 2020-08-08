package id.ac.binus;

public class Kamar {
    String noKamar;
    String idKos;
    boolean isEmpty;

    public Kamar() {
    }

    public Kamar(String noKamar, String idKos, boolean isEmpty) {
        this.noKamar = noKamar;
        this.idKos = idKos;
        this.isEmpty = isEmpty;
    }

    public String getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(String noKamar) {
        this.noKamar = noKamar;
    }

    public String getIdKos() {
        return idKos;
    }

    public void setIdKos(String idKos) {
        this.idKos = idKos;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
