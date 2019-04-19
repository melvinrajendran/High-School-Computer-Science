import java.util.Scanner;
public class SwitchReviewI {
//Conversion Program
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner number = new Scanner (System.in);

		System.out.println("Available conversion units:\n\t- Millimeters\n\t- Centimeters\n\t- Meters\n\t- Kilometers\n\t- Inches\n\t- Feet\n\t- Yards\n\t- Miles\n");
		System.out.print("Please enter what units you are starting with: ");
		String unito = reader.nextLine();
		System.out.print("\nPlease enter what units you would like to convert into: ");
		String unitf = reader.nextLine();
		System.out.print("\nPlease enter how many " + unito + ": ");
		int quantityo = number.nextInt();
		double quantityf = 0;

		switch (unito) {
			case "Millimeters": quantityf = quantityo * 0.001;
							break;

			case "Centimeters": quantityf = quantityo * 0.01;
							break;

			case "Meters": quantityf = quantityo;
							break;

			case "Kilometers": quantityf = quantityo * 1000;
							break;

			case "Inches": quantityf = quantityo * 0.0254;
							break;

			case "Feet": quantityf = quantityo * 0.3048;
							break;

			case "Yards": quantityf = quantityo * 0.9144;
							break;

			case "Miles": quantityf = quantityo * 1609.34;
							break;

		}

		switch (unitf) {
			case "Millimeters": System.out.println("\n" + quantityo + " " + unito + " is equal to " + (quantityf * 1000) + " " + unitf + ".\n");
							break;

			case "Centimeters": System.out.println("\n" + quantityo + " " + unito + " is equal to " + (quantityf * 100) + " " + unitf + ".\n");
							break;

			case "Meters": System.out.println("\n" + quantityo + " " + unito + " is equal to " + (quantityf) + " " + unitf + ".\n");
							break;

			case "Kilometers": System.out.println("\n" + quantityo + " " + unito + " is equal to " + (quantityf * 0.001) + " " + unitf + ".\n");
							break;

			case "Inches": System.out.println("\n" + quantityo + " " + unito + " is equal to " + (quantityf * 39.3701) + " " + unitf + ".\n");
							break;

			case "Feet": System.out.println("\n" + quantityo + " " + unito + " is equal to " + (quantityf * 3.28084) + " " + unitf + ".\n");
							break;

			case "Yards": System.out.println("\n" + quantityo + " " + unito + " is equal to " + (quantityf * 1.09361) + " " + unitf + ".\n");
							break;

			case "Miles": System.out.println("\n" + quantityo + " " + unito + " is equal to " + (quantityf * 0.000621371) + " " + unitf + ".\n");
							break;

		}

	}
}