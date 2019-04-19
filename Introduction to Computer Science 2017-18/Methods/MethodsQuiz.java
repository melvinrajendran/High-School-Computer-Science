import java.util.Scanner;
public class MethodsQuiz {
	public static void main (String[]args) {
	Scanner reader = new Scanner(System.in);

	System.out.print("Please enter the length of your rectangle: ");
	int rectanglelength = reader.nextInt();
	System.out.print("Please enter the width of your rectangle: ");
	int rectanglewidth = reader.nextInt();
	System.out.print("The perimeter of your rectangle is " + perimeter(rectanglelength, rectanglewidth) + " units.\n");
	System.out.println("");
	System.out.print("Please enter the first base of your trapezoid: ");
	double trapezoidbase1 = reader.nextDouble();
	System.out.print("Please enter the second base of your trapezoid: ");
	double trapezoidbase2 = reader.nextDouble();
	System.out.print("Please enter the height of your trapezoid: ");
	double trapezoidheight = reader.nextDouble();
	System.out.print("The area of your trapezoid is " + area(trapezoidbase1, trapezoidbase2, trapezoidheight) + " square units.\n");
	System.out.println("");


	}
	public static int perimeter (int a, int b) {

	int rectperim = 2 * a + 2 * b;
	return rectperim;

	}
	public static double area (double a, double b, double c) {

	double traparea = ((0.5 * (a + b)) * c);
	return traparea;

	}
}