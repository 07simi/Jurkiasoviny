import java.io.*;
import java.nio.file.*;
import java.util.*;

public class OrchesterMain {
    public static void main(String[] args) {
        List<Nastroj> nastrojList = new ArrayList<>();
        List<Hrac> hracList = new ArrayList<>();
        List<String[]> tempHraci = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get("orchester.txt"));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length < 2) continue;
                String type = parts[0].trim();
                try {
                    if (type.equals("u")) {
                        // u,meno,priezvisko,nastroj,hodinovaSadzba
                        if (parts.length != 5) continue;
                        String meno = parts[1].trim();
                        String priezvisko = parts[2].trim();
                        String nastrojStr = parts[3].trim();
                        double sadzba = Double.parseDouble(parts[4].trim());
                        Hrac hrac = new Hrac(meno, priezvisko, null, sadzba);
                        hracList.add(hrac);
                        tempHraci.add(new String[]{meno, priezvisko, nastrojStr});
                    } else {
                        // instrument
                        createInstrument(type, parts, nastrojList);
                    }
                } catch (Exception e) {
                    // skip invalid line
                    System.out.println("Preskočená neplatná línia: " + line);
                }
            }

            // assign instruments
            for (int i = 0; i < hracList.size(); i++) {
                Hrac hrac = hracList.get(i);
                String[] temp = tempHraci.get(i);
                String nastrojStr = temp[2];
                Nastroj assigned = findInstrument(nastrojList, nastrojStr);
                if (assigned != null) {
                    hrac.setNastroj(assigned);
                }
            }

            // print results
            System.out.println("Nástroje:");
            for (Nastroj n : nastrojList) {
                System.out.println(n);
            }
            System.out.println("\nHráči:");
            for (Hrac h : hracList) {
                System.out.println(h);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createInstrument(String type, String[] parts, List<Nastroj> list) {
        switch (type) {
            case "S": // Slacikovy
                if (parts.length != 8) return;
                String druhS = parts[1].trim();
                double cenaS = Double.parseDouble(parts[2].trim());
                String zvukS = parts[3].trim();
                int pocetS = Integer.parseInt(parts[4].trim());
                int pocetStrunS = Integer.parseInt(parts[5].trim());
                String ladenieS = parts[6].trim();
                String sekcia = parts[7].trim();
                SlacikovyNastroj sn = new SlacikovyNastroj(druhS, cenaS, zvukS, pocetS, pocetStrunS, ladenieS, sekcia);
                list.add(sn);
                break;
            case "s": // Strunovy
                if (parts.length != 7) return;
                String druhs = parts[1].trim();
                double cenas = Double.parseDouble(parts[2].trim());
                String zvuks = parts[3].trim();
                int pocets = Integer.parseInt(parts[4].trim());
                int pocetStruns = Integer.parseInt(parts[5].trim());
                String ladenies = parts[6].trim();
                StrunovyNastroj strn = new StrunovyNastroj(druhs, cenas, zvuks, pocets, pocetStruns, ladenies);
                list.add(strn);
                break;
            case "d": // Dychovy
                if (parts.length != 7) return;
                String druhd = parts[1].trim();
                double cenad = Double.parseDouble(parts[2].trim());
                String zvukd = parts[3].trim();
                int pocetd = Integer.parseInt(parts[4].trim());
                int pocetDier = Integer.parseInt(parts[5].trim());
                String ladenied = parts[6].trim();
                DychovyNastroj dn = new DychovyNastroj(druhd, cenad, zvukd, pocetd, pocetDier, ladenied);
                list.add(dn);
                break;
            case "r": // Rytmicky
                if (parts.length != 6) return;
                String druhr = parts[1].trim();
                double cenar = Double.parseDouble(parts[2].trim());
                String zvukr = parts[3].trim();
                int pocetr = Integer.parseInt(parts[4].trim());
                int pocetZvukov = Integer.parseInt(parts[5].trim());
                RytmickyNastroj rn = new RytmickyNastroj(druhr, cenar, zvukr, pocetr, pocetZvukov);
                list.add(rn);
                break;
            case "k": // Klavesovy
                if (parts.length != 6) return;
                String druhk = parts[1].trim();
                double cenak = Double.parseDouble(parts[2].trim());
                String zvukk = parts[3].trim();
                int pocetk = Integer.parseInt(parts[4].trim());
                int pocetKlavies = Integer.parseInt(parts[5].trim());
                KlavesovyNastroj kn = new KlavesovyNastroj(druhk, cenak, zvukk, pocetk, pocetKlavies);
                list.add(kn);
                break;
        }
    }

    private static Nastroj findInstrument(List<Nastroj> list, String nastrojStr) {
        if (nastrojStr.contains(".")) {
            // has section
            String[] split = nastrojStr.split("\\.", 2);
            String druh = split[1];
            String sekcia = nastrojStr;
            for (Nastroj n : list) {
                if (n instanceof SlacikovyNastroj) {
                    SlacikovyNastroj sn = (SlacikovyNastroj) n;
                    if (sn.getDruh().equals(druh) && sn.getSekcia().equals(sekcia)) {
                        return sn;
                    }
                }
            }
        } else {
            // no section
            for (Nastroj n : list) {
                if (n.getDruh().equals(nastrojStr)) {
                    return n;
                }
            }
        }
        return null;
    }
}