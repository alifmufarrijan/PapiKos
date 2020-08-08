package id.ac.binus;

public class Daerah {
    String idDaerah;
    String namaDaerah;

    public Daerah(String idDaerah, String namaDaerah) {
        this.idDaerah = idDaerah;
        this.namaDaerah = namaDaerah;
    }

    public Daerah() {
    }

    public String getIdDaerah() {
        return idDaerah;
    }

    public void setIdDaerah(String idDaerah) {
        this.idDaerah = idDaerah;
    }

    public String getNamaDaerah() {
        return namaDaerah;
    }

    public void setNamaDaerah(String namaDaerah) {
        this.namaDaerah = namaDaerah;
    }

    @Override
    public String toString() {
        return "Daerah{" +
                "daerah='" + idDaerah + '\'' +
                ", namaDaerah='" + namaDaerah + '\'' +
                '}';
    }
}
