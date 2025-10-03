public class Main {

  public static void main(String[] args) {
    Magasin magasinDVD = new MagasinDeDVD();
    magasinDVD.ajouter("test1", 2000);
    magasinDVD.ajouter("test2", 2001);
    System.out.println("Dvd : ");
    System.out.println(magasinDVD.retourneProduit("test1").getAnneeDeParution());
    System.out.println(magasinDVD.retourneProduit("test2").getAnneeDeParution());

    Magasin magasinLivre = new MagasinDeLivre();
    magasinLivre.ajouter("test3", 2002);
    magasinLivre.ajouter("test4", 2003);
    System.out.println("Livre : ");
    System.out.println(magasinLivre.retourneProduit("test3").getAnneeDeParution());
    System.out.println(magasinLivre.retourneProduit("test4").getAnneeDeParution());
  }
}
