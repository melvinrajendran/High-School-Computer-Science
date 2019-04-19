import java.util.Scanner;
public class WhileLoopsPracticeI {
	public static void main (String[]args) {

		Scanner number = new Scanner (System.in);

		System.out.print("Enter a value: ");
		int p = number.nextInt();
		int x = p;
		System.out.print("\nThe powers of " + p + " that are less than 10000 are ");
		while (p < 10000) {
			int c = x*p;
			if (c > 10000) {
				System.out.print("and " + p + ".\n");
				p*=x;

			}
			else {
				System.out.print(p + ", ");
				p*=x;
			}
		}
		System.out.println();
	}
}