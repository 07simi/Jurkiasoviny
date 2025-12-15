public class Nastroj implements Saveable {

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

    public Nastroj(String[] params) {
        load(params);
    }

    public String getDruh() { return druh; }
    public void setDruh(String druh) { this.druh = druh; }

    public double getCena() { return cena; }
    public void setCena(double cena) { this.cena = cena; }

    public String getZvuk() { return zvuk; }
    public void setZvuk(String zvuk) { this.zvuk = zvuk; }

    public int getPocet() { return pocet; }
    public void setPocet(int pocet) { this.pocet = pocet; }

    @Override
    public String toString() {
        return "Nastroj{" +
                "druh='" + druh + '\'' +
                ", cena=" + cena +
                ", zvuk='" + zvuk + '\'' +
                ", pocet=" + pocet +
                '}';
    }

    @Override
    public String save() {
        return druh + "," + cena + "," + zvuk + "," + pocet;
    }

    @Override
    public void load(String[] data) {
        druh = data[1];
        zvuk = data[3];
        cena = Double.parseDouble(data[2]);
        pocet = Integer.parseInt(data[4]);
    }
}
