import java.util.Scanner;
public class MethodParametersPractice {
	public static void main (String[]args) {
	Scanner reader = new Scanner(System.in);

	//Practice I
	/*System.out.println("Enter your first name:");
	String firstname = reader.nextLine();
	System.out.println();
	System.out.println("Enter your last name:");
	String lastname = reader.nextLine();
	System.out.println();

	System.out.println("Your full name is: " + namecreator(firstname, lastname));

	}
	public static String namecreator (String a, String b){
		String fullname = (a + " " + b);
		return fullname;

	//Practice II
	System.out.println("Enter the first x-coordinate: ");
	int x1 = reader.nextInt();
	System.out.println("Enter the first y-coordinate: ");
	int y1 = reader.nextInt();
	System.out.println("Enter the second x-coordinate: ");
	int x2 = reader.nextInt();
	System.out.println("Enter the second y-coordinate: ");
	int y2 = reader.nextInt();
	System.out.println();

	System.out.println("The slope of the line is: " + slope(x1, y1, x2, y2));

	}
	public static double slope (int a, int b, int c, int d) {
		double slope = (d-b)/(double)(c-a);
		return slope;

	//Practice III
	System.out.println("Enter the first number: ");
	int num1 = reader.nextInt();
	System.out.println("Enter the second number: ");
	int num2 = reader.nextInt();
	System.out.println("Enter the third number: ");
	int num3 = reader.nextInt();
	System.out.println();

	System.out.println("The average of the three numbers is: " + average(num1, num2, num3) + "\n");

	}
	public static double average (int a, int b, int c) {
		double average = (a + b + c)/3.0;
		return average;*/

	//Practice IV
	System.out.println("Enter the length of the first base of the trapezoid: ");
	int base1 = reader.nextInt();
	System.out.println("Enter the length of the second base of the trapezoid: ");
	int base2 = reader.nextInt();
	System.out.println("Enter the height of the trapezoid: ");
	int height = reader.nextInt();

	System.out.println("The area of the trapezoid is: " + area(base1, base2, height) + "\n");

	}
	public static double area (int a, int b, int c) {
		double area = (.5 * (a + b) * c);
		return area;

}
}