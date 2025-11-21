package validation;

import domaine.CarteDeCredit;
import domaine.Visa;
import java.util.Calendar;

public class VisaGenerateur extends Generateur {

  public VisaGenerateur(Generateur successeur) {
    super(successeur);
  }

  @Override
  public boolean valider(String numero) {
    // commence par 4 et comporte 16 chiffres
    if (numero.startsWith("4") && numero.length() == 16) {
      return true;
    }

    return super.valider(numero);
  }

  @Override
  public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
    if (numero.startsWith("4") && numero.length() == 16) {
      return new Visa(numero, dateExpiration, nom);
    }

    return super.creerCarte(numero, dateExpiration, nom);
  }
}
