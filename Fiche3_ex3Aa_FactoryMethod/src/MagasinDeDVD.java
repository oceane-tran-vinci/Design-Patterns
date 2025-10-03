import java.util.HashMap;
import java.util.Map;
//Recréer la classe avec extends Magasin + on va return ce qu'il faut
public class MagasinDeDVD extends Magasin {

	@Override
	public Produit ajouterProduit(String name, int anneeDeParution) {
		return new DVD(name, anneeDeParution);
	}
}
