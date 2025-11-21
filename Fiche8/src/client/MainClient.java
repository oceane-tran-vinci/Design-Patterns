package client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import validation.AmExGenerateur;
import validation.CarteDeCreditGenerateur;
import validation.DinersClubGenerateur;
import validation.DiscoverGenerateur;
import validation.Generateur;

import domaine.CarteDeCredit;
import validation.MasterCardGenerateur;
import validation.VisaGenerateur;

public class MainClient {

  public static void main(String[] args) throws IOException {
    File file = new File("Fiche8/cc.txt");
    try {
      Scanner fichier = new Scanner(file);
      // ------------------------------
      // Construction de la chaîne COR
      // ------------------------------
      Generateur chaine =
          new AmExGenerateur(
              new DinersClubGenerateur(
                  new DiscoverGenerateur(
                      new MasterCardGenerateur(
                          new VisaGenerateur(
                              new CarteDeCreditGenerateur(null))))));

      while (fichier.hasNextLine()) {
        try {
          String ligne = fichier.nextLine();
          String[] parts = ligne.split(",");
          SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
          Calendar dateExpiration = new GregorianCalendar();
          dateExpiration.setTime(sdf.parse(parts[1]));
          CarteDeCredit carteDeCredit = chaine.creerCarte(parts[0], dateExpiration, parts[ 2]);
          if (carteDeCredit == null) {
            System.out.println("Numero de carte invalide " + parts[0]);
          } else {
            System.out.println("La carte " + carteDeCredit.getNumero() + " est une carte "
                + carteDeCredit.getType());
            System.out.println("Elle expire le " + sdf.format(dateExpiration.getTime()));
            System.out.println("Son titulaire est " + carteDeCredit.getNom());
          }
          System.out.println("-----------------------------------------------------------");
        } catch (ParseException e) {
          System.out.println("Mauvaise date d'expiration");
          e.printStackTrace();
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Le fichier " + file.getCanonicalPath() + " est introuvable");
      e.printStackTrace();
    }
  }
}
