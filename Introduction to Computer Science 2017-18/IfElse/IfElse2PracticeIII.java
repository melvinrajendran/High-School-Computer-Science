import java.util.Scanner;
public class IfElse2PracticeIII {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);

		System.out.print("Please enter a four-digit number: ");
		int num1 = reader.nextInt();
		System.out.println("The number " + num1 + " is " + evendivisible4(num1));

		}
		public static String evendivisible4 (int a){
			String identifier = " ";
			if ((a > 9999) || (a < 1000))
				identifier = "not 4 digits.";
			else {
				if ((a % 2 == 0) && (a % 11 == 0))
					identifier = "both even and divisible by 11.";
				else if ((a % 2 == 0) || (a % 11 == 0))
					identifier = "either even or divisible by 11.";
				else if ((a % 2 == 1) && (a % 11 != 0))
					identifier = "neither even or divisible by 11.";
			}
			return identifier;

	}
}