public class Runner {

	public static void main (String [] args) {

		Human h1 = new Human("Jack", 10);
		System.out.println(h1 + "\n");

		Athlete a1 = new Athlete("Steven", 15, "Track and Field", "1600m Dash");
		System.out.println(a1 + "\n");

		Olympian o1 = new Olympian("Michael Phelps", 33, "Swimming", "100m Butterfly", "United States", 28);
		System.out.println(o1 + "\n");

		if ((o1 instanceof Human == true) && (o1 instanceof Athlete == true) && (o1 instanceof Olympian))
			System.out.println(o1.getName() + " is a human, athlete, and olympian.\n");

		//o1 is an Olympian, whose class is an extension of the parent class Athlete.
		//Athlete is an extension of the parent class Human.
		//Hence, o1 is considered an Olympian class, Athlete class, and Human class.

	}

}