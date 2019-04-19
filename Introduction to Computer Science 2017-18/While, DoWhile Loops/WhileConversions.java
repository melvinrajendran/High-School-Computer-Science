public class WhileConversions {
	public static void main (String[]args) {

		//Practice 0
		for (int x = 2; x <= 9; x++) {
			System.out.println(x + "x");
		}
		System.out.println();

		//Practice 1
		int z = 1;
		for (int y = 1; y < 6; y++) {
			z += y;
 			y++;
		}
		System.out.println(z + "\n");

		//Practice 2
		int j = 1;
		int i = 2;
		while (i <= 12) {
			j *= i;
			i += 3;
		}
		System.out.println(j + "\n");

	}
}