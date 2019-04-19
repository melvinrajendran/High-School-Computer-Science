import java.util.Scanner;
public class IfElse2PracticeI {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);

		System.out.print("Please enter a number: ");
		int num1 = reader.nextInt();
		System.out.println(evenorodd(num1));

	}
	public static String evenorodd (int a){
		String evenorodd = " ";
		if (a > 10 && a % 2 == 0)
			evenorodd = "The number is greater than 10 and even.";
		else if (a > 10 && a % 2 == 1)
			evenorodd = "The number is greater than 10 and odd.";
		else if (a < 10 && a % 2 == 0)
			evenorodd = "The number is less than 10 and even.";
		else if (a < 10 && a % 2 == 1)
			evenorodd = "The number is less than 10 and odd.";
		else
			evenorodd = "The number is 10 and even.";
		return evenorodd;
	}
}