public class PersonRunner {

	public static void main (String [] args) {
		Person p1 = new Person("Melvin", 16);
		Person p2 = new Person("Leslie", 19);

		System.out.println(p1.compareTo(p2));
	}
}