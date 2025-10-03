import java.util.HashMap;
import java.util.Map;
//la méthode ajouterProduit n'est pas dans la classe mais dans l'interface AbstractFactory
// dc on oublie pas d'enlever l'abstract de public abstract class Magasin
public class Magasin {
  private Map<String, Produit> map= new HashMap<String,Produit>();
  //On ajoute la variable AbstractFactory pour pouvoir use la méthode dans l'interface
  private AbstractFactory abstractFactory;

  //oublie pas le constructeur
  public Magasin(AbstractFactory abstractFactory) {
    this.abstractFactory = abstractFactory;
  }

  //pas this. mais abstractFactory.ajouterProduit
  public void ajouter(String name, int anneeDeParution){
    Produit produit = abstractFactory.ajouterProduit(name, anneeDeParution);
    map.put(name,produit);
  }

  public Produit retourneProduit(String name){
    return map.get(name);
  }

}
