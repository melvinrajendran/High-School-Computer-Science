public class Olympian extends Athlete {

	private String nationality;
	private int medals;

	public Olympian (String name, int age, String sport, String position, String nationality, int medals) {
		super(name, age, sport, position);
		this.nationality = nationality;
		this.medals = medals;
	}

	public String getNationality() { return nationality; }

	public int getMedals() { return medals; }

	public String toString() { return "This olympian's name is " + getName() + " and he/she is from " + getNationality() + ".  He/she has won " + getMedals() + " medals."; };

}