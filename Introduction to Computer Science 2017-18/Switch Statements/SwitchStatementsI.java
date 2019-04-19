import java.util.Scanner;
public class SwitchStatementsI {
	public static void main (String[]args) {

	Scanner reader = new Scanner (System.in);
	Scanner number = new Scanner (System.in);

	System.out.print("What is your current weight in pounds? ");
	int weight = number.nextInt();
	System.out.println("\nEarth\nJupiter\nMars\nMercury\nNeptune\nPluto\nSaturn\nUranus\nVenus\n");
	System.out.print("Choose a planet to travel to (capitalize first letter): ");
		String planet = reader.nextLine();

		switch (planet) {
			case "Earth": System.out.println("\nYour weight on Earth is " + weight + " pounds.\nYour weight on Earth would be " + (weight * 1.00) + " pounds.\n");
				break;

			case "Jupiter": System.out.println("\nYour weight on Earth is " + weight + " pounds.\nYour weight on Jupiter would be " + (weight * 2.65) + " pounds.\n");
				break;

			case "Mars": System.out.println("\nYour weight on Earth is " + weight + " pounds.\nYour weight on Mars would be " + (weight * 0.39) + " pounds.\n");
				break;

			case "Mercury": System.out.println("\nYour weight on Earth is " + weight + " pounds.\nYour weight on Mercury would be " + (weight * 0.38) + " pounds.\n");
				break;

			case "Neptune": System.out.println("\nYour weight on Earth is " + weight + " pounds.\nYour weight on Neptune would be " + (weight * 1.23) + " pounds.\n");
				break;

			case "Pluto": System.out.println("\nYour weight on Earth is " + weight + " pounds.\nYour weight on Pluto would be " + (weight * 0.05) + " pounds.\n");
				break;

			case "Saturn": System.out.println("\nYour weight on Earth is " + weight + " pounds.\nYour weight on Earth would be " + (weight * 1.17) + " pounds.\n");
				break;

			case "Uranus": System.out.println("\nYour weight on Earth is " + weight + " pounds.\nYour weight on Earth would be " + (weight * 1.05) + " pounds.\n");
				break;

			case "Venus": System.out.println("\nYour weight on Earth is " + weight + " pounds.\nYour weight on Earth would be " + (weight * 0.78) + " pounds.\n");
				break;

		}
	}
}