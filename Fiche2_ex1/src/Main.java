import strategies.CommenceParStrategy;
import strategies.DeLongueurStrategy;
import strategies.PalydromeStrategy;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ListerMots listerMots = new ListerMots("testFiche2.txt");

        try {
            System.out.println("starts with 't'");
            listerMots.imprimerStrategy(new CommenceParStrategy('t'));
            System.out.println("\nLength");
            listerMots.imprimerStrategy(new DeLongueurStrategy(4));
            System.out.println("\nPalindrome");
            listerMots.imprimerStrategy(new PalydromeStrategy()   );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}