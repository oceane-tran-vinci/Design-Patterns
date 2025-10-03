public class DrawCarWithCircle extends DrawCar {


  @Override
  public Shape createShape(int i, Point point) {
    return new Circle(i, point);
  }
}
