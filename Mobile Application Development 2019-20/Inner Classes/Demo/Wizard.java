public class Wizard {
	private String magicType;

	public Wizard(String magicType) {
		this.magicType = magicType;
	}

	public String toString() { return "The magic type is " + magicType; }

	public static class Wand {
		private String core;

		public Wand() {
			this.core = "Dragon Heart";
		}

		public String toString() { return "The core is " + core; }
	}
}