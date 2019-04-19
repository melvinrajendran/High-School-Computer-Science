import java.util.Scanner;
public class SwitchStatementsIII {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner number = new Scanner (System.in);

		System.out.println("Rock, Paper, Scissors!\n\nDifficulties:\tEasy\n\t\tIntermediate\n\t\tHard");
		System.out.print("\nPlease select a difficulty: ");
		String difficulty = reader.nextLine();
		int counter = 0;

		System.out.print("\nRound 1:\nEnter a RPS throw: ");
		String choice1 = reader.nextLine();
		if (difficulty.equals("Easy"))
			counter = easy(counter, choice1);
		else if (difficulty.equals("Intermediate"))
			counter = intermediate(counter, choice1);
		else if (difficulty.equals("Hard"))
			counter = hard(counter, choice1);

		System.out.print("\nRound 2:\nEnter a RPS throw: ");
		String choice2 = reader.nextLine();
		if (difficulty.equals("Easy"))
			counter = easy(counter, choice2);
		else if (difficulty.equals("Intermediate"))
			counter = intermediate(counter, choice2);
		else if (difficulty.equals("Hard"))
			counter = hard(counter, choice2);

		System.out.print("\nRound 3:\nEnter a RPS throw: ");
		String choice3 = reader.nextLine();
		if (difficulty.equals("Easy"))
			counter = easy(counter, choice3);
		else if (difficulty.equals("Intermediate"))
			counter = intermediate(counter, choice3);
		else if (difficulty.equals("Hard"))
			counter = hard(counter, choice3);

		switch (counter) {
			case -3: System.out.println("\nResult: Computer wins!");
					break;

			case -2: System.out.println("\nResult: Computer wins!");
					break;

			case -1: System.out.println("\nResult: Computer wins!");
					break;

			case 0: System.out.println("\nResult: Tie!");
					break;

			case 1: System.out.println("\nResult: You win!");
					break;

			case 2: System.out.println("\nResult: You win!");
					break;

			case 3: System.out.println("\nResult: You win!");
					break;

		}

	}
	public static int easy (int counter, String choose) {
		String compthrowname = " ";
		int compthrow = (int)(Math.random()*3)+1;

		if (compthrow == 1)
			compthrowname = "Rock";
		else if (compthrow == 2)
			compthrowname = "Paper";
		else if (compthrow == 3)
			compthrowname = "Scissors";

		System.out.println("Computer selects: " + compthrowname);

		if ((compthrowname.equals("Rock"))) {
			if ((choose.equals("Paper"))) {
				System.out.println("You win!");
				counter++;
			}
			else if ((choose.equals("Scissors"))) {
				System.out.println("Computer wins!");
				counter--;
			}
			else if ((choose.equals("Rock"))) {
				System.out.println("Tie!");
			}
		}
		else if ((compthrowname.equals("Paper"))) {
			if ((choose.equals("Paper"))) {
				System.out.println("Tie!");
			}
			else if ((choose.equals("Scissors"))) {
				System.out.println("You win!");
				counter++;
			}
			else if ((choose.equals("Rock"))) {
				System.out.println("Computer wins!");
				counter--;
			}
		}
		else if ((compthrowname.equals("Scissors"))) {
			if ((choose.equals("Paper"))) {
				System.out.println("Computer wins!");
				counter--;
			}
			else if ((choose.equals("Scissors"))) {
				System.out.println("Tie!");
			}
			else if ((choose.equals("Rock"))) {
				System.out.println("You win!");
				counter++;
			}
		}
		return counter;

	}
	public static int intermediate (int counter, String choose) {
		int cheater = (int)(Math.random()*2)+1;

		if (cheater == 1) {
			if (choose.equals("Rock")) {
				System.out.println("Computer selects: Paper\nComputer wins!");
				counter--;
			}
			else if (choose.equals("Paper")) {
				System.out.println("Computer selects: Scissors\nComputer wins!");
				counter--;
			}
			else if (choose.equals("Scissors")) {
				System.out.println("Computer selects: Rock\nComputer wins!");
				counter--;
			}
		}
		else if (cheater == 2) {
			String compthrowname = " ";

			int compthrow = (int)(Math.random()*3)+1;
			if (compthrow == 1)
				compthrowname = "Rock";
			else if (compthrow == 2)
				compthrowname = "Paper";
			else if (compthrow == 3)
				compthrowname = "Scissors";

			System.out.println("Computer selects: " + compthrowname);

			if ((compthrowname.equals("Rock"))) {
				if ((choose.equals("Paper"))) {
					System.out.println("You win!");
					counter++;
				}
				else if ((choose.equals("Scissors"))) {
					System.out.println("Computer wins!");
					counter--;
				}
				else if ((choose.equals("Rock"))) {
					System.out.println("Tie!");
				}
			}
			else if ((compthrowname.equals("Paper"))) {
				if ((choose.equals("Paper"))) {
					System.out.println("Tie!");
				}
				else if ((choose.equals("Scissors"))) {
					System.out.println("You win!");
					counter++;
				}
				else if ((choose.equals("Rock"))) {
					System.out.println("Computer wins!");
					counter--;
				}
			}
			else if ((compthrowname.equals("Scissors"))) {
				if ((choose.equals("Paper"))) {
					System.out.println("Computer wins!");
					counter--;
				}
				else if ((choose.equals("Scissors"))) {
					System.out.println("Tie!");
				}
				else if ((choose.equals("Rock"))) {
					System.out.println("You win!");
					counter++;
				}
			}
		}
		return counter;

	}
	public static int hard (int counter, String choose) {

		if (choose.equals("Rock")) {
			System.out.println("Computer selects: Paper\nComputer wins!");
			counter--;
		}
		else if (choose.equals("Paper")) {
			System.out.println("Computer selects: Scissors\nComputer wins!");
			counter--;
		}
		else if (choose.equals("Scissors")) {
			System.out.println("Computer selects: Rock\nComputer wins!");
			counter--;
		}
		return counter;

	}
}