package strategies;
/*
 DecoratorCompteur = DECORATOR
 - Ajoute une fonctionnalité (compter)
 - Sans modifier la stratégie existante
 - Fonctionne avec TOUTES les stratégies
*/

public class DecoratorCompteur implements Strategy {
  private Strategy s; //L’objet décoré (le "Component")
  private int compteur; //Compteur interne

  //Constructeur : on enveloppe une stratégie existante
  public DecoratorCompteur(Strategy s) {
    this.s = s;
    this.compteur = 0;
  }

  //Méthode supplémentaire propre au décorateur
  public int getCompteur() {
    return compteur;
  }

  //Même méthode que Strategy
  @Override
  public boolean estValide(String mot) {
    // On délègue le vrai travail à la stratégie décorée
    boolean isValid = s.estValide(mot);

    //Comportement ajouté : compter
    if (isValid){
      compteur++;
    }
    return isValid; // On retourne le résultat normal
  }
}
