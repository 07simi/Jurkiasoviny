public class SlacikovyNastroj extends StrunovyNastroj {
    private String sekcia;

    public SlacikovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetStrun, String Ladenie, String sekcia) {
        super(druh, cena, zvuk, pocet, pocetStrun, Ladenie);
        this.sekcia = sekcia;
    }

    public String getSekcia() {
        return sekcia;
    }

    public void setSekcia(String sekcia) {
        this.sekcia = sekcia;
    }

    @Override
    public String toString() {
        return "SlacikovyNastroj{" +
                "sekcia='" + sekcia + '\'' +
                ", " + super.toString() +
                '}';
    }
}