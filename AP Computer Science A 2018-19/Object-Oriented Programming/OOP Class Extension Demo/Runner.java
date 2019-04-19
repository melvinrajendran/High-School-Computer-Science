public class Runner {

	public static void main (String[] args) {

		Person p1 = new Person("Bob", "Rebels");
		System.out.println(p1.getName());
		System.out.println(p1);

		JediKnight j1 = new JediKnight("Luke", "Rebels", "Force Push");
		System.out.println(j1.getName());
		System.out.println(j1);

		System.out.println(p1 instanceof Person); //instanceof operator checks whether a variable is an instance of an object class
		System.out.println(p1 instanceof JediKnight);

		System.out.println(j1 instanceof Person);
		System.out.println(j1 instanceof JediKnight);

	}

}