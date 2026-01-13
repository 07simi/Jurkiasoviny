public class RytmickyNastroj extends Nastroj {
    private int pocetZvukov;

    public RytmickyNastroj(String druh, double cena, String zvuk, int pocet, int pocetZvukov) {
        super(druh, cena, zvuk, pocet);
        this.pocetZvukov = pocetZvukov;
    }


    public int getPocetZvukov() {
        return pocetZvukov;
    }
    public void setPocetZvukov(int pocetZvukov) {
        if (pocetZvukov < 1) {
            throw new IllegalArgumentException("Počet zvukov musí byť aspoň 1");
        }
        this.pocetZvukov = pocetZvukov;
    }
    @Override
    public String toString() {
        return "RytmickyNastroj{" +
                "pocetZvukov=" + pocetZvukov +
                ", druh='" + getDruh() + '\'' +
                ", cena=" + getCena() +
                ", zvuk='" + getZvuk() + '\'' +
                ", pocet=" + getPocet() +
                '}';
    }
}
