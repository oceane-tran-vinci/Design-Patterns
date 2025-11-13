public class ConcreteFactoryPicVert implements AbstractFactory {

  @Override
  public Robot createRobot() {
    //Rapide, faible, mais canon correct.
    return new RobotImpl.Builder("Pic-Vert")
        .canon(6)     // faible
        .shield(2)    // faible
        .freq(150)    // tire très vite
        .life(100)
        .build();
  }
}
