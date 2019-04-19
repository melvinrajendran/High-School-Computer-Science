import java.util.Scanner;
public class WhileLoopsPracticeIII {
	public static void main (String[]args) {

		Scanner number = new Scanner (System.in);

		int gradecounter = 0;
		int times = 0;
		int a = 1;
		while (a == 1) {
			System.out.print("Grade: ");
			int g = number.nextInt();
			if (g != -1) {
				gradecounter+=g;
				times++;
			}
			else {
				System.out.println("The average of the grades entered is " + (double)(gradecounter/times) + ".");
				break;
			}
		}
		System.out.println();
	}
}