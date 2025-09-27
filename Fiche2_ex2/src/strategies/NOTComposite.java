package strategies;

public class NOTComposite implements Strategy {

  private Strategy s;

  public NOTComposite(Strategy s) {
    this.s = s;
  }

  //le not doit ê l'inverse de la stratgey demandé
  @Override
  public boolean estValide(String mot) {
    return !s.estValide(mot);
  }
}
