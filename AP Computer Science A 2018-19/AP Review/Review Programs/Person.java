public class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() { return name; }

	public void setName(String newName) { name = newName; }

	public int getAge()  { return age; }

	public void setAge(int newAge) { age = newAge; }

	public int compareTo(Person p2) {
		if (age < p2.getAge())
			return -1;
		else if (age > p2.getAge())
			return 1;
		else {
			if (name.compareTo(p2.getName()) < 0)
				return -1;
			else if (name.compareTo(p2.getName()) > 0)
				return 1;
			else
				return 0;
		}
	}
}