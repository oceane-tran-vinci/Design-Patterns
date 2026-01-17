import java.io.File;
import java.io.IOException;
import observers.ObsLignes;
import observers.ObsLignesContenantMot;
import observers.ObsMots;
import observers.ObsPalindromes;

public class Main {
  public static void main(String[] args) {
    //Créer l'event principam
    AnalyseurDeTexte analyseurDeTexte = new AnalyseurDeTexte();

    //Ajout des traitements à l'event
    analyseurDeTexte.registerObserver(new ObsLignes());
    analyseurDeTexte.registerObserver(new ObsMots());
    analyseurDeTexte.registerObserver(new ObsPalindromes());
    analyseurDeTexte.registerObserver(new ObsLignesContenantMot("Belgique"));

    try {
      analyseurDeTexte.lireFichier(new File("testFiche1.txt"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}