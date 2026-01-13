public class DychovyNastroj extends Nastroj {

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
            throw new IllegalArgumentException("Počet dier musí byť aspoň 1.");
        }
        this.pocetDier = pocetDier;
    }
    public String getLadenie() {
        return Ladenie;
    }
    public void setLadenie(String ladenie) {
        if (ladenie == null || ladenie.trim().isEmpty()) {
            throw new IllegalArgumentException("Ladenie nesmie byť prázdne.");
        }
        if (!ladenie.matches("[a-zA-Z0-9\\s]+")) {
            throw new IllegalArgumentException("Ladenie môže obsahovať iba písmená, čísla a medzery.");
        }
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
