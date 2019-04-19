import java.util.Scanner;
public class IfElseStatements {
	public static void main (String[]args) {
		Scanner reader = new Scanner (System.in);

		int a = 5, b = 27, c = 5;

		if(a == 5)
			System.out.println("a is 5");
		//if(a!=5)
			//System.out.println("a is not 5");
		else
			System.out.println("a is not 5");
		if(b > 0)
			System.out.println("b is positive");
		else if(b == 0)
			System.out.println("b is zero");
		else
			System.out.println("b is negative");

		boolean dennis = true;
		boolean chandler = true;

		if(dennis==true){
			if(chandler==true)
				System.out.println("D & C are awesome");
		}
			else
				System.out.println("D is awesome");

		a = 5;
		b = 6;
		c = 5;
		// && AND
		// || OR
		// WORK FROM LEFT TO RIGHT
		if (a==b && b==c)
			System.out.println("They're all equal");
		else if (a==b || b==c || a==c)
			System.out.println("At least one pair is equal");
		else
			System.out.println("None of them are equal");


	}
}