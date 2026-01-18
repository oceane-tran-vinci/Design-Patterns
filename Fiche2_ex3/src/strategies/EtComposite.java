package strategies;

/*
- ANDComposite / ORComposite = binaires → exactement deux stratégies.
- EtComposite / OuComposite = n-aires → autant de stratégies que tu veux.
- “à l’infini” = pas limité à 2.
- Pour stocker plusieurs stratégies → soit un tableau, soit une liste.
- En Java, le plus simple ici = varargs (Strategy... s), qui est compilé en tableau automatiquement.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EtComposite implements Strategy {
  // 1️⃣ Le composite contient PLUSIEURS stratégies
  List<Strategy> strategies = new ArrayList<>();

  // 2️⃣ Constructeur : reçoit toutes les stratégies à combiner
  public EtComposite(Strategy... s) {
    this.strategies.addAll(Arrays.asList(s));
  }

  // 3️⃣ Même méthode que Strategy (component)
  @Override
  public boolean estValide(String mot) {
    // 4️⃣ AND logique : toutes doivent être vraies
    for (Strategy s : strategies) {
      if (!s.estValide(mot)){
        return false;// UNE seule fausse → tout faux
      }
    }
    return true;// toutes vraies
  }
}
