import java.util.Scanner;
public class WhileLoops2PracticeI {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner number = new Scanner (System.in);

		System.out.print("Welcome to the multiplication tutor!\nWhat is your name? ");
		String name = reader.nextLine();
		System.out.println("Let's see how good you are at multiplication, " + name + ".\nType -1 at any time to exit and see your score.\n");

		int counter = 0;
		int correct = 0;
		int answer = 0;

			while (answer >= 0) {
			int num1 = (int)(Math.random()*9)+1;
			int num2 = (int)(Math.random()*9)+1;
			System.out.print("What is " + num1 + " * " + num2 + "? ");
			answer = number.nextInt();
			if (answer == (num1 * num2)) {
				System.out.println("Correct!\n");
				correct++;
				counter++;
			}
			else if ((answer != (num1 * num2)) && (answer >= 0)) {
				System.out.println("Sorry!  The answer was " + (num1 * num2) + ".\n");
				counter++;
			}
			else if (answer < 0) {
				System.out.println("\nLet's see, " + name + "!  You got " + correct + " out of " + counter + " correct.");
				if (correct == counter) {
					System.out.println("You've mastered multiplication!\n");
				}
				else if (correct >= (counter / 2)) {
					System.out.println("You've almost got it!\n");
				}
				else {
					System.out.println("You really need to practice!\n");
				}
			}
		}
	}
}