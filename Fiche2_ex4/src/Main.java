import java.io.IOException;
import strategies.ANDComposite;
import strategies.CommenceParStrategy;
import strategies.DeLongueurStrategy;
import strategies.DecoratorCompteur;
import strategies.EtComposite;
import strategies.NOTComposite;
import strategies.ORComposite;
import strategies.OuComposite;
import strategies.PalydromeStrategy;

public class Main {

  public static void main(String[] args) {
    ListerMots listerMots = new ListerMots("testFiche2.txt");

    try {
      //ex 1
      System.out.println("**** starts with 't' Sans compteur (sans decorateur)****");
      listerMots.imprimerStrategy(new CommenceParStrategy('t'));
      //ex 4 DecorateurCompteur a ajouté
      System.out.println("\nstarts with 't' Avec compteur (avec decorateur)");
      DecoratorCompteur d1 = new DecoratorCompteur(new CommenceParStrategy('t'));
      listerMots.imprimerStrategy(d1);
      System.out.println("Nombre de mots trouvés : "+d1.getCompteur());

      System.out.println("\nLength Sans compteur");
      listerMots.imprimerStrategy(new DeLongueurStrategy(4));
      //ex 4 DecorateurCompteur a ajouté
      System.out.println("\nLength Avec compteur");
      DecoratorCompteur d2 = new DecoratorCompteur(new DeLongueurStrategy(4));
      listerMots.imprimerStrategy(d2);
      System.out.println("Nombre de mots trouvés : "+d2.getCompteur());

      System.out.println("\nPalindrome");
      listerMots.imprimerStrategy(new PalydromeStrategy());
      //ex 2
      System.out.println("\n**** AND ****");
      listerMots.imprimerStrategy(
          new ANDComposite(new CommenceParStrategy('t'), new DeLongueurStrategy(4)));
      System.out.println("\nOR");
      listerMots.imprimerStrategy(
          new ORComposite(new DeLongueurStrategy(3), new DeLongueurStrategy(5)));
      System.out.println("\nNOT");
      listerMots.imprimerStrategy(new NOTComposite(new CommenceParStrategy('t')));
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