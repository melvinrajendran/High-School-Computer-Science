import java.util.Scanner;
public class SwitchStatementsEC {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner number = new Scanner (System.in);

		System.out.println("Discounts from each department are as follows:");
		System.out.println("\t* Audio (Dept. code 310) are marked 10% off\n\t* Video (Dept. code 438) are marked 12% off\n\t* Communications (Dept. code 652) are marked 15% off\n\t* Other Departments are marked 5% off\n");
		System.out.print("Please enter the regular price of an item: ");
		int price = number.nextInt();
		System.out.print("Please enter the department code of the item: ");
		int department = reader.nextInt();

		switch (department) {

			case 310: System.out.println("\nThe regular price of the item is: $" + price);
					System.out.println("The sale price of the item is: $" + (0.90 * price));
					break;

			case 438: System.out.println("\nThe regular price of the item is: $" + price);
					System.out.println("The sale price of the item is: $" + (.88 * price));
					break;

			case 652: System.out.println("\nThe regular price of the item is: $" + price);
					System.out.println("The sale price of the item is: $" + (0.85 * price));
					break;

			default : System.out.println("\nThe regular price of the item is: $" + price);
					System.out.println("The sale price of the item is: $" + (0.95 * price));
					break;

		}
	}
}