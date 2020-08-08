package id.ac.binus;

public class TransaksiKos {
    String entity1;
    int entity2;

    public TransaksiKos(String entity1, int entity2) {
        this.entity1 = entity1;
        this.entity2 = entity2;
    }

    public TransaksiKos() {
    }

    public String getEntity1() {
        return entity1;
    }

    public void setEntity1(String entity1) {
        this.entity1 = entity1;
    }

    public int getEntity2() {
        return entity2;
    }

    public void setEntity2(int entity2) {
        this.entity2 = entity2;
    }
}
