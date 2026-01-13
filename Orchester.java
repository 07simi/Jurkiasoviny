import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Orchester {

    public static void main(String[] args) {
        ArrayList<Nastroj> nastrojList = new ArrayList<>();
        ArrayList<Hrac> hracList = new ArrayList<>();

        // Načítanie dát zo súboru
        nacitajData("orchester.txt", nastrojList, hracList);

        // Priradenie nástrojov hráčom
        priradNastroje(hracList, nastrojList);

        // Výpis výsledkov
        System.out.println("Nástroje:");
        for (Nastroj n : nastrojList) {
            System.out.println(n);
        }
        System.out.println("\nHráči:");
        for (Hrac h : hracList) {
            System.out.println(h);
        }
    }

    private static void nacitajData(String subor, ArrayList<Nastroj> nastrojList, ArrayList<Hrac> hracList) {
        try (BufferedReader br = new BufferedReader(new FileReader(subor))) {
            String riadok;
            while ((riadok = br.readLine()) != null) {
                String[] casti = riadok.split(",");
                if (casti.length < 2) continue; // Príliš málo údajov

                String typ = casti[0].trim();
                try {
                    if (typ.equals("u")) {
                        // Hráč: u,meno,priezvisko,nastroj,sadzba
                        if (casti.length != 5) continue;
                        String meno = casti[1].trim();
                        String priezvisko = casti[2].trim();
                        String nastroj = casti[3].trim();
                        double sadzba = Double.parseDouble(casti[4].trim());
                        Hrac hrac = new Hrac(meno, priezvisko, nastroj, sadzba);
                        hracList.add(hrac);
                    } else {
                        // Nástroj
                        vytvorNastroj(casti, nastrojList);
                    }
                } catch (Exception e) {
                    System.out.println("Chyba pri spracovaní riadku: " + riadok + " - " + e.getMessage());
                    // Objekt sa nevytvorí
                }
            }
        } catch (IOException e) {
            System.out.println("Chyba pri čítaní súboru: " + e.getMessage());
        }
    }

    private static void vytvorNastroj(String[] casti, ArrayList<Nastroj> nastrojList) {
        String typ = casti[0].trim();
        String druh = casti[1].trim();
        double cena = Double.parseDouble(casti[2].trim());
        String zvuk = casti[3].trim();
        int pocet = Integer.parseInt(casti[4].trim());

        switch (typ) {
            case "S": // Sláčikový nástroj
                if (casti.length != 8) throw new IllegalArgumentException("Nesprávny počet údajov pre sláčikový nástroj");
                int pocetStrunS = Integer.parseInt(casti[5].trim());
                String ladenieS = casti[6].trim();
                String sekcia = casti[7].trim();
                SlacikovyNastroj slacikovy = new SlacikovyNastroj(druh, cena, zvuk, pocet, pocetStrunS, ladenieS, sekcia);
                nastrojList.add(slacikovy);
                break;
            case "s": // Strunový nástroj
                if (casti.length != 7) throw new IllegalArgumentException("Nesprávny počet údajov pre strunový nástroj");
                int pocetStrun = Integer.parseInt(casti[5].trim());
                String ladenie = casti[6].trim();
                StrunovyNastroj strunovy = new StrunovyNastroj(druh, cena, zvuk, pocet, pocetStrun, ladenie);
                nastrojList.add(strunovy);
                break;
            case "d": // Dychový nástroj
                if (casti.length != 7) throw new IllegalArgumentException("Nesprávny počet údajov pre dychový nástroj");
                int pocetDier = Integer.parseInt(casti[5].trim());
                String ladenieD = casti[6].trim();
                DychovyNastroj dychovy = new DychovyNastroj(druh, cena, zvuk, pocet, pocetDier, ladenieD);
                nastrojList.add(dychovy);
                break;
            case "r": // Rytmický nástroj
                if (casti.length != 6) throw new IllegalArgumentException("Nesprávny počet údajov pre rytmický nástroj");
                int pocetZvukov = Integer.parseInt(casti[5].trim());
                RytmickyNastroj rytmicky = new RytmickyNastroj(druh, cena, zvuk, pocet, pocetZvukov);
                nastrojList.add(rytmicky);
                break;
            case "k": // Klávesový nástroj
                if (casti.length != 6) throw new IllegalArgumentException("Nesprávny počet údajov pre klávesový nástroj");
                int pocetKlavies = Integer.parseInt(casti[5].trim());
                KlavesovyNastroj klavesovy = new KlavesovyNastroj(druh, cena, zvuk, pocet, pocetKlavies);
                nastrojList.add(klavesovy);
                break;
            default:
                throw new IllegalArgumentException("Neznámy typ nástroja: " + typ);
        }
    }

    private static void priradNastroje(ArrayList<Hrac> hracList, ArrayList<Nastroj> nastrojList) {
        for (Hrac hrac : hracList) {
            String nastrojNazov = hrac.getNastroj();
            Nastroj priradeny = null;

            // Najprv skúsiť nájsť sláčikový nástroj so sekciou
            for (Nastroj n : nastrojList) {
                if (n instanceof SlacikovyNastroj) {
                    SlacikovyNastroj sl = (SlacikovyNastroj) n;
                    if (sl.getSekcia().equals(nastrojNazov)) {
                        priradeny = n;
                        break;
                    }
                }
            }

            // Ak sa nenašiel, hľadať podľa druhu
            if (priradeny == null) {
                for (Nastroj n : nastrojList) {
                    if (n.getDruh().equals(nastrojNazov)) {
                        priradeny = n;
                        break;
                    }
                }
            }

            hrac.setPriradenyNastroj(priradeny);
        }
    }
}