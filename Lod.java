public class Lod {
    private String nazov;
    private String zvuk;
    private boolean naVode;
    private double cena;

    public Lod(String nazov, String zvuk, double cena) {
        this.nazov = nazov;
        this.zvuk = zvuk;
        this.naVode = false;
        this.cena = cena;
    }

    public String vydajZvuk() {
        return zvuk;
    }

    public void spustiNaVodu() {
        this.naVode = true;
    }

    public boolean isNaVode() {
        return naVode;
    }

    public String getNazov() {
        return nazov;
    }

    public String getZvuk() {
        return zvuk;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return "Loď: " + nazov + ", na vode: " + naVode + ", zvuk: " + zvuk + ", cena: " + cena;
    }
}
