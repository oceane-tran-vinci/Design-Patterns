import java.util.HashMap;
import java.util.Map;

public class FlyweightPrototype {
  private final Map<String, Robot> flyweightprototypemap;

  public FlyweightPrototype() {
    this.flyweightprototypemap = new HashMap<>();
  }

  // Ajoute un robot prototype dans la map
  public void addFlyweight(String name, Robot robot) {
    flyweightprototypemap.put(name, robot);
  }

  // Retourne un clone indépendant du prototype associé au nom
  public Robot createRobot(String name) {
    return flyweightprototypemap.get(name).cloneRobot();
  }
}
