package strategies;

public class ANDComposite implements Strategy {

  private Strategy s1;
  private Strategy s2;

  public ANDComposite(Strategy s1, Strategy s2) {
    this.s1 = s1;
    this.s2 = s2;
  }

  @Override
  public boolean estValide(String mot) {
    return s1.estValide(mot) && s2.estValide(mot);
  }
}
