public class StrunovyNastroj extends Nastroj {

    private int pocetStrun;
    private String ladenie;

    public StrunovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetStrun, String ladenie) {
        super(druh, cena, zvuk, pocet);
        this.pocetStrun = pocetStrun;
        this.ladenie = ladenie;
    }

    public StrunovyNastroj(String[] data) {
        super(data);
    }

    public int getPocetStrun() {
        return pocetStrun;
    }

    public void setPocetStrun(int pocetStrun) {
        this.pocetStrun = pocetStrun;
    }

    public String getladenie() {
        return ladenie;
    }

    public void setladenie(String ladenie) {
        this.ladenie = ladenie;
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
