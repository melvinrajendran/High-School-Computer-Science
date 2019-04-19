import java.util.Scanner;
public class WhileLoops2PracticeIImodI {
	public static void main (String[]args) {

	Scanner number = new Scanner (System.in);

		System.out.println("Welcome to the Random Guesser Game!\nYou have five attempts to guess what the random number is between 1 and 100.\n");
		int num = (int)(Math.random()*100)+1;

		int attempts = 5;
		int score = 5;

		while (attempts > 0) {
			System.out.print("Enter your guess: ");
			int answer = number.nextInt();
			if (answer == num) {
				System.out.println("\nCorrect!  The number was " + num + ".  Your score is " + score + ".");
				break;
			}
			else {
				if (answer < num) {
					System.out.println("Your guess was too low.\n");
				}
				else if (answer > num) {
					System.out.println("Your guess was too high.\n");
				}
				score--;
			}
			attempts--;
		}

		if (attempts == 0) {
			System.out.println("\nYou lose.  You have run out of tries.  The number was " + num + ".");
		}
	}
}