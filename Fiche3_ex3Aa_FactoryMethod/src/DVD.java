//Après avoir créer la classe Produit ne pas oublier d'effacer ce qu'il faut et ajouter extends Produit
//Changer le prix pas PRIX et l'enlever des paramètres
public class DVD extends Produit{
	public static final double PRIX=19.99;

	public DVD(String name, int anneeDeParution) {
		super(name, anneeDeParution, PRIX);
	}
}
