import java.util.Scanner;
public class ForLoopsPracticeImodI {
	public static void main (String[]args) {

		Scanner number = new Scanner (System.in);

		System.out.print("How many scores would you like to output? ");
		int scores = number.nextInt();
		int o = 0;
		int s = 0;
		int u = 0;
		System.out.println();

		for (int i = 1; i <= scores; i++) {
			int test = (int)(Math.random()*41)+60;
			System.out.println("Test #" + i + ": " + test);
			if ((test >= 0) && (test <= 69))
				u++;
			else if ((test >= 70) && (test <= 89))
				s++;
			if ((test >= 90) && (test <= 100))
				o++;
		}
		System.out.println("\nOutstanding Scores: " + o);
		System.out.println("Satisfactory Scores: " + s);
		System.out.println("Unsatisfactory Scores: " + u + "\n");

	}
}