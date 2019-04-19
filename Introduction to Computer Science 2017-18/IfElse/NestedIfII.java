import java.util.Scanner;
public class NestedIfII {
	public static void main(String[]args) {

		Scanner reader = new Scanner (System.in);

		System.out.print("Would you like to convert (F)orce, (D)istance, or (V)olume between English and metric units? ");
		String choice = reader.nextLine();
		System.out.println();

		if (choice.equalsIgnoreCase("F")){
			System.out.print("Would you like to convert from (P)ounds to Newtons or (N)ewtons to Pounds? ");
			String convorder = reader.nextLine();
			System.out.println();
			if (convorder.equalsIgnoreCase("P"))
				lbtoN(convorder);
			else if (convorder.equalsIgnoreCase("N"))
				Ntolb(convorder);
		}
		else if (choice.equalsIgnoreCase("D")){
			System.out.print("Would you like to convert from (F)eet to Meters or (M)eters to Feet? ");
			String convorder = reader.nextLine();
			System.out.println();
			if (convorder.equalsIgnoreCase("F"))
				fttom(convorder);
			else if (convorder.equalsIgnoreCase("M"))
				mtoft(convorder);
		}
		else if (choice.equalsIgnoreCase("V")){
			System.out.print("Would you like to convert from (G)allons to Liters or (L)iters to Gallons? ");
			String convorder = reader.nextLine();
			System.out.println();
			if (convorder.equalsIgnoreCase("G"))
				galtoL(convorder);
			else if (convorder.equalsIgnoreCase("L"))
				Ltogal(convorder);
		}
	}
	public static void lbtoN (String a) {
		Scanner num1 = new Scanner (System.in);
		System.out.print("Please enter the Force of the object in Pounds: ");
		double lb = num1.nextDouble();
		System.out.println();
		System.out.println("The Force of the object in Newtons is " + 4.9 * lb + " Newtons.");
	}
	public static void Ntolb (String a) {
		Scanner num2 = new Scanner (System.in);
		System.out.print("Please enter the Force of the object in Newtons: ");
		double N = num2.nextDouble();
		System.out.println();
		System.out.println("The Force of the object in Pounds is " + N / 4.9 + " pounds.");
	}
	public static void fttom (String a) {
		Scanner num3 = new Scanner (System.in);
		System.out.print("Please enter the Distance in Feet: ");
		double ft = num3.nextDouble();
		System.out.println();
		System.out.println("The Distance in Meters is " + ft / 3.28 + " meters.");
	}
	public static void mtoft (String a) {
		Scanner num4 = new Scanner (System.in);
		System.out.print("Please enter the Distance in Meters: ");
		double m = num4.nextDouble();
		System.out.println();
		System.out.println("The Distance in Feet is " + 3.28 * m + " feet.");
	}
	public static void galtoL (String a) {
		Scanner num5 = new Scanner (System.in);
		System.out.print("Please enter the Volume in Gallons: ");
		double gal = num5.nextDouble();
		System.out.println();
		System.out.println("The Volume in Liters is " + gal / 3.79 + " liters.");
	}
	public static void Ltogal (String a) {
		Scanner num6 = new Scanner (System.in);
		System.out.print("Please enter the Volume in Liters: ");
		double L = num6.nextDouble();
		System.out.println();
		System.out.println("The Volume in Gallons is " + 3.79 * L + " gallons.");
	}

}