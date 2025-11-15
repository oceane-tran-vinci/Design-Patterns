public abstract class RobotDecorator implements Robot {

  private Robot robotDecorator;

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

  //ajout du clone
  @Override
  public Robot cloneRobot() {
    try {
      RobotDecorator res = (RobotDecorator) super.clone();
      res.robotDecorator = robotDecorator.cloneRobot();
      return res;
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }

}
