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
  List<Strategy> strategies = new ArrayList<>();

  public OuComposite(Strategy... s) {
    this.strategies.addAll(Arrays.asList(s));
  }

  @Override
  public boolean estValide(String mot) {
    boolean or = false;

    for (Strategy s : strategies) {
      if (s.estValide(mot)) {
        or = true;
      }

    }
    return or;
  }
}
