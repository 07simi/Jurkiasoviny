public class Hrac {

    private String meno;
    private String priezvisko;
    private Nastroj nastroj;
    private double hodinovaSadzba;

    public Hrac(String meno, String priezvisko, Nastroj nastroj, double hodinovaSadzba) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.nastroj = nastroj;
        this.hodinovaSadzba = hodinovaSadzba;
    }

    public String getMeno() { return meno; }
    public void setMeno(String meno) {
        if (meno == null || meno.trim().isEmpty() || !meno.matches("[a-zA-ZáäčďéíľĺňóôŕšťúýžÁÄČĎÉÍĽĹŇÓÔŔŠŤÚÝŽ ]+")) {
            throw new IllegalArgumentException("Neplatné meno");
        }
        this.meno = meno;
    }

    public String getPriezvisko() { return priezvisko; }
    public void setPriezvisko(String priezvisko) {
        if (priezvisko == null || priezvisko.trim().isEmpty() || !priezvisko.matches("[a-zA-ZáäčďéíľĺňóôŕšťúýžÁÄČĎÉÍĽĹŇÓÔŔŠŤÚÝŽ ]+")) {
            throw new IllegalArgumentException("Neplatné priezvisko");
        }
        this.priezvisko = priezvisko;
    }

    public Nastroj getNastroj() { return nastroj; }
    public void setNastroj(Nastroj nastroj) { this.nastroj = nastroj; }

    public double getHodinovaSadzba() { return hodinovaSadzba; }
    public void setHodinovaSadzba(double hodinovaSadzba) {
        if (hodinovaSadzba < 0) {
            throw new IllegalArgumentException("Hodinová sadzba nesmie byť záporná");
        }
        this.hodinovaSadzba = hodinovaSadzba;
    }

    @Override
    public String toString() {
        return "Hrac{" +
                "meno='" + meno + '\'' +
                ", priezvisko='" + priezvisko + '\'' +
                ", nastroj=" + (nastroj != null ? nastroj.getDruh() : "null") +
                ", hodinovaSadzba=" + hodinovaSadzba +
                '}';
    }
}

