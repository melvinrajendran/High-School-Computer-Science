import java.util.Scanner;
public class IfQuiz {
	public static void main (String[]args) {

	Scanner reader = new Scanner (System.in);

	System.out.println("Welcome to Ye Olde Ice Cream Shoppe!\n");
	System.out.println("Prices are as follows:\nChocolate:\t$2.50\nVanilla:\t$2.00\nSprinkles:\t$1.00\nHot Fudge:\t$1.00\n");

	double price = 0;

	System.out.print("What flavor would you like? ");
	String choice = reader.nextLine();
	if (choice.equalsIgnoreCase("Chocolate"))
		price += 2.50;
	else if (choice.equalsIgnoreCase("Vanilla"))
		price += 2.00;

	System.out.print("Would you like sprinkles? ");
	String sprinkles = reader.nextLine();
	if (sprinkles.equalsIgnoreCase("Yes"))
		price += 1.00;
	else if (sprinkles.equalsIgnoreCase("No"))
		price += 0;

	if ((choice.equalsIgnoreCase("Chocolate")) && (sprinkles.equalsIgnoreCase("Yes"))) {
		System.out.print("Would you like hot fudge? ");
		String hotfudge = reader.nextLine();
		if (hotfudge.equalsIgnoreCase("Yes"))
			price += 1.00;
		else if (hotfudge.equalsIgnoreCase("No"))
			price += 0;
	}
	else
		price += 0;

		System.out.println("\nTotal: $" + price);

	}
}