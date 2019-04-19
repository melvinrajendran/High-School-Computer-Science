import java.util.Scanner;
public class SwitchReviewIII {
//Random Output Switches
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner number = new Scanner (System.in);

		System.out.println("a. 0-10 inclusive\nb. 1-5 inclusive\nc. 10-80 inclusive\nd. -10 - +15 inclusive\n");
		System.out.print("Please select a range option to generate a random number: ");
		String range = reader.nextLine();
		int random = 0;

		switch (range) {
			case "a": random = (int)(Math.random()*11);
					if ((random > 4) && (random != 8) && (random % 2 == 0) && (random != 6))
						System.out.println("\nA DID IT!\n");
					else
						System.out.println("\nA DIDN'T\n");
					break;

			case "b": random = (int)(Math.random()*5)+1;
					if ((random % 2 != 0) && (random < 4))
						System.out.println("\nB CRAZY!\n");
					else
						System.out.println("\nB NOT SO CRAZY\n");
					break;

			case "c": random = (int)(Math.random()*71)+10;
					if ((random % 2 != 0) && (random % 3 == 0) && ((random / 10) % 2 == 0))
						System.out.println("\nC YA!\n");
					else
						System.out.println("\nNO C YA!\n");
					break;

			case "d": random = (int)(Math.random()*26)-10;
					if ((-7 <= random) && (random <= 7) && ((random * random) % 2 == 0))
						System.out.println("\nD-RIFIC!\n");
					else
						System.out.println("\nD-ERRIBLE\n");
					break;

		}
	}
}