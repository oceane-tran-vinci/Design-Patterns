import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
  private final Map<String, AbstractFactory> abstractFactoryMap;

  public FlyweightFactory() {
    abstractFactoryMap = new HashMap<>();
  }

  public void addFlyweight(String name, AbstractFactory abstractFactory){
    abstractFactoryMap.put(name, abstractFactory);
  }

  public AbstractFactory getFactory(String name) {
    return abstractFactoryMap.get(name);
  }

  public Robot createRobot(String name){
    //createRobot() vient de l'interface AbstractFactory
    return abstractFactoryMap.get(name).createRobot();
  }
}
