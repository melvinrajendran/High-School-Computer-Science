public class Teacher extends Person {
	private String occupation;

	public Teacher(String name, int age, String occupation) {
		super(name, age);
		this.occupation = occupation;
	}

	public String getOccupation() { return occupation; }

	public void setOccupation(String newOccupation) { occupation = newOccupation; }
}