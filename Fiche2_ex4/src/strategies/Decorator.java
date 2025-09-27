package strategies;

public class Decorator implements Strategy {
  private Strategy s;
  private int compteur;

  public Decorator(Strategy s) {
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
