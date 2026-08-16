public class ObserverNbrLignes implements Observer {
  private int nbrLignes = 0;
  @Override
  public void traiterLigne(String ligne) {
    nbrLignes++;
  }

  @Override
  public void result() {
    System.out.println("Il y avait " + nbrLignes + " lignes.");
  }
}
