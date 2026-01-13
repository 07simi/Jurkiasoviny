public class StrunovyNastroj extends Nastroj {

    private int pocetStrun;
    private String ladenie;

    public StrunovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetStrun, String ladenie) {
        super(druh, cena, zvuk, pocet);
        this.pocetStrun = pocetStrun;
        this.Ladenie = Ladenie;
    }

    public int getPocetStrun() {
        return pocetStrun;
    }

    public void setPocetStrun(int pocetStrun) {
        if (pocetStrun < 1) {
            throw new IllegalArgumentException("Počet strún musí byť aspoň 1.");
        }
        this.pocetStrun = pocetStrun;
    }

    public String getladenie() {
        return ladenie;
    }

    public void setLadenie(String ladenie) {
        Ladenie = ladenie;
    }

    @Override
    public String toString() {
        return "StrunovyNastroj{" + super.toString() +
                "pocetStrun=" + pocetStrun +
                ", ladenie='" + ladenie + '\'' +
                '}';
    }
    
    @Override
    public void load(String[] data) {
        super.load(data);
        setPocetStrun(Integer.parseInt(data[5]));
        setladenie(data[6]);
    }
}
