public class StrunovyNastroj extends Nastroj {

    private int pocetStrun;
    private String Ladenie;

    public StrunovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetStrun, String Ladenie) {
        super(druh, cena, zvuk, pocet);
        this.pocetStrun = pocetStrun;
        this.Ladenie = Ladenie;
    }

    public int getPocetStrun() {
        return pocetStrun;
    }

    public void setPocetStrun(int pocetStrun) {
        if (pocetStrun < 1) {
            throw new IllegalArgumentException("Počet strún musí byť aspoň 1");
        }
        this.pocetStrun = pocetStrun;
    }

    public String getLadenie() {
        return Ladenie;
    }

    public void setLadenie(String ladenie) {
        if (ladenie == null || ladenie.trim().isEmpty()) {
            throw new IllegalArgumentException("Ladenie nesmie byť prázdne");
        }
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
