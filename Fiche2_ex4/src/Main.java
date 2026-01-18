import java.io.IOException;
import strategies.CommenceParStrategy;
import strategies.DecoratorCompteur;
import strategies.Strategy;

public class Main {

  public static void main(String[] args) {
    ListerMots listerMots = new ListerMots("testFiche2.txt");// Contexte

    Strategy selection = new CommenceParStrategy('t');// Sélection de base
    DecoratorCompteur compteur = new DecoratorCompteur(selection);// Décoration : ajout du comptage

    try {
      // Utilisation normale
      listerMots.imprimerStrategy(compteur);
      // Nouvelle fonctionnalité ajoutée
      System.out.println("Nombre de mots sélectionnés : " + compteur.getCompteur());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}