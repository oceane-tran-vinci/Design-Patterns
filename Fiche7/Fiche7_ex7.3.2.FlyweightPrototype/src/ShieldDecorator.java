public class ShieldDecorator extends RobotDecorator {

  public ShieldDecorator(Robot robotDecorator) {
    super(robotDecorator.cloneRobot());
  }

  @Override
  public int getShield() {
    return super.getShield() *2;
  }
}
