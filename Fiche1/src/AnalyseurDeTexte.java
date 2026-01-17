import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import observers.Observer;

public class AnalyseurDeTexte {
	//observerCollections
	private final ArrayList<Observer> observers = new ArrayList<>();

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void unregisterObserver(Observer o) {
		observers.remove(o);
	}

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
	}
}
