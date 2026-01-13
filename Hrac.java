public class Hrac {

    private String meno;
    private String priezvisko;
    private String nastroj;
    private double hodinovaSadzba;
    private Nastroj priradenyNastroj;

    public Hrac(String meno, String priezvisko, String nastroj, double hodinovaSadzba) {
        setMeno(meno);
        setPriezvisko(priezvisko);
        setNastroj(nastroj);
        setHodinovaSadzba(hodinovaSadzba);
    }

    public String getMeno() { return meno; }
    public void setMeno(String meno) {
        if (meno == null || meno.trim().isEmpty()) {
            throw new IllegalArgumentException("Meno nesmie byť prázdne.");
        }
        if (!meno.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Meno môže obsahovať iba písmená a medzery.");
        }
        this.meno = meno;
    }

    public String getPriezvisko() { return priezvisko; }
    public void setPriezvisko(String priezvisko) {
        if (priezvisko == null || priezvisko.trim().isEmpty()) {
            throw new IllegalArgumentException("Priezvisko nesmie byť prázdne.");
        }
        if (!priezvisko.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Priezvisko môže obsahovať iba písmená a medzery.");
        }
        this.priezvisko = priezvisko;
    }

    public String getNastroj() { return nastroj; }
    public void setNastroj(String nastroj) {
        if (nastroj == null || nastroj.trim().isEmpty()) {
            throw new IllegalArgumentException("Nástroj nesmie byť prázdny.");
        }
        if (!nastroj.matches("[a-zA-Z0-9\\s\\.]+")) {
            throw new IllegalArgumentException("Nástroj môže obsahovať iba písmená, čísla, medzery a bodky.");
        }
        this.nastroj = nastroj;
    }

    public double getHodinovaSadzba() { return hodinovaSadzba; }
    public void setHodinovaSadzba(double hodinovaSadzba) {
        if (hodinovaSadzba < 0) {
            throw new IllegalArgumentException("Hodinová sadzba nesmie byť záporná.");
        }
        this.hodinovaSadzba = hodinovaSadzba;
    }

    public Nastroj getPriradenyNastroj() { return priradenyNastroj; }
    public void setPriradenyNastroj(Nastroj priradenyNastroj) { this.priradenyNastroj = priradenyNastroj; }

    @Override
    public String toString() {
        return "Hrac{" +
                "meno='" + meno + '\'' +
                ", priezvisko='" + priezvisko + '\'' +
                ", nastroj='" + nastroj + '\'' +
                ", hodinovaSadzba=" + hodinovaSadzba +
                ", priradenyNastroj=" + (priradenyNastroj != null ? priradenyNastroj.getDruh() : "žiadny") +
                '}';
    }
}

