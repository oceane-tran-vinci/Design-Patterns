public class CanonDecorator extends RobotDecorator {

  public CanonDecorator(Robot robotDecorator) {
    super(robotDecorator.cloneRobot());
  }

  @Override
  public int getCanon() {
    return super.getCanon()*2;
  }
}
