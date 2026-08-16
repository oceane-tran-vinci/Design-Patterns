public class ObserverNbrPalindromes implements Observer {

  private int nbrPalindromes = 0;

  // =========================
  // MA VERSION
  // =========================

  @Override
  public void traiterLigne(String ligne) {

    // Découpe la ligne en mots et parcourt chaque mot
    for (String mot : ligne.trim().split(" ")) {

      // Crée une copie du mot que l'on peut inverser
      StringBuffer temp = new StringBuffer(mot);

      // Compare le mot original avec le mot inversé
      // Ex : "kayak" == "kayak" → palindrome → compteur +1
      if (mot.equals(temp.reverse().toString())) {
        nbrPalindromes++;
      }
    }
  }

  @Override
  public void result() {
    System.out.println(
        "Il y avait " + nbrPalindromes + " palindromes."
    );
  }


  /*
   * =========================
   * VERSION DU PROF
   * =========================
   *
   * Même principe que ma version, mais mieux structuré :
   * → le parcours des mots reste dans traiterLigne()
   * → la vérification du palindrome est séparée dans isPalindrome()
   * → toLowerCase() permet d'ignorer majuscules/minuscules
   *
   * @Override
   * public void traiterLigne(String ligne) {
   *
   *     // Découpe d'abord la ligne en tableau de mots
   *     String[] mots = ligne.split(" ");
   *
   *     // Parcourt chaque mot
   *     for (String mot : mots) {
   *
   *         // Vérifie le palindrome via une méthode séparée
   *         if (isPalindrome(mot.toLowerCase())) {
   *             nbrPalindromes++;
   *         }
   *     }
   * }
   *
   * // Méthode propre à ce ConcreteObserver :
   * // pas besoin de la déclarer dans l'interface Observer
   * private boolean isPalindrome(String mot) {
   *
   *     // StringBuilder permet d'inverser facilement le mot
   *     StringBuilder temp = new StringBuilder(mot);
   *
   *     // true si mot original == mot inversé
   *     return mot.equals(temp.reverse().toString());
   * }
   *
   * → Ma version est correcte.
   * → Celle du prof est surtout plus lisible/modulaire.
   */
}