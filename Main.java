import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Nastroj> nastrojList = new ArrayList<>();
        ArrayList<Hrac> hracList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("skladNastrojov.txt"))) {
            String riadok;
            while ((riadok = br.readLine()) != null) {
                String[] casti = riadok.split(",");
                if (casti.length < 2) continue;
                String typ = casti[0].trim();
                try {
                    if (typ.equals("u")) {
                        if (casti.length != 5) continue;
                        Hrac hrac = new Hrac("", "", null, 0);
                        hrac.load(casti);
                        hracList.add(hrac);
                    } else {
                        Nastroj nastroj = null;
                        switch (typ) {
                            case "S":
                                if (casti.length != 8) throw new IllegalArgumentException("Nesprávny počet údajov pre sláčikový nástroj");
                                nastroj = new SlacikovyNastroj("", 0, "", 0, 0, "", "");
                                nastroj.load(casti);
                                break;
                            case "s":
                                if (casti.length != 7) throw new IllegalArgumentException("Nesprávny počet údajov pre strunový nástroj");
                                nastroj = new StrunovyNastroj("", 0, "", 0, 0, "");
                                nastroj.load(casti);
                                break;
                            case "d":
                                if (casti.length != 7) throw new IllegalArgumentException("Nesprávny počet údajov pre dychový nástroj");
                                nastroj = new DychovyNastroj("", 0, "", 0, 0, "");
                                nastroj.load(casti);
                                break;
                            case "r":
                                if (casti.length != 6) throw new IllegalArgumentException("Nesprávny počet údajov pre rytmický nástroj");
                                nastroj = new RytmickyNastroj("", 0, "", 0, 0);
                                nastroj.load(casti);
                                break;
                            case "k":
                                if (casti.length != 6) throw new IllegalArgumentException("Nesprávny počet údajov pre klávesový nástroj");
                                nastroj = new KlavesovyNastroj("", 0, "", 0, 0);
                                nastroj.load(casti);
                                break;
                            default:
                                throw new IllegalArgumentException("Neznámy typ nástroja: " + typ);
                        }
                        if (nastroj != null) {
                            nastrojList.add(nastroj);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Chyba: " + riadok + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Chyba pri čítaní: " + e.getMessage());
        }

        for (Hrac h : hracList) {
            for (Nastroj n : nastrojList) {
                if (n instanceof SlacikovyNastroj && ((SlacikovyNastroj) n).getSekcia().equals(h.getInstrumentName())) {
                    h.setNastroj(n);
                    break;
                }
            }
            if (h.getNastroj() == null) {
                for (Nastroj n : nastrojList) {
                    if (n.getDruh().equals(h.getInstrumentName())) {
                        h.setNastroj(n);
                        break;
                    }
                }
            }
        }

        System.out.println("Zoznam hráčov:");
        for (Hrac h : hracList) {
            System.out.println(h.getMeno() + " " + h.getPriezvisko());
        }

        System.out.println("\nDatabáza nástrojov:");
        for (Nastroj n : nastrojList) {
            System.out.println(n.getDruh() + "," + n.getPocet() + "," + n.getCena());
        }

        double cenaSkladu = 0;
        for (Nastroj n : nastrojList) {
            cenaSkladu += n.getPocet() * n.getCena();
        }
        System.out.println("\nCena skladu: " + cenaSkladu);

        int hodiny = 2;
        double cenaVystupenia = 0;
        for (Hrac h : hracList) {
            cenaVystupenia += h.getHodinovaSadzba();
        }
        cenaVystupenia *= hodiny;
        System.out.println("Cena vystúpenia (" + hodiny + " hodín): " + cenaVystupenia);

        System.out.println("\nSklad hraj:");
        for (Nastroj n : nastrojList) {
            for (int i = 0; i < n.getPocet(); i++) {
                System.out.print(n.getZvuk() + " ");
            }
        }
        System.out.println();

        Lod lod = new Lod("Titanic", "Tuuuut", 50000.0);
        System.out.println("\n" + lod);

        System.out.println("\nAkord");
        for (Nastroj n : nastrojList) {
            System.out.print(n.getZvuk() + " ");
        }
        System.out.println(lod.vydajZvuk());

        System.out.println("\nNáklady vystúpenia");
        double nakladyVystupenia = 0;
        for (Hrac h : hracList) {
            nakladyVystupenia += h.getHodinovaSadzba() * hodiny;
        }
        for (Nastroj n : nastrojList) {
            nakladyVystupenia += n.getCena() * n.getPocet() * 0.02;
        }
        System.out.println("Celkové náklady vystúpenia: " + nakladyVystupenia);

        System.out.println("\nObsadenie orchestra");
        for (Hrac h : hracList) {
            String nastrojInfo = (h.getNastroj() != null) ? h.getNastroj().getDruh() : "Nástroj nie je v sklade";
            System.out.println(h.getMeno() + " " + h.getPriezvisko() + " - " + nastrojInfo);
        }

        System.out.println("\nOrchester hraj");
        for (Hrac h : hracList) {
            if (h.getNastroj() != null) {
                System.out.print(h.getNastroj().getZvuk() + " ");
            }
        }
        System.out.println();

        System.out.println("\nKrst lode");
        for (Hrac h : hracList) {
            if (h.getNastroj() != null) {
                System.out.print(h.getNastroj().getZvuk() + " ");
            }
        }
        System.out.print(lod.vydajZvuk() + " ");
        lod.spustiNaVodu();
        System.out.println("\nLoď bola spustená na vodu! Stav lode: " + lod);
    }
}
