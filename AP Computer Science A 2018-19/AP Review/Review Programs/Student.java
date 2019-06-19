public class Student extends Person {
	private String occupation;

	public Student(String name, int age, String occupation) {
		super(name, age);
		this.occupation = occupation;
	}

	public String getOccupation() { return occupation; }

	public void setOccupation(String newOccupation) { occupation = newOccupation; }

	public int compareTo(Person p2) {
		
	}
}