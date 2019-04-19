import java.util.Scanner;
public class IfElseReviewIII {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);

		System.out.print("Would you like (F)rench Fries or (I)ce Cream? ");
		String food = reader.nextLine();
		System.out.print("Would you like (S)oda or (L)emonade? ");
		String drink = reader.nextLine();

		System.out.println("\nYour order is 1 " + foodname(food) + " and 1 " + drinkname(drink) + ".  The price is $" + price(food, drink) + ".\n");

	}
	public static String foodname (String a) {
		String name1 = " ";
		if (a.equals("F"))
			name1 = "French Fry";
		else if (a.equals("I"))
			name1 = "Ice Cream";
		return name1;
	}
	public static String drinkname (String b) {
		String name2 = " ";
		if (b.equals("S"))
			name2 = "Soda";
		else if (b.equals("L"))
			name2 = "Lemonade";
		return name2;
	}
	public static double price (String a, String b) {
		double price = 0;

		if (a.equals("F"))
			price += 5.00;
		else if (a.equals("I"))
			price += 3.75;
		if (b.equals("S"))
			price += 2.25;
		else if (b.equals("L"))
			price += 3.50;

		price *= 1.07;

		double pricef = (double)(Math.round(price*100))/100;
		return pricef;

	}
}