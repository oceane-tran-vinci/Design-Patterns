public class ConcreteFactoryGrosseBerta implements AbstractFactory {

  @Override
  public Robot createRobot() {
    //Très lente, mais inflige des dégâts énormes.
    Robot grosseBerta = new RobotImpl.Builder("Grosse Berta")
        .canon(12)    // gros dégâts
        .shield(4)
        .freq(40)     // tire lentement
        .life(100)
        .build();

    return new CanonDecorator(grosseBerta);// augmente encore les dégâts
  }
}
