import java.util.Scanner;
public class IfElsePractice {
	public static void main (String[]args) {

	Scanner reader = new Scanner (System.in);

	System.out.print("Please enter a number: ");
	int value = reader.nextInt();
	System.out.println(value + " is " + Parity(value));

	}
	public static String Parity(int a){
		String par;
		if(a % 2 == 0)
			par = "an even number.";
		else
			par = "an odd number.";
		return par;

	}
}