import java.util.Scanner;
public class IfElseReviewIII {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);

		System.out.print("Please enter an integer: ");
		int num1 = reader.nextInt();

		divisiblecalc(num1);

	}
	public static void divisiblecalc (int a){
		if (a % 2 == 0)
			System.out.println("\nThis number is divisible by 2.");
		else
			System.out.println("\nThis number is not divisible by 2.");
		if (a % 3 == 0)
			System.out.println("This number is divisible by 3.");
		else
			System.out.println("This number is not divisible by 3.");
		if (a % 5 == 0)
			System.out.println("This number is divisible by 5.");
		else
			System.out.println("This number is not divisible by 5.");
		if (a % 7 == 0)
			System.out.println("This number is divisible by 7.");
		else
			System.out.println("This number is not divisible by 7.");
		if (a % 11 == 0)
			System.out.println("This number is divisible by 11.\n");
		else
			System.out.println("This number is not divisible by 11.\n");


	}
}