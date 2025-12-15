import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("skladNastrojov.txt"));
        String line;
        ArrayList<Nastroj> nastroje = new ArrayList<>();
        ArrayList<Hrac> umelci = new ArrayList<>();
        Nastroj nastroj;
        Hrac hrac;
        while ((line=br.readLine()) != null) {
            String [] data = line.split(",");
            if (data[0].equals("u")){
                hrac = new Hrac(data);
                umelci.add(hrac);
            }
            else{
                nastroj = null;
                if (data[0].equals("n")){
                    nastroj = new Nastroj(data) ;
                }
                if (data[0].equals("s")){
                    nastroj = new StrunovyNastroj(data) ;
                }
                if (nastroj != null){
                    System.out.println(nastroj);
                    nastroje.add(nastroj);
                }
            }
        }
    }
}
