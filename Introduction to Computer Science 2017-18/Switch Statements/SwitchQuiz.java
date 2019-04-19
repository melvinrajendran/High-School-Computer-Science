import java.util.Scanner;
public class SwitchQuiz {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner number = new Scanner (System.in);

		System.out.println("Welcome to Super Good Time Adventure World Theme Park!\n");
		System.out.println("Entrance Cost:\nMonday: $5.00\nTuesday: $4.00\nWednesday: $3.00\nAll other days: $2.00\n");
		System.out.println("Food Cost:\nHot Dog: $2.00\nFries: $3.00\nApple Pie: $5.00\nIce Cream (only with Apple Pie): $1.00\n");

		double price = 0;
		System.out.print("What day would you like to visit the park? ");
		String day = reader.nextLine();

		switch (day) {
			case "Monday": price += 5;
				break;

			case "Tuesday": price += 4;
				break;

			case "Wednesday": price += 3;
				break;

			default: price += 2;
				break;
		}

		System.out.print("What would you like to eat? ");
		String food = reader.nextLine();

		switch (food) {
			case "Hot Dog": price += 2;
				break;

			case "Fries": price += 3;
				break;

			case "Apple Pie": price += 5;
				break;
		}

		if (food.equals("Apple Pie")) {
			System.out.print("Would you like ice cream? ");
			String icecream = reader.nextLine();
			if (icecream.equalsIgnoreCase("Yes")) {
				price += 1;
				System.out.println("You visited the park on " + day + " and ordered " + food + " with Ice Cream.  The total cost of the trip is $" + price + ".\n");
			}
			else if (icecream.equalsIgnoreCase("No"))
				System.out.println("You visited the park on " + day + " and ordered " + food + " without Ice Cream.  The total cost of the trip is $" + price + ".\n");
		}
		else
			System.out.println("You visited the park on " + day + " and ordered " + food + ".  The total cost of the trip is $" + price + ".\n");

	}
}