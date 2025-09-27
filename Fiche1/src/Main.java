import java.io.File;
import java.io.IOException;
import observers.ObsLignes;
import observers.ObsLignesContenantMot;
import observers.ObsMots;
import observers.ObsPalindromes;

public class Main {
  public static void main(String[] args) {
    AnalyseurDeTexte analyseurDeTexte = new AnalyseurDeTexte(new ObsLignes(), new ObsMots(), new ObsPalindromes(), new ObsLignesContenantMot("Belgique"));

    try {
      analyseurDeTexte.lireFichier(new File("testFiche1.txt"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}