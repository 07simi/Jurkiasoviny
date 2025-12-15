import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("skladNastrojov.txt"));
        String line;
        ArrayList<Nastroj> sklad = new ArrayList<>();
        ArrayList<Hrac> umelci = new ArrayList<>();
        while ((line=br.readLine()) != null) {
            String params[] = line.split(",");
            if (params[0] == "u") {
                umelci.add(new Hrac(params))
            else {
                if (params[0] == "s") sklad.add(new StrunovyNastroj(params));
                else if (params[0] == "n") sklad.add(new Nastroj(params));
            }
        }
    }
}
