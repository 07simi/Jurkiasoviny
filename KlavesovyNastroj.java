public class KlavesovyNastroj extends Nastroj implements Saveable {
    private int pocetKlavies;

    public KlavesovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetKlavies) {
        super(druh, cena, zvuk, pocet);
        this.pocetKlavies = pocetKlavies;
    }

    public int getPocetKlavies() {
        return pocetKlavies;
    }

    public void setPocetKlavies(int pocetKlavies) {
        if (pocetKlavies < 1) {
            throw new IllegalArgumentException("Počet klávies musí byť aspoň 1");
        }
        this.pocetKlavies = pocetKlavies;
    }

    @Override
    public String save() {
        return "k," + getDruh() + "," + getCena() + "," + getZvuk() + "," + getPocet() + "," + pocetKlavies;
    }

    @Override
    public void load(String[] data) {
        super.load(data);
        if (data.length >= 6) {
            setPocetKlavies(Integer.parseInt(data[5].trim()));
        }
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
