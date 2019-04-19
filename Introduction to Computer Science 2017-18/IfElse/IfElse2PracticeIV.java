import java.util.Scanner;
public class IfElse2PracticeIV {

/*
Author: Melvin Rajendran
Date: 11/18/2017
*/

	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);

		System.out.print("Please enter a number: ");
		int num1 = reader.nextInt();
		System.out.println(identifier(num1));
	}
	public static String identifier (int a) {
		String identifier = " ";
		if (((a > 9) && (a < 100)) && (a % 2 == 1))
			identifier = "You win!";
		else if (((a > 9) && (a < 100)) || (a % 2 == 1))
			identifier = "You're close.";
		else if (((a < 10) || (a > 99)) && (a % 2 == 0))
			identifier = "You lose.";
		return identifier;
	}
}