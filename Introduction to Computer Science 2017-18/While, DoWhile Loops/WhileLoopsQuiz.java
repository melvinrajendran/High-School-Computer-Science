import java.util.Scanner;
public class WhileLoopsQuiz {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner number = new Scanner (System.in);

		int counter = 0;
		int even = 0;
		int odd = 0;
		int total = 0;
		String ans = " ";
		String oddnums = " ";
		String evennums = " ";

		do  {
			System.out.print("Enter a value: ");
			int val = number.nextInt();
			counter++;
			total += val;
			if (val % 2 == 0)
				even++;
			else
				odd++;
			System.out.print("Would you like to enter another value(y/n)?: ");
			ans = reader.nextLine();
		} while (ans.equalsIgnoreCase("Y"));

		if (odd != 1)
			oddnums = "odd numbers";
		else
			oddnums = "odd number";

		if (even != 1)
			evennums = "even numbers";
		else
			evennums = "even number";

		System.out.println("\nYou entered " + odd + " " + oddnums + " and " + even + " " + evennums + ".  The average of the values is " + ((double)(total/counter)) + ".");

	}
}