package validation;

import domaine.CarteDeCredit;
import domaine.MasterCard;
import java.util.Calendar;

public class MasterCardGenerateur extends Generateur{

  public MasterCardGenerateur(Generateur successeur) {
    super(successeur);
  }

  @Override
  public boolean valider(String numero) {
    // commence par 51 à 55 et comporte 16 chiffres
    if ((numero.startsWith("51") ||
        numero.startsWith("52") ||
        numero.startsWith("53") ||
        numero.startsWith("54") ||
        numero.startsWith("55"))
        && numero.length() == 16) {
      return true;
    }

    /* OU si on veut pas répéter 5x
     if (numero.length() == 16) {
        String debut = numero.substring(0, 2); // les 2 premiers chiffres

        if (debut.compareTo("51") >= 0 && debut.compareTo("55") <= 0) {
            return true;
        }
      }
    */

    return super.valider(numero);
  }

  @Override
  public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
    if ((numero.startsWith("51") ||
        numero.startsWith("52") ||
        numero.startsWith("53") ||
        numero.startsWith("54") ||
        numero.startsWith("55"))
        && numero.length() == 16) {
      return new MasterCard(numero, dateExpiration, nom);
    }

    /* OU si on veut pas répéter 5x
    if (numero.length() == 16) {
        String debut = numero.substring(0, 2);

        if (debut.compareTo("51") >= 0 && debut.compareTo("55") <= 0) {
            return new MasterCard(numero, dateExpiration, nom);
        }
      }
    */

    return super.creerCarte(numero, dateExpiration, nom);
  }
}
