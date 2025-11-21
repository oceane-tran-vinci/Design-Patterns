package validation;

import domaine.CarteDeCredit;
import java.util.Calendar;

public class CarteDeCreditGenerateur extends Generateur{

  public CarteDeCreditGenerateur(Generateur successeur) {
    super(successeur);
  }

  @Override
  public boolean valider(String numero) {
    // aucune carte reconnue dans la chaîne
    return false;
  }

  @Override
  public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
    // aucune carte reconnue → pas de création possible
    return null;
  }
}
