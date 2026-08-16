public class ConcreteFactoryTank implements AbstractFactory {

  @Override
  public Robot createRobot() {
    //Beaucoup de défense, mais pas invincible.
    Robot tank = new RobotImpl.Builder("Tank")
        .canon(4)      // faible
        .shield(4)     // bonne défense mais pas invincible
        .freq(60)      // lent
        .life(200)     // beaucoup de PV
        .build();

    return new ShieldDecorator(tank);  // reçoit encore moins de dégâts
  }
}
