package validation;

import domaine.CarteDeCredit;
import domaine.DinersClub;
import java.util.Calendar;

public class DinersClubGenerateur extends Generateur{

  public DinersClubGenerateur(Generateur successeur) {
    super(successeur);
  }

  @Override
  public boolean valider(String numero) {
    // commence par 36 et comporte 14 chiffres
    if (numero.startsWith("36") && numero.length() == 14) {
      return true;
    }

    // sinon → continuer la chaîne
    return super.valider(numero);
  }

  @Override
  public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
    if (numero.startsWith("36") && numero.length() == 14) {
      return new DinersClub(numero, dateExpiration, nom);
    }

    return super.creerCarte(numero, dateExpiration, nom);
  }
}
