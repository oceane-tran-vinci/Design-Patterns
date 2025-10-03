public class CircleAbstractFactory implements AbstractFactory {

  @Override
  public Shape createShape(int i, Point point) {
    return new Circle(i, point);
  }
}
