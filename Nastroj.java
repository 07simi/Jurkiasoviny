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
        if (druh == null || druh.trim().isEmpty()) {
            throw new IllegalArgumentException("Druh nástroja nesmie byť prázdny.");
        }
        if (!druh.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Druh nástroja môže obsahovať iba písmená a medzery.");
        }
        this.druh = druh;
    }

    public double getCena() { return cena; }
    public void setCena(double cena) {
        if (cena < 0) {
            throw new IllegalArgumentException("Cena nástroja nesmie byť záporná.");
        }
        this.cena = cena;
    }

    public String getZvuk() { return zvuk; }
    public void setZvuk(String zvuk) {
        if (zvuk == null || zvuk.trim().isEmpty()) {
            throw new IllegalArgumentException("Zvuk nástroja nesmie byť prázdny.");
        }
        if (!zvuk.matches("[a-zA-Z\\s\\-]+")) {
            throw new IllegalArgumentException("Zvuk nástroja môže obsahovať iba písmená, medzery a pomlčky.");
        }
        this.zvuk = zvuk;
    }

    public int getPocet() { return pocet; }
    public void setPocet(int pocet) {
        if (pocet < 0) {
            throw new IllegalArgumentException("Počet nástrojov nesmie byť záporný.");
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
