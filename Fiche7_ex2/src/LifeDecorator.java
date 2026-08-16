public class LifeDecorator extends RobotDecorator {

  public LifeDecorator(Robot robotDecorator) {
    super(robotDecorator);
  }

  @Override
  public int diffLife(int i) {
    if (i < 0){
      i /= 2; // réduit les dégâts de moitié
    }

    return super.diffLife(i);
  }
}
