public class CriticalQuestion2ReviewII {
	public static void main (String[]args) {

		for (int i = 123; i <= 456; i++) {
			if (i % 3 == 0) {
				if (i % 5 == 0) {
					System.out.print(i + " ");
				}
			}
		}
		System.out.println("\n");
	}
}