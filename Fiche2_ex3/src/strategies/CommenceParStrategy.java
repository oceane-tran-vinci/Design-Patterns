package strategies;

public class CommenceParStrategy implements Strategy {
    private char commencePar;

    public CommenceParStrategy(char commencePar) {
        this.commencePar = commencePar;
    }

    @Override
    public boolean estValide(String mot) {
        return mot.charAt(0) == commencePar;
    }
}
