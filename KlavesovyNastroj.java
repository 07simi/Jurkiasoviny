public class KlavesovyNastroj extends Nastroj {
    private int pocetKlavies;

    public KlavesovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetKlavies) {
        super(druh, cena, zvuk, pocet);
        this.pocetKlavies = pocetKlavies;
    }

    public int getPocetKlavies() {
        return pocetKlavies;
    }

    public void setPocetKlavies(int pocetKlavies) {
        this.pocetKlavies = pocetKlavies;
    }

    @Override
    public String toString() {
        return "KlavesovyNastroj{" +
                "pocetKlavies=" + pocetKlavies +
                ", druh='" + getDruh() + '\'' +
                ", cena=" + getCena() +
                ", zvuk='" + getZvuk() + '\'' +
                ", pocet=" + getPocet() +
                '}';
    }
    
}
