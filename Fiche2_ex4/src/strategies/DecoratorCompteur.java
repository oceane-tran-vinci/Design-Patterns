package strategies;

public class DecoratorCompteur implements Strategy {
  private Strategy s;
  private int compteur;

  public DecoratorCompteur(Strategy s) {
    this.s = s;
    this.compteur = 0;
  }

  public int getCompteur() {
    return compteur;
  }

  @Override
  public boolean estValide(String mot) {
    boolean isValid = s.estValide(mot);
    if (isValid){
      compteur++;
    }
    return isValid;
  }
}
