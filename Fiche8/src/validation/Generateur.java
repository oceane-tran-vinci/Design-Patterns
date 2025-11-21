package validation;

import java.util.Calendar;

import domaine.CarteDeCredit;

public abstract class Generateur {

  private Generateur successeur;

  public Generateur(Generateur successeur) {
    this.successeur = successeur;
  }

  public boolean valider(String numero) {
		if (successeur == null) {
			throw new RuntimeException();
		}
		return successeur.valider(numero);
  }

  public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
		if (successeur == null) {
			throw new RuntimeException();
		}
		return successeur.creerCarte(numero, dateExpiration, nom);
  }
}
