import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("skladNastrojov.txt"));
        String line;
        ArrayList<Nastroj> nastroje = new ArrayList<>();
        ArrayList<Hrac> umelci = new ArrayList<>();
        Nastroj nastroj;
        while ((line=br.readLine()) != null) {
            System.out.println(line);
            String [] data = line.split(",");
            for (int i = 0; i < data.length; i++) {
                System.out.println(data[i]);
            }
            if (data[0].equals("u")){

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
