public class DrawCarWithSquare extends DrawCar {

  @Override
  public Shape createShape(int i, Point point) {
    return new Square(i, point);
  }
}
