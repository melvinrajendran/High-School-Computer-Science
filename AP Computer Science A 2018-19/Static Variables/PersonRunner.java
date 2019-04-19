public class PersonRunner
{
	public static void main (String [] args)
	{
		Person p1 = new Person();
		System.out.println("*P1*" + p1);

		p1.add();
		p1.add();
		p1.add();

		System.out.println("*P1*" + p1);

		Person p2 = new Person();
		System.out.println("*P2*" + p2);

		p2.add();
		p2.add();

		System.out.println("*P2*" + p2);

		System.out.println(Person.staticPersonCounter); //syntax for clearly referring to static variable

		Math.random();
	}
}