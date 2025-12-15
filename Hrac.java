public class Hrac {

    private String meno;
    private String priezvisko;
    private String nastroj;
    private double hodinovaSadzba;

    public Hrac(String meno, String priezvisko, String nastroj, double hodinovaSadzba) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.nastroj = nastroj;
        this.hodinovaSadzba = hodinovaSadzba;
    }

    public String getMeno() { return meno; }
    public void setMeno(String meno) { this.meno = meno; }

    public String getPriezvisko() { return priezvisko; }
    public void setPriezvisko(String priezvisko) { this.priezvisko = priezvisko; }

    public String getNastroj() { return nastroj; }
    public void setNastroj(String nastroj) { this.nastroj = nastroj; }

    public double getHodinovaSadzba() { return hodinovaSadzba; }
    public void setHodinovaSadzba(double hodinovaSadzba) { this.hodinovaSadzba = hodinovaSadzba; }

    @Override
    public String toString() {
        return "Hrac{" +
                "meno='" + meno + '\'' +
                ", priezvisko='" + priezvisko + '\'' +
                ", nastroj='" + nastroj + '\'' +
                ", hodinovaSadzba=" + hodinovaSadzba +
                '}';
    }
    
}

