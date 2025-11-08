public class RobotDecorator implements Robot {
  private final Robot robotDecorator;

  public RobotDecorator(Robot robotDecorator) {
    this.robotDecorator = robotDecorator;
  }

  @Override
  public int getCanon() {
    return robotDecorator.getCanon();
  }

  @Override
  public int getShield() {
    return robotDecorator.getShield();
  }

  @Override
  public int getFreq() {
    return robotDecorator.getFreq();
  }

  @Override
  public String getName() {
    return robotDecorator.getName();
  }

  @Override
  public int diffLife(int i) {
    return robotDecorator.diffLife(i);
  }
}
