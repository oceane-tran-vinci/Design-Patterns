import java.util.HashMap;
import java.util.Map;
//Apd une classe MagasinDVD ou MagasinDeLibre, créer la classe Magasin et modifier ce qu'il faut
public abstract class Magasin {
  private Map<String, Produit> map= new HashMap<String,Produit>();

  //ajouter réellement le produit dans le magasin.
  public void ajouter(String name, int anneeDeParution){
    Produit produit = this.ajouterProduit(name, anneeDeParution); //1. demander la création du bon Produit
    map.put(name,produit);                                        //2. le stocker dans la Map du magasin
  }

  public Produit retourneProduit(String name){
    return map.get(name);
  }

  //seulement créer le bon type de Produit. C’est la Factory Method.
  public abstract Produit ajouterProduit(String name, int anneeDeParution);
}
