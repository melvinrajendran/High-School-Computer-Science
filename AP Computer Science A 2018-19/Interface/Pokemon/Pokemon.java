public class Pokemon implements Comparable<Pokemon> {

	private String name;
	private int hitPoints;

	public Pokemon(String name, int hitPoints) {
		this.name = name;
		this.hitPoints = hitPoints;
	}

	public String getName() { return name; }

	public int getHitPoints() { return hitPoints; }

	public int compareTo(Pokemon p1) {
		if (getHitPoints() < p1.getHitPoints())
			return -1;
		else if (getHitPoints() == p1.getHitPoints()) {
			if (name.compareTo(p1.getName()) < 0)
				return -1;
			else if (name.compareTo(p1.getName()) == 0)
				return 0;
			else
				return 1;
		}
		else
			return 1;
	}

	public String toString() { return name + " - " + hitPoints + " HP"; }

}