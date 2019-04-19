public class NestedLoopsPracticeI {
	public static void main (String[]args) {

//Practice I
		/*for (int o = 1; o < 5; o++) {
			for (int i = 0; i < o; i++) {
				System.out.print("*");
			}
			System.out.println();
		}

//Practice II
		for (int o = 1; o < 5; o++) {
			for (int i = 5; i > o; i--) {
				System.out.print("*");
			}
			System.out.println();
		}

//Practice III
		for (int o = 1; o < 4; o++) {
			for (int i = 4; i > o; i--) {
				System.out.print("**");
			}
			System.out.println();
		}*/

//Practice IV
		for (int o = 0; o < 10; o++) {
			if (o > 0)
				System.out.print(o + "\t");
			for (int i = 1; i < 10; i++) {
				if (o == 0) {
					if (i == 1)
						System.out.print("\t");
					System.out.print(i + "\t");
				}
				else
						System.out.print((i * o) + "\t");
			}
			System.out.println();
		}
	}
}