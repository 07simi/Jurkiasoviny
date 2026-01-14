public class DychovyNastroj extends Nastroj implements Saveable {

    private int pocetDier;
    private String Ladenie;

    public DychovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetDier, String Ladenie) {
        super(druh, cena, zvuk, pocet);
        this.pocetDier = pocetDier;
        this.Ladenie = Ladenie;
    }

    public int getPocetDier() {
        return pocetDier;
    }
    public void setPocetDier(int pocetDier) {
        if (pocetDier < 1) {
            throw new IllegalArgumentException("Počet dier musí byť aspoň 1");
        }
        this.pocetDier = pocetDier;
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
    public String save() {
        return "d," + getDruh() + "," + getCena() + "," + getZvuk() + "," + getPocet() + "," + pocetDier + "," + Ladenie;
    }

    @Override
    public void load(String[] data) {
        super.load(data);
        if (data.length >= 7) {
            setPocetDier(Integer.parseInt(data[5].trim()));
            setLadenie(data[6].trim());
        }
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
