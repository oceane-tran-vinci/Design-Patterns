package strategies;

public class DeLongueurStrategy implements Strategy {
    private int longueur;

    public DeLongueurStrategy(int longueur) {
        this.longueur = longueur;
    }

    @Override
    public boolean estValide(String mot) {
        return mot.length() == longueur;
    }
}
