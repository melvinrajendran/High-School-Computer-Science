import java.util.Scanner;
public class NestedIfI {
	public static void main(String[]args) {

		Scanner reader = new Scanner (System.in);

		System.out.print("Please enter the top left angle of the quadrilateral: ");
		int ang1 = reader.nextInt();
		System.out.print("Please enter the top right angle of the quadrilateral: ");
		int ang2 = reader.nextInt();
		System.out.print("Please enter the bottom right angle of the quadrilateral: ");
		int ang3 = reader.nextInt();
		System.out.print("Please enter the bottom left angle of the quadrilateral: ");
		int ang4 = reader.nextInt();
		System.out.println();

		if (ang1 + ang2 + ang3 + ang4 != 360)
			System.out.println("This figure is not a quadrilateral.");
		else {
			if ((ang1 == ang2) && (ang2 == ang3) && (ang3 == ang4))
				System.out.println("The quadrilateral is a rectangle.");
			else {
				if ((ang1 == ang3) && (ang2 == ang4))
					System.out.println("The quadrilateral is a parallelogram.");
				else if ((ang1 != ang2) && (ang2 != ang3) && (ang3 != ang4))
					System.out.println("The quadrilateral has no special qualities.");
			}
		}
	}
}
