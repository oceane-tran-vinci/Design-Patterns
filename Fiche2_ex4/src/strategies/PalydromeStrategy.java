package strategies;

public class PalydromeStrategy implements Strategy {
    @Override
    public boolean estValide(String mot) {
        StringBuffer stringbuffer = new StringBuffer(mot);
        return mot.equals(stringbuffer.reverse().toString());
    }
}
