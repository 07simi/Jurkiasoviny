public class DychovyNastroj extends Nastroj {

    private int pocetDier;
    private String Ladenie;

    public DychovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetDier, String Ladenie) {
        super(druh, cena, zvuk, pocet);
        this.pocetDier = pocetDier;
        this.Ladenie = "Standardne";
    }

    public int getPocetDier() {
        return pocetDier;
    }
    public void setPocetDier(int pocetDier) {
        this.pocetDier = pocetDier;
    }
    public String getLadenie() {
        return Ladenie;
    }
    public void setLadenie(String ladenie) {
        Ladenie = ladenie;
    }
    @Override
    public String toString() {
        return "DychovyNastroj{" +
                "pocetDier=" + pocetDier +
                ", druh='" + getDruh() + '\'' +
                ", cena=" + getCena() +
                ", zvuk='" + getZvuk() + '\'' +
                ", pocet=" + getPocet() +
                ", ladenie='" + Ladenie + '\'' +
                '}';
    }
}
