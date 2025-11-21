package validation;

import domaine.CarteDeCredit;
import domaine.Discover;
import java.util.Calendar;

public class DiscoverGenerateur extends Generateur{

  public DiscoverGenerateur(Generateur successeur) {
    super(successeur);
  }

  @Override
  public boolean valider(String numero) {
    // commence par 6011 OU 65 et comporte 16 chiffres
    if ((numero.startsWith("6011") || numero.startsWith("65")) && numero.length() == 16) {
      return true;
    }

    return super.valider(numero);
  }

  @Override
  public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
    if ((numero.startsWith("6011") || numero.startsWith("65")) && numero.length() == 16) {
      return new Discover(numero, dateExpiration, nom);
    }

    return super.creerCarte(numero, dateExpiration, nom);
  }
}
