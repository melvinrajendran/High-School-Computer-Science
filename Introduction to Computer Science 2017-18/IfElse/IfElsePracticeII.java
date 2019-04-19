import java.util.Scanner;
public class IfElsePracticeII {
	public static void main (String[]args) {

	Scanner reader = new Scanner (System.in);

	System.out.print("Please enter a number: ");
	int value1 = reader.nextInt();
	System.out.print("Please enter another number: ");
	int value2 = reader.nextInt();
	System.out.println(value1 + Parity(value1, value2) + value2 + ".");

	}
	public static String Parity(int a, int b){
		String par;
		if(a > b)
			par = " is greater than ";
		else if (a == b)
			par = " is equal to ";
		else
			par = " is less than ";
		return par;

	}
}