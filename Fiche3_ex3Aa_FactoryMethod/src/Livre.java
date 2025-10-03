//Après avoir créer la classe Produit ne pas oublier d'effacer ce qu'il faut et ajouter extends Produit
//Changer le prix pas PRIX et l'enlever des paramètres
public class Livre extends Produit{
	public static final double PRIX=14.99;

	public Livre(String name, int anneeDeParution) {
		super(name, anneeDeParution, PRIX);
	}
}