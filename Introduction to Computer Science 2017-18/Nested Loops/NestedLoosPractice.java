public class NestedLoopsPractice {
	public static void main (String[]args) {

//Practice I
		int x = 1;
		int xx = 0;
		while (x <= 4) {
			xx = x;
			while (xx > 0) {
				System.out.print("*");
				xx--;
			}
			System.out.println();
			x++;
		}
		System.out.println();

//Pratice II
		x = 4;
		xx = 0;
		while (x > 0) {
			xx = x;
			while (xx > 0) {
				System.out.print("*");
				xx--;
			}
			System.out.println();
			x--;
		}
		System.out.println();

//Practice III
		x = 3;
		xx = 0;
		while (x <= 12) {
			xx = x;
			while (xx > 0) {
				System.out.print("*");
				xx--;
			}
			System.out.println();
			x+=3;
		}
		System.out.println();

//Practice IV
		x = 3;
		xx = 0;
		for (x = 1; x <= 4; x++) {
			for (xx = x; xx > 0; xx--) {
				System.out.println("*");
			}
			System.out.println("X");
		}
		System.out.println();

//Practice V
		x = 1;
		xx = 0;
		while (x <= 3) {
			for (xx = 5; xx > 0; xx--) {
				System.out.print("*");
			}
			System.out.println();
			x++;
		}
		System.out.println();

//Practice VI
		for (x = 1; x <= 7; x++) {
			for (xx = 0; xx < x; xx++) {
				if (x + xx > 7) {
					break;
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}
}