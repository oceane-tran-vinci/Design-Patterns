import javax.sound.midi.Soundbank;

public class PatternRobots {
	
	public static void fight(Robot robot1, Robot robot2) {
		int tick1=robot1.getFreq();
		int tick2=robot2.getFreq();
		while(robot2.diffLife(0)>0 && robot1.diffLife(0)>0) {
			int tick=Math.min(tick1, tick2);
			tick1-=tick;
			tick2-=tick;
			if (tick1==0) {// robot 1 feu
				tick1=shoot(robot1,robot2);
			}
			if (tick2==0) {// robot 2 feu
				tick2=shoot(robot2,robot1);
			}
		}
	}
	
	private static int shoot(Robot robot1, Robot robot2) {
		int dmg=Math.max(0,robot1.getCanon()-robot2.getShield());
		int lost=robot2.diffLife(0)-robot2.diffLife(-dmg);
		System.out.println(robot1.getName()+" shoots for "+lost);
		if (robot2.diffLife(0)<=0) {
			System.out.println("Kabooom "+robot2.getName());
		}
		return robot1.getFreq();
	}
	
	public static void main(String[] args) {
		/*1) BUILDER*/
		// un robot avec un canon de 10, un bouclier de 2, une fr�quence de tir de 100 et qui a re�u une am�lioration de canon multipliant la puissance de ce dernier par 2.
		Robot robot1= new RobotImpl.Builder("Robot 1").canon(10).shield(2).freq(100).build();
		// un robot avec un canon de 9, un bouclier de 3, une fr�quence de tir de 90
		// et qui a re�u une am�lioration de bouclier multipliant ce dernier par 2 et une am�lioration de mitigation des d�gats qui r�duit les points de vue perdus par 2.
		Robot robot2= new RobotImpl.Builder("Robot 2").canon(9).shield(3).freq(90).build();

		/*2) DECORATOR */
		// Robot 1 : Canon = 10, Shield = 2, Freq = 100
		// Amélioration : canon multiplié par 2
		Robot super_robot1= new CanonDecorator(new RobotImpl.Builder("Super Robot 1").canon(10).shield(2).freq(100).build());
		// Robot 2 : Canon = 9, Shield = 3, Freq = 90
		// Améliorations : bouclier ×2 et life des dégâts ÷2
		Robot super_robot2= new LifeDecorator(new ShieldDecorator(new RobotImpl.Builder("Super Robot 2").canon(9).shield(3).freq(90).build()));

		/*3.1) FlyweightFactory */
		FlyweightFactory fly = new FlyweightFactory();
		fly.addFlyweight("picvert", new ConcreteFactoryPicVert());
		fly.addFlyweight("grosse_berta", new ConcreteFactoryGrosseBerta());
		fly.addFlyweight("tank", new ConcreteFactoryTank());

		Robot FF_picvert = fly.createRobot("picvert");
		Robot FF_grosse_berta = fly.createRobot("grosse_berta");
		Robot FF_tank = fly.createRobot("tank");

		System.out.println("Builder : \n");
		fight(robot1, robot2);
		System.out.println("\n");

		System.out.println("Decorator : \n");
		fight(super_robot1, super_robot2);
		System.out.println("\n");

		System.out.println("FlyweightPrototype : \n");

	}
}
