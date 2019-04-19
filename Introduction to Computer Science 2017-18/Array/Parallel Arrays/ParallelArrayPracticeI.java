import java.util.Scanner;
public class ParallelArrayPracticeI {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner num = new Scanner (System.in);

//Practice I
		/*int[] number = new int[5];
		String[] street = new String[5];
		String[] apt = new String[5];
		int[] zip = new int[5];

		for (int i = 0; i < 5; i++) {
			System.out.print("Please enter the number of the address: ");
			number[i] = num.nextInt();
			System.out.print("Please enter the street of the address: ");
			street[i] = reader.nextLine();
			System.out.print("Please enter the apartment of the address (if inapplicable, enter \"-\"): ");
			apt[i] = reader.nextLine();
			System.out.print("Please enter the zipcode of the address: ");
			zip[i] = num.nextInt();
			System.out.println();
		}

		for (int j = 0; j < 5; j++) {
			if (apt[j].equals("-"))
				System.out.println(number[j] + " " + street[j] + " " + zip[j]);
			else
				System.out.println(number[j] + " " + street[j] + " Apt " + apt[j] + " " + zip[j]);
		}
		System.out.println();*/

//Practice II
		String[] fname = new String[6];
		String[] linitial = new String[6];
		int[] id = new int[6];
		double[] point = new double[6];
		double[] possiblepoint = new double[6];

		for (int i = 0; i < 6; i++) {
			System.out.print("Please enter the first name of the student: ");
			fname[i] = reader.nextLine();
			System.out.print("Please enter the last initial of the student: ");
			linitial[i] = reader.nextLine();
			System.out.print("Please enter the ID number of the student: ");
			id[i] = num.nextInt();
			System.out.print("Please enter the student's earned points: ");
			point[i] = num.nextDouble();
			System.out.print("Please enter the possible points: ");
			possiblepoint[i] = num.nextDouble();
			System.out.println();
		}

		for (int j = 0; j < 6; j++) {
			System.out.println(fname[j] + "\t" + linitial[j] + "\t" + id[j] + "\t" + point[j] + "\t" + possiblepoint[j] + "\t" + ((point[j]/possiblepoint[j]) * 100) + "%");
		}
		System.out.println();
	}
}