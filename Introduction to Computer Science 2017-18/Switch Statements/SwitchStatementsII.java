import java.util.Scanner;
public class SwitchStatementsII {
	public static void main (String[]args) {

	Scanner reader = new Scanner (System.in);
	Scanner number = new Scanner (System.in);

	System.out.println("Please enter three numbers: ");
	int num1 = number.nextInt();
	int num2 = number.nextInt();
	int num3 = number.nextInt();
	System.out.print("\nWould you like to find the (S)um, (A)verage, (P)roduct, or (D)ifference? ");
		String choice = reader.nextLine();

		switch (choice) {
			case "S": System.out.println("\nSum: " + (num1 + num2 + num3) + "\n");
				break;

			case "A": System.out.println("\nAverage: " + ((num1 + num2 + num3)/3.0) + "\n");
				break;

			case "P": if ((num1 > num2) && (num1 > num3) && (num2 > num3))
						System.out.println("\nProduct: " + (num1 * num3) + "\n");
					else if ((num1 > num2) && (num1 > num3) && (num2 < num3))
						System.out.println("\nProduct: " + (num1 * num2) + "\n");
					else if ((num2 > num1) && (num2 > num3) && (num1 > num3))
						System.out.println("\nProduct: " + (num2 * num3) + "\n");
					else if ((num2 > num1) && (num2 > num3) && (num1 < num3))
						System.out.println("\nProduct: " + (num2 * num1) + "\n");
					else if ((num3 > num1) && (num3 > num2) && (num1 > num2))
						System.out.println("\nProduct: " + (num3 * num2) + "\n");
					else if ((num3 > num1) && (num3 > num2) && (num1 < num2))
						System.out.println("\nProduct: " + (num3 * num1) + "\n");
				break;

			case "D": if ((num1 > num2) && (num1 > num3) && (num2 > num3))
						System.out.println("\nDifference: " + (num1 - num3) + "\n");
					else if ((num1 > num2) && (num1 > num3) && (num2 < num3))
						System.out.println("\nDifference: " + (num1 - num2) + "\n");
					else if ((num2 > num1) && (num2 > num3) && (num1 > num3))
						System.out.println("\nDifference: " + (num2 - num3) + "\n");
					else if ((num2 > num1) && (num2 > num3) && (num1 < num3))
						System.out.println("\nDifference: " + (num2 - num1) + "\n");
					else if ((num3 > num1) && (num3 > num2) && (num1 > num2))
						System.out.println("\nDifference: " + (num3 - num2) + "\n");
					else if ((num3 > num1) && (num3 > num2) && (num1 < num2))
						System.out.println("\nDifference: " + (num3 - num1) + "\n");
				break;

		}
	}
}