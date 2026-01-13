import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Nastroj> nastrojList = new ArrayList<>();
        ArrayList<Hrac> hracList = new ArrayList<>();
        ArrayList<String> hracNastroje = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/hudak/Desktop/OPG-Orchester/orchester.txt"))) {
            String riadok;
            while ((riadok = br.readLine()) != null) {
                String[] casti = riadok.split(",");
                if (casti.length < 2) continue;
                String typ = casti[0].trim();
                try {
                    if (typ.equals("u")) {
                        if (casti.length != 5) continue;
                        String meno = casti[1].trim(), priezvisko = casti[2].trim(), nastroj = casti[3].trim();
                        double sadzba = Double.parseDouble(casti[4].trim());
                        hracList.add(new Hrac(meno, priezvisko, null, sadzba));
                        hracNastroje.add(nastroj);
                    } else {
                        String druh = casti[1].trim();
                        double cena = Double.parseDouble(casti[2].trim());
                        String zvuk = casti[3].trim();
                        int pocet = Integer.parseInt(casti[4].trim());
                        switch (typ) {
                            case "S":
                                if (casti.length != 8) throw new IllegalArgumentException("Nesprávny počet údajov pre sláčikový nástroj");
                                int pocetStrunS = Integer.parseInt(casti[5].trim());
                                String ladenieS = casti[6].trim();
                                String sekcia = casti[7].trim();
                                nastrojList.add(new SlacikovyNastroj(druh, cena, zvuk, pocet, pocetStrunS, ladenieS, sekcia));
                                break;
                            case "s":
                                if (casti.length != 7) throw new IllegalArgumentException("Nesprávny počet údajov pre strunový nástroj");
                                int pocetStrun = Integer.parseInt(casti[5].trim());
                                String ladenie = casti[6].trim();
                                nastrojList.add(new StrunovyNastroj(druh, cena, zvuk, pocet, pocetStrun, ladenie));
                                break;
                            case "d":
                                if (casti.length != 7) throw new IllegalArgumentException("Nesprávny počet údajov pre dychový nástroj");
                                int pocetDier = Integer.parseInt(casti[5].trim());
                                String ladenieD = casti[6].trim();
                                nastrojList.add(new DychovyNastroj(druh, cena, zvuk, pocet, pocetDier, ladenieD));
                                break;
                            case "r":
                                if (casti.length != 6) throw new IllegalArgumentException("Nesprávny počet údajov pre rytmický nástroj");
                                int pocetZvukov = Integer.parseInt(casti[5].trim());
                                nastrojList.add(new RytmickyNastroj(druh, cena, zvuk, pocet, pocetZvukov));
                                break;
                            case "k":
                                if (casti.length != 6) throw new IllegalArgumentException("Nesprávny počet údajov pre klávesový nástroj");
                                int pocetKlavies = Integer.parseInt(casti[5].trim());
                                nastrojList.add(new KlavesovyNastroj(druh, cena, zvuk, pocet, pocetKlavies));
                                break;
                            default:
                                throw new IllegalArgumentException("Neznámy typ nástroja: " + typ);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Chyba: " + riadok + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Chyba pri čítaní: " + e.getMessage());
        }
        for (int i = 0; i < hracList.size(); i++) {
            String nazov = hracNastroje.get(i);
            Nastroj priradeny = null;
            for (Nastroj n : nastrojList) {
                if (n instanceof SlacikovyNastroj && ((SlacikovyNastroj) n).getSekcia().equals(nazov)) {
                    priradeny = n;
                    break;
                }
            }
            if (priradeny == null) {
                for (Nastroj n : nastrojList) {
                    if (n.getDruh().equals(nazov)) {
                        priradeny = n;
                        break;
                    }
                }
            }
            hracList.get(i).setNastroj(priradeny);
        }
        System.out.println("Nástroje:");
        for (Nastroj n : nastrojList) System.out.println(n);
        System.out.println("\nHráči:");
        for (Hrac h : hracList) System.out.println(h);
    }
}
