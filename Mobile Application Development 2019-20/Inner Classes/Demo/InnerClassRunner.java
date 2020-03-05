public class InnerClassRunner {

	public static void main (String[] args) {
		SortingHat hat = new SortingHat();
		System.out.println(hat);

		Wizard wizard = new Wizard("ice");
		System.out.println(wizard);

		Wizard.Wand wand = new Wizard.Wand(); //inner class instantiation
		System.out.println(wand);
	}

	public static class SortingHat {
		private String house;
		private String name;

		public SortingHat() {
			this.house = "Gryffindor";
			this.name = "Harry Potter";
		}

		public String toString() { return name + "'s house is " + house; }
	}
}