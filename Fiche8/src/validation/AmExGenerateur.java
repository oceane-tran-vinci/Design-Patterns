package validation;

import domaine.AmEx;
import domaine.CarteDeCredit;
import java.util.Calendar;

public class AmExGenerateur extends Generateur{

  public AmExGenerateur(Generateur successeur) {
    super(successeur);
  }

  @Override
  public boolean valider(String numero) {
    //commence par 34 ou 37 et comporte 15 chiffres.
    if ((numero.startsWith("34")) || (numero.startsWith("37")) && (numero.length() == 15)){
      return true;
    }

    //sinon passe à la carte suivant en re appelant la méthode valider de Generateur
    return super.valider(numero);
  }

  @Override
  public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
    // Même test que dans valider()
    if ((numero.startsWith("34") || numero.startsWith("37")) && numero.length() == 15) {
      return new AmEx(numero, dateExpiration, nom);
    }

    // Sinon → laisser le suivant essayer
    return super.creerCarte(numero, dateExpiration, nom);
  }
}
