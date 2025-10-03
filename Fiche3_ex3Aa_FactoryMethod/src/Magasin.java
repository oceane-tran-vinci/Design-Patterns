import java.util.HashMap;
import java.util.Map;
//Apd une classe MagasinDVD ou MagasinDeLibre, créer la classe Magasin et modifier ce qu'il faut
public abstract class Magasin {
  private Map<String, Produit> map= new HashMap<String,Produit>();

  //this. car méthode dans la classe
  public void ajouter(String name, int anneeDeParution){
    Produit produit = this.ajouterProduit(name, anneeDeParution);
    map.put(name,produit);
  }

  public Produit retourneProduit(String name){
    return map.get(name);
  }

  //ajouter une méthode abstract dans la class dc la classe doit ê abstract aussi pas oublier de le mettre au debut de la classe
  public abstract Produit ajouterProduit(String name, int anneeDeParution);
}
