public class StrunovyNastroj extends Nastroj {

    private int pocetStrun;
    private String Ladenie;

    public StrunovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetStrun, String Ladenie) {
        super(druh, cena, zvuk, pocet);
        this.pocetStrun = pocetStrun;
        this.Ladenie = "Standardne";
    }

    public int getPocetStrun() {
        return pocetStrun;
    }

    public void setPocetStrun(int pocetStrun) {
        this.pocetStrun = pocetStrun;
    }

    public String getLadenie() {
        return Ladenie;
    }

    public void setLadenie(String ladenie) {
        Ladenie = ladenie;
    }

    @Override
    public String toString() {
        return "StrunovyNastroj{" +
                "pocetStrun=" + pocetStrun +
                ", druh='" + getDruh() + '\'' +
                ", cena=" + getCena() +
                ", zvuk='" + getZvuk() + '\'' +
                ", pocet=" + getPocet() +
                ", ladenie='" + Ladenie + '\'' +
                '}';
    }
    
}
