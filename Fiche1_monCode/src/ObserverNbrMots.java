public class ObserverNbrMots implements Observer {
  private int nbrMots = 0;

  //Besoin uniquement du nombre de mots → .split(" ").length
  //Besoin de traiter chaque mot → for (String mot : ligne.split(" "))
  @Override
  public void traiterLigne(String ligne) {

    // split Découpe la ligne à chaque espace pour obtenir les mots.
    // .length = nombre de mots obtenus.
    // += permet d'ajouter ce nombre au total des lignes précédentes.
    nbrMots += ligne.split(" ").length;

    /*
     * 2e façon : reprise du code initial.
     * On parcourt chaque mot séparément et on incrémente le compteur.
     * Correct, mais inutile de faire une boucle si on veut seulement
     * connaître le nombre de mots → .length est plus direct.
     *
     * for (String mot : ligne.trim().split(" ")) {
     *     nbrMots++;
     * }
     */
  }

  @Override
  public void result() {
    System.out.println("Il y avait " + nbrMots + " mots.");
  }
}
