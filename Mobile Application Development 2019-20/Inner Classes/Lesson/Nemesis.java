public class Nemesis implements Comparable<Nemesis> {
	private String name;

	public Nemesis(String name) {
		this.name = name;
	}

	public int compareTo(Nemesis n) {
			return this.name.compareTo(n.name);
		}

	public String toString() { return "The nemesis is " + name + "."; }

	public static class Weapon {
		private String range;

		public Weapon(String range) {
			this.range = range;
		}

		public String toString() { return "This weapon is " + range + "-range."; }		
	}
}