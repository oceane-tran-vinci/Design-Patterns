public class RobotImpl implements Robot, Cloneable {

  private final String name;
  private final int canon;
  private final int shield;
  private final int freq;
  private int life; //pas final car il change pdt le combat voir diffLife dans interface

  public RobotImpl(Builder builder) {
    this.name = builder.name;
    this.canon = builder.canon;
    this.shield = builder.shield;
    this.freq = builder.freq;
    this.life = builder.life;
  }

  @Override
  public int getCanon() {
    return canon;
  }

  @Override
  public int getShield() {
    return shield;
  }

  @Override
  public int getFreq() {
    return freq;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int diffLife(int i) {
    /*
     * Si i < 0 → dégâts → on enlève des points de vie.
     * Si i > 0 → soin → on ajoute des points de vie.
     * Si i == 0 → juste un getter, on ne change rien.
     * */
    if (i < 0) {
      life += i; // i est négatif → on soustrait
      if (life < 0) {
        life = 0;
      }
    } else if (i > 0) {
      life += i; // i positif → on soigne
      if (life > 100) {
        life = 100; // optionnel, pour ne pas dépasser le max
      }
    }
    return life; // si i == 0, on renvoie juste la vie actuelle
  }


  @Override
  public Robot cloneRobot(){
    try {
      return (Robot) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }

  public static class Builder {

    //mettre final que les valeurs pas par défaut
    //On dit que tt ces variables à ça par défaut, commence comme ça sauf le nom qui n'est pas par défaut
    private final String name;
    private int canon = 1;
    private int shield = 1;
    private int freq = 100;
    private int life = 100;

    public Builder(String name) {
      this.name = name;
    }

    public Builder canon(int canon) {
      this.canon = canon;
      return this;
    }

    public Builder shield(int shield) {
      this.shield = shield;
      return this;
    }

    public Builder freq(int freq) {
      this.freq = freq;
      return this;
    }

    public Builder life(int life) {
      this.life = life;
      return this;
    }

    public RobotImpl build() {
      return new RobotImpl(this);
    }
  }
}
