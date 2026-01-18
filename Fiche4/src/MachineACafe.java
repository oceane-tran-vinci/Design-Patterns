public class MachineACafe {

  /*
   * STATE = les 3 états de la machine (diagramme UML)
   * Chaque état contient :
   * - soit le comportement "par défaut" (hérité)
   * - soit un comportement spécial (override)
   */
  public enum State {

    /*
     * IDLE = aucune monnaie (montantEnCours = 0)
     * Cas spécial : si on sélectionne une boisson → pas assez directement
     */
    IDLE {
      @Override
      public void rendreMonnaie(MachineACafe m) {
        // Rien à rendre, on reste idle
        m.setState(State.IDLE);
      }

      @Override
      public void selectionnerBoisson(ToucheBoisson b, MachineACafe m) {
        // Sans monnaie : toujours "pas assez"
        m.afficherPasAssez(b);
      }
    },

    /*
     * COLLECTE = on a introduit de la monnaie
     * Ici aucun override : on utilise les comportements par défaut (plus bas)
     */
    COLLECTE { },

    /*
     * PAS_ASSEZ = une boisson a été choisie mais il manque de la monnaie
     * Cas spécial :
     * - on ne peut pas choisir une autre boisson
     * - entrerMonnaie doit vérifier si on atteint le prix de la boisson en attente
     */
    PAS_ASSEZ {

      @Override
      public void selectionnerBoisson(ToucheBoisson b, MachineACafe m) {
        // Règle de l'énoncé : interdit de sélectionner autre chose si pas assez
        throw new IllegalStateException();
      }

      @Override
      public void entrerMonnaie(Piece p, MachineACafe m) {
        // On ajoute la pièce
        m.montantEnCours += p.getValeur();
        m.afficherMontant();

        // Si toujours pas assez : on ré-affiche le manque
        if (m.boisson.getPrix() > m.montantEnCours) {
          m.afficherPasAssez(m.boisson);
        } else {
          // Sinon : on sert la boisson en attente
          m.montantEnCours -= m.boisson.getPrix();
          m.afficherBoisson(m.boisson);
          m.boisson = null;

          // Puis on décide le nouvel état selon le reste de monnaie
          m.afficherMontant();
          if (m.montantEnCours == 0) m.setState(State.IDLE);
          else m.setState(State.COLLECTE);
        }
      }
    };

    /*
     * --- COMPORTEMENTS PAR DEFAUT ---
     * Ces méthodes s'appliquent aux états qui ne les override pas
     */

    public void rendreMonnaie(MachineACafe m) {
      // Rendre tout et reset
      m.afficherRetour();
      m.montantEnCours = 0;
      m.boisson = null;
      m.setState(State.IDLE);
    }

    public void selectionnerBoisson(ToucheBoisson b, MachineACafe m) {
      // Si pas assez : on mémorise la boisson et on passe en PAS_ASSEZ
      if (b.getPrix() > m.montantEnCours) {
        m.boisson = b;
        m.afficherPasAssez(m.boisson);
        m.setState(State.PAS_ASSEZ);
        return;
      }

      // Sinon on peut servir direct
      m.montantEnCours -= b.getPrix();
      m.afficherBoisson(b);
      m.afficherMontant();

      // État dépend du montant restant
      if (m.montantEnCours == 0) m.setState(State.IDLE);
      else m.setState(State.COLLECTE);
    }

    public void entrerMonnaie(Piece p, MachineACafe m) {
      // Ajout monnaie + affichage
      m.montantEnCours += p.getValeur();
      m.afficherMontant();

      // Dès qu'on a de la monnaie : on est en COLLECTE
      m.setState(State.COLLECTE);
    }
  }

  // --------- DONNEES DU CONTEXT (MachineACafe) ---------
  private int montantEnCours = 0;     // argent disponible
  private ToucheBoisson boisson = null; // boisson en attente (uniquement en PAS_ASSEZ)
  private State state;               // état courant (remplace etatCourant int)

  public MachineACafe() {
    setState(State.IDLE);
  }

  public void setState(State state) {
    this.state = state;
  }

  // --------- AFFICHAGES (inchangés) ---------
  public void afficherMontant() { System.out.println(montantEnCours + " cents disponibles"); }
  public void afficherRetour() { System.out.println(montantEnCours + " cents rendus"); }
  public void afficherPasAssez(ToucheBoisson b) {
    System.out.println("Vous n'avez pas introduit un montant suffisant pour un " + b);
    System.out.println("Il manque encore " + (b.getPrix() - montantEnCours) + " cents");
  }
  public void afficherBoisson(ToucheBoisson b) { System.out.println("Voici un " + b); }

  // --------- API PUBLIQUE (délégation -> State) ---------
  public void entrerMonnaie(Piece piece) {
    state.entrerMonnaie(piece, this);
  }

  public void selectionnerBoisson(ToucheBoisson toucheBoisson) {
    state.selectionnerBoisson(toucheBoisson, this);
  }

  public void rendreMonnaie() {
    state.rendreMonnaie(this);
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