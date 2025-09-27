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
  List<Strategy> strategies = new ArrayList<>();

  public EtComposite(Strategy... s) {
    this.strategies.addAll(Arrays.asList(s));
  }

  @Override
  public boolean estValide(String mot) {
    for (Strategy s : strategies) {
      if (!s.estValide(mot)){
        return false;
      }
    }
    return true;
  }
}
