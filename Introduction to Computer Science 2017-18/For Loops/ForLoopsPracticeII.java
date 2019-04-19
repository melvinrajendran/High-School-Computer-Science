import java.util.Scanner;
public class ForLoopsPracticeII {
	public static void main (String[]args) {

		for (int line = 0; line < 20; line++) {

			for (int a = 0; a < 20; a++) {
			    if (line == 10)
					System.out.print("*");
				else
					if ((a == 0) || (a == 19))
				 		System.out.print("*");
				 	else
				 		System.out.print(" ");
			}

			for (int b = 0; b < 3; b++) {
				System.out.print(" ");
			}

			for (int c = 0; c < 20; c++) {
				if ((line == 0) || (line == 19))
					System.out.print("*");
				else {
					if (c == 10)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			for (int d = 0; d < 3; d++) {
					System.out.print(" ");
				}

			for (int e = 0; e < 20; e++) {
				if ((line == 0) || (line == 19))
					System.out.print("*");
				else {
					if ((e == 0) || (e == 19))
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}