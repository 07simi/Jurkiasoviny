public class Hrac implements Saveable {

    private String meno;
    private String priezvisko;
    private Nastroj nastroj;
    private double hodinovaSadzba;
    private String instrumentName;

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
    public String save() {
        String nazovNastroja = (nastroj != null) ? nastroj.getDruh() : "";
        return "u," + meno + "," + priezvisko + "," + nazovNastroja + "," + hodinovaSadzba;
    }

    @Override
    public void load(String[] data) {
        if (data.length < 5) {
            throw new IllegalArgumentException("Nedostatočne údajov");
        }
        setMeno(data[1].trim());
        setPriezvisko(data[2].trim());
        instrumentName = data[3].trim();
        setHodinovaSadzba(Double.parseDouble(data[4].trim()));
    }

    public String getInstrumentName() {
        return instrumentName;
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

