package strategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
- ANDComposite / ORComposite = binaires → exactement deux stratégies.
- EtComposite / OuComposite = n-aires → autant de stratégies que tu veux.
- “à l’infini” = pas limité à 2.
- Pour stocker plusieurs stratégies → soit un tableau, soit une liste.
- En Java, le plus simple ici = varargs (Strategy... s), qui est compilé en tableau automatiquement.
 */

public class OuComposite implements Strategy {
  // 1️⃣ Le composite contient PLUSIEURS stratégies
  List<Strategy> strategies = new ArrayList<>();

  // 2️⃣ Constructeur : reçoit toutes les stratégies à combiner
  public OuComposite(Strategy... s) {
    this.strategies.addAll(Arrays.asList(s));
  }

  // 3️⃣ Même méthode que Strategy (component)
  @Override
  public boolean estValide(String mot) {
    // 4️⃣ OR logique : une seule vraie suffit
    for (Strategy s : strategies) {
      if (s.estValide(mot)) {
        return true; // UNE vraie → tout vrai
      }
    }
    return false; // aucune vraie
  }
}
