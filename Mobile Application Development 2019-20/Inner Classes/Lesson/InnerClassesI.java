import java.util.*;

public class InnerClassesI {

	public static void main (String[] args) {
		SuperHero spiderMan = new SuperHero("Spider-Man", 17, "spider-sense");
		System.out.println(spiderMan + "\n");

		spiderMan.webSling();

		spiderMan.fight();
		spiderMan.fight();

		spiderMan.getOld();

		System.out.println("\n" + spiderMan + "\n");

		Nemesis thanos = new Nemesis("Thanos");
		System.out.println(thanos);

		Nemesis ultron = new Nemesis("Ultron");
		System.out.println(ultron);

		Nemesis.Weapon gauntlet = new Nemesis.Weapon("short");
		System.out.println(gauntlet);

		ArrayList<Nemesis> list = new ArrayList<>();
		list.add(ultron);
		list.add(thanos);

		Collections.sort(list);

		System.out.println(list);
	}

	public static class SuperHero {
		private String name;
		private int age;
		private String superpower;

		public SuperHero(String name, int age, String superpower) {
			this.name = name;
			this.age = age;
			this.superpower = superpower;
		}

		public void webSling() {
			if (name.equalsIgnoreCase("Spider-Man"))
				System.out.println(name + " web-slings!");
			else
				System.out.println(name + " can't web-sling...");
		}

		public void fight() {
			int random = (int)(Math.random() * 3) + 1;

			if (random == 1)
				System.out.println("POW!");
			else if (random == 2)
				System.out.println("WHAM!");
			else
				System.out.println("BAM!");
		}

		public void getOld() {
			age += 10;
		}

		public String toString() { return name + " is " + age + " years old and has the superpower of " + superpower + "."; }
	}
}