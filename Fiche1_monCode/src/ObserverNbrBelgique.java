public class ObserverNbrBelgique implements Observer {

  private int nbrBelgique = 0;

  @Override
  public void traiterLigne(String ligne) {
    if (ligne.contains("Belgique")) {
      nbrBelgique++;
    }
  }

  @Override
  public void result() {
    System.out.println(
        "Il y avait " + nbrBelgique + " lignes contenant Belgique."
    );
  }


  /*
   * VERSION PROF → plus générale/réutilisable :
   *
   * Au lieu de coder "Belgique" en dur, le mot recherché (target)
   * est donné au constructeur.
   * → même Observer utilisable pour Belgique, France, etc.
   *
   * private String target;
   * private int result;
   *
   * public ObserverNbrBelgique(String target) {
   *     this.target = target;
   * }
   *
   * @Override
   * public void traiterLigne(String ligne) {
   *     // toLowerCase() → ignore majuscules/minuscules
   *     if (ligne.toLowerCase().contains(target.toLowerCase())) {
   *         result++;
   *     }
   * }
   *
   * Ex :
   * new ObserverNbrBelgique("Belgique");
   * new ObserverNbrBelgique("France");
   */
}