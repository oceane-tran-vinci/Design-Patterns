import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader lecteurAvecBuffer = null;
    String ligne;

    try {
      lecteurAvecBuffer =
          new BufferedReader(new FileReader("testFiche1.txt"));
    } catch (FileNotFoundException e) {
      System.out.println("Erreur d'ouverture");
      return;
    }

    AnalyseurDeTexte analyseurDeTexte = new AnalyseurDeTexte();

    analyseurDeTexte.registerObserver(new ObserverNbrLignes());
    analyseurDeTexte.registerObserver(new ObserverNbrMots());
    analyseurDeTexte.registerObserver(new ObserverNbrPalindromes());
    analyseurDeTexte.registerObserver(new ObserverNbrBelgique());

    // IMPORTANT :
    // on lit réellement le fichier ligne par ligne
    while ((ligne = lecteurAvecBuffer.readLine()) != null) {
      // Chaque ligne lue est envoyée aux Observers
      analyseurDeTexte.lireFichier(ligne);
    }

    lecteurAvecBuffer.close();

    // Une fois TOUTES les lignes traitées
    analyseurDeTexte.afficherResultats();
  }
}