import java.util.Scanner;
public class IfElseReviewI {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);

		System.out.println("Please enter five numbers: ");
		double num1 = reader.nextInt();
		double num2 = reader.nextInt();
		double num3 = reader.nextInt();
		double num4 = reader.nextInt();
		double num5 = reader.nextInt();
		System.out.println("\nThe mean of the five numbers is " + meancalc(num1, num2, num3, num4, num5) + ".\n");

	}
	public static double meancalc(double a, double b, double c, double d, double e){
		double mean = ((a + b + c + d + e) / (double) 5);
		return mean;

	}
}