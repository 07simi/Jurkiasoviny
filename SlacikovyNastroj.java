public class SlacikovyNastroj extends StrunovyNastroj implements Saveable {
    private String sekcia;

    public SlacikovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetStrun, String Ladenie, String sekcia) {
        super(druh, cena, zvuk, pocet, pocetStrun, Ladenie);
        this.sekcia = sekcia;
    }

    public String getSekcia() {
        return sekcia;
    }

    public void setSekcia(String sekcia) {
        if (sekcia == null || sekcia.trim().isEmpty()) {
            throw new IllegalArgumentException("Sekcia nesmie byť prázdna");
        }
        this.sekcia = sekcia;
    }

    @Override
    public String save() {
        return "S," + getDruh() + "," + getCena() + "," + getZvuk() + "," + getPocet() + "," + getPocetStrun() + "," + getLadenie() + "," + sekcia;
    }

    @Override
    public void load(String[] data) {
        super.load(data);
        if (data.length >= 8) {
            setSekcia(data[7].trim());
        }
    }

    @Override
    public String toString() {
        return "SlacikovyNastroj{" +
                "sekcia='" + sekcia + '\'' +
                ", " + super.toString() +
                '}';
    }
}