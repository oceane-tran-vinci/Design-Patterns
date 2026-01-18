import java.io.IOException;
import strategies.CommenceParStrategy;
import strategies.DeLongueurStrategy;
import strategies.PalydromeStrategy;
import strategies.ANDComposite;
import strategies.ORComposite;
import strategies.NOTComposite;

public class Main {
    public static void main(String[] args) {
        ListerMots listerMots = new ListerMots("testFiche2.txt");

        try {
            //ex 2
            System.out.println("\nAND");
            listerMots.imprimerStrategy(new ANDComposite(new CommenceParStrategy('t'), new DeLongueurStrategy(4)));
            System.out.println("\nOR");
            listerMots.imprimerStrategy(new ORComposite(new DeLongueurStrategy(3), new DeLongueurStrategy(5)));
            System.out.println("\nNOT");
            listerMots.imprimerStrategy(new NOTComposite(new CommenceParStrategy('t')));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}