public class MachineACafe {

  public enum State {
    IDLE {
      @Override
      public void rendreMonnaie(MachineACafe machineACafe) {
        machineACafe.setState(State.IDLE);
      }

      @Override
      public void selectionnerBoisson(ToucheBoisson toucheBoisson, MachineACafe machineACafe) {
        machineACafe.afficherPasAssez(toucheBoisson);
      }

    }, COLLECTE {

    }, PAS_ASSEZ {
      @Override
      public void selectionnerBoisson(ToucheBoisson toucheBoisson, MachineACafe machineACafe) {
        throw new IllegalStateException();
      }

      @Override
      public void entrerMonnaie(Piece piece, MachineACafe machineACafe) {
        machineACafe.montantEnCours += piece.getValeur();
        machineACafe.afficherMontant();

        if (machineACafe.boisson.getPrix() > machineACafe.montantEnCours) {
          machineACafe.afficherPasAssez(machineACafe.boisson);
        } else {
          machineACafe.montantEnCours -= machineACafe.boisson.getPrix();
          machineACafe.afficherBoisson(machineACafe.boisson);
          machineACafe.boisson = null;
          machineACafe.afficherMontant();
          if (machineACafe.montantEnCours == 0) {
            machineACafe.setState(State.IDLE);
          } else {
            machineACafe.setState(State.COLLECTE);
          }
        }
      }

    };

    public void rendreMonnaie(MachineACafe machineACafe) {
      machineACafe.afficherRetour();
      machineACafe.montantEnCours = 0;
      machineACafe.boisson = null;
      machineACafe.setState(State.IDLE);
    }

    public void selectionnerBoisson(ToucheBoisson toucheBoisson, MachineACafe machineACafe) {
      if (toucheBoisson.getPrix() > machineACafe.montantEnCours) {
        machineACafe.boisson = toucheBoisson;
        machineACafe.afficherPasAssez(machineACafe.boisson);
        machineACafe.boisson = toucheBoisson;
        machineACafe.setState(State.PAS_ASSEZ);
        return;
      }
      machineACafe.montantEnCours -= toucheBoisson.getPrix();
      machineACafe.afficherBoisson(toucheBoisson);
      machineACafe.afficherMontant();
      if (machineACafe.montantEnCours == 0) {
        machineACafe.setState(State.IDLE);
      } else {
        machineACafe.setState(State.COLLECTE);
      }
    }


    public void entrerMonnaie(Piece piece, MachineACafe machineACafe) {
      machineACafe.montantEnCours += piece.getValeur();
      machineACafe.afficherMontant();

      machineACafe.setState(State.COLLECTE);
    }
  }

//	public final int idle = 0;
//	public final int collecte = 1;
//	public final int pasAssez = 2;

  private int montantEnCours = 0;
  //	private int etatCourant = idle;
  private ToucheBoisson boisson = null;

  private State state;

  public MachineACafe() {
    setState(State.IDLE);
  }

  public void setState(State state) {
    this.state = state;
  }


  public void afficherMontant() {
    System.out.println(montantEnCours + " cents disponibles");
  }

  public void afficherRetour() {
    System.out.println(montantEnCours + " cents rendus");
  }

  public void afficherPasAssez(ToucheBoisson toucheBoisson) {
    System.out.println("Vous n'avez pas introduit un montant suffisant pour un " + toucheBoisson);
    System.out.println("Il manque encore " + (toucheBoisson.getPrix() - montantEnCours) + " cents");
  }

  public void afficherBoisson(ToucheBoisson toucheBoisson) {
    System.out.println("Voici un " + toucheBoisson);

  }

  public void entrerMonnaie(Piece piece) {
    state.entrerMonnaie(piece, this);
    //le code en dessous est diviser en 2 :
    /*1) si etatCourant != pas assez (dc à mettre ds classe parent, générale)
     * 2) si etatCourant == pas assez (à mettre ds énumérer PAS_ASSEZ) */
    /*montantEnCours += piece.getValeur();
    afficherMontant();
    if (etatCourant != pasAssez) {
      etatCourant = collecte;
    } else if (boisson.getPrix() > montantEnCours) {
      afficherPasAssez(boisson);
    } else {
      montantEnCours -= boisson.getPrix();
      afficherBoisson(boisson);
      boisson = null;
      afficherMontant();
      if (montantEnCours == 0) {
        etatCourant = idle;
      } else {
        etatCourant = collecte;
      }
    }
     */
  }

  public void selectionnerBoisson(ToucheBoisson toucheBoisson) {
    state.selectionnerBoisson(toucheBoisson, this);
        /*if (etatCourant == pasAssez)
            throw new IllegalStateException();
        if (etatCourant == idle){
            afficherPasAssez(toucheBoisson);
            return;
        }
        if (toucheBoisson.getPrix() > montantEnCours) {
            boisson = toucheBoisson;
            afficherPasAssez(boisson);
            boisson = toucheBoisson;
            etatCourant = pasAssez;
            return;
        }
        montantEnCours -= toucheBoisson.getPrix();
        afficherBoisson(toucheBoisson);
        afficherMontant();
        if (montantEnCours == 0)
            etatCourant = idle;
        else
            etatCourant = collecte;

         */
  }

  public void rendreMonnaie() {
    state.rendreMonnaie(this);
        /*if (etatCourant != idle) {
          afficherRetour();
          montantEnCours = 0;
          boisson = null;
        }
        etatCourant = idle;
         */
  }
}

/* NOTES:
* 1) Commencer par créer ce qu'il faut pour le State
* => private State state;
     public MachineACafe() {setState(State.IDLE);}
     public void setState(State state) {this.state = state;}
* 2) Créer le private enum State, avec les différents énumérer vide
* 3) dans le code reçu mettre en commentaire ce qu'on aura plus besoin (ce qui est lié aux enum, state)
* 4) Identifier les méthodes à mettre dans l'enum (commencer avec le plus facile) :
*     - mettre le code en commentaire et ajouter "state.nomMethode(this, +param en plus si besoin)"
*     - voir dans le code mis en commentaire ce qu'on peut diviser
*       - et mettre dans les énumérer (avec @Override devant les méthodes)
*       - ou si ça prend pls énum alors mettre dans classe parente
*     - !!! Ne pas oublier de mettre en paramètre le nom de la classe pour aller chercher les méthodes de la classe !!!
* */