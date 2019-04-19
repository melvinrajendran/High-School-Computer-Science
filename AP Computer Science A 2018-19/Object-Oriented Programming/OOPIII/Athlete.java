public class Athlete extends Human {

	private String sport;
	private String position;

	public Athlete(String name, int age, String sport, String position) {
		super(name, age);
		this.sport = sport;
		this.position = position;
	}

	public String getSport() { return sport; }

	public String getPosition() { return position; }

	public String toString() { return "This athlete's name is " + getName() + " and his/her sport is " + getSport() + "."; };

}