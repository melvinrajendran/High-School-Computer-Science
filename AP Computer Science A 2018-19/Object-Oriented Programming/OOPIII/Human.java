public class Human {

	private String name;
	private int age;

	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() { return name; }

	public int getAge() { return age; }

	public String toString() { return "This human's name is " + getName() + " and he/she is " + getAge() + " years old."; }

}