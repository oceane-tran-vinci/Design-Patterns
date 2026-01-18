import java.io.IOException;
import strategies.ANDComposite;
import strategies.CommenceParStrategy;
import strategies.DeLongueurStrategy;
import strategies.EtComposite;
import strategies.NOTComposite;
import strategies.ORComposite;
import strategies.OuComposite;
import strategies.PalydromeStrategy;

public class Main {

  public static void main(String[] args) {
    ListerMots listerMots = new ListerMots("testFiche2.txt");

    try {
      //ex3
      System.out.println("\n**** ET****");
      listerMots.imprimerStrategy(
          new EtComposite(new CommenceParStrategy('k'), new DeLongueurStrategy(5),
              new PalydromeStrategy()));
      System.out.println("\nOU");
      listerMots.imprimerStrategy(
          new OuComposite(new CommenceParStrategy('t'), new DeLongueurStrategy(3), new DeLongueurStrategy(5),
              new PalydromeStrategy()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}