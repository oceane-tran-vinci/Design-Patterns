import java.util.ArrayList;

public class AnalyseurDeTexte {
  //private = accessible seulement dans le Subject
  //final = on ne remplace pas la liste (empeche de faire : listObservers = new ArrayList<>();)
  //mais on peut toujours add() / remove() dedans.
  //=> Liste de tous les Observers actuellement enregistrés
  private final ArrayList<Observer> listObservers = new ArrayList<>();

  // Ajoute/abonne un Observer
  public void registerObserver(Observer observer){
    listObservers.add(observer);
  }
  // Retire/désabonne un Observer
  public void unregisterObserver(Observer observer){
    listObservers.remove(observer);
  }

  //notifyObservers
  // Une ligne vient d'être lue → tous les observers la traitent
  public void lireFichier(String line){
    for (Observer observer : listObservers) {
      observer.traiterLigne(line);
    }
  }

  // À appeler seulement après avoir lu tout le fichier
  public void afficherResultats() {
    for (Observer observer : listObservers) {
      observer.result();
    }
  }


  /*Version prof de lireFichier: il a mis l'exception ici aussi, moi j'ai mis dans le main
  public void lireFichier(File f) throws IOException {
		BufferedReader lecteurAvecBuffer;
		String ligne;

		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			System.out.println("Erreur d'ouverture");
			return;
		}

		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			final String l = ligne;
			observers.forEach(o -> o.traiterLigne(l));
		}

		lecteurAvecBuffer.close();
		observers.forEach(Observer::result);
	}*/
}
