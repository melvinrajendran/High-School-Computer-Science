import java.util.Scanner;
public class IfElsePracticeIII {
	public static void main (String[]args) {

	Scanner reader = new Scanner (System.in);

	System.out.print("Please enter a number: ");
	double value = reader.nextDouble();
	System.out.println("Would you like to (a)dd 2, (s)ubtract 2, (m)ultiply by 2, (d)ivide by 2, or (r)aise to the 2nd power: ");
	reader.nextLine();
	String choice = reader.nextLine();

	if (choice.equals("a"))
		System.out.println("The result when adding 2 to " + value + " is " + add(value) + ".");
	else if (choice.equals("s"))
		System.out.println("The result when subtracting 2 from " + value + " is " + subtract(value) + ".");
	else if (choice.equals("m"))
		System.out.println("The result when multiplying " + value + " by 2 is " + multiply(value) + ".");
	else if (choice.equals("d"))
		System.out.println("The result when dividing " + value + " by 2 is " + divide(value) + ".");
	else if (choice.equals("r"))
		System.out.println("The result when raising " + value + " to the 2nd power is " + raise(value) + ".");

	}
	public static double add (double a){
		double b = a + 2;
		return b;

	}
	public static double subtract (double c){
		double d = c - 2;
		return d;

	}
		public static double multiply (double e){
			double f = e * 2;
			return f;

	}
		public static double divide (double g){
			double h = g / 2.0;
			return h;

	}
		public static double raise (double i){
			double j = i * i;
			return j;

	}
}