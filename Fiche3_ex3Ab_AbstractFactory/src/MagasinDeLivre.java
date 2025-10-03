//Mettre implements AbstractFactory dans la classe vu que la méthode est dans l'interface AbstractFactory
public class MagasinDeLivre implements AbstractFactory{

	@Override
	public Produit ajouterProduit(String name, int anneeDeParution) {
		return new Livre(name, anneeDeParution);
	}
}
