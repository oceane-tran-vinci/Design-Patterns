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
		/*2) DECORATOR */
		// Robot 1 : Canon = 10, Shield = 2, Freq = 100
		// Amélioration : canon multiplié par 2
		Robot super_robot1= new CanonDecorator(new RobotImpl.Builder("Super Robot 1").canon(10).shield(2).freq(100).build());
		// Robot 2 : Canon = 9, Shield = 3, Freq = 90
		// Améliorations : bouclier ×2 et life des dégâts ÷2
		Robot super_robot2= new LifeDecorator(new ShieldDecorator(new RobotImpl.Builder("Super Robot 2").canon(9).shield(3).freq(90).build()));

		fight(super_robot1, super_robot2);
	}
}
