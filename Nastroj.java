public class Nastroj {

    private String druh;
    private double cena;
    private String zvuk;
    private int pocet;

    public Nastroj(String druh, double cena, String zvuk, int pocet) {
        this.druh = druh;
        this.cena = cena;
        this.zvuk = zvuk;
        this.pocet = pocet;
    }

    public String getDruh() { return druh; }
    public void setDruh(String druh) {
        if (druh == null || druh.trim().isEmpty() || !druh.matches("[a-zA-ZáäčďéíľĺňóôŕšťúýžÁÄČĎÉÍĽĹŇÓÔŔŠŤÚÝŽ ]+")) {
            throw new IllegalArgumentException("Neplatný druh nástroja");
        }
        this.druh = druh;
    }

    public double getCena() { return cena; }
    public void setCena(double cena) {
        if (cena < 0) {
            throw new IllegalArgumentException("Cena nesmie byť záporná");
        }
        this.cena = cena;
    }

    public String getZvuk() { return zvuk; }
    public void setZvuk(String zvuk) {
        if (zvuk == null || zvuk.trim().isEmpty()) {
            throw new IllegalArgumentException("Zvuk nesmie byť prázdny");
        }
        this.zvuk = zvuk;
    }

    public int getPocet() { return pocet; }
    public void setPocet(int pocet) {
        if (pocet < 0) {
            throw new IllegalArgumentException("Počet nesmie byť záporný");
        }
        this.pocet = pocet;
    }

    @Override
    public String toString() {
        return "Nastroj{" +
                "druh='" + druh + '\'' +
                ", cena=" + cena +
                ", zvuk='" + zvuk + '\'' +
                ", pocet=" + pocet +
                '}';
    }
}
