import java.util.Scanner;
public class SelectionSortPracticeI {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner num = new Scanner (System.in);

		char[] characters = {'g', 'r', 'v', 'y', 'j', 'a', 'd', 'm'};
		int[] integers = {5, 2, 7, 8, 1, 3, 9, 6};
		int minindex = 0;

		System.out.print("Would you like to sort (c)haracters or (i)ntegers?: ");
		String variable = reader.nextLine();
		System.out.print("Would you like to sort in (a)scending order or (d)escending order: ");
		String order = reader.nextLine();
		if (variable.equalsIgnoreCase("c")) {
			for (int i = 0; i < characters.length - 1; i++) {
				minindex = i;
				for (int j = i + 1; j < characters.length; j++) {
					if ((order.equalsIgnoreCase("a")) && (characters[j] < characters[minindex])) {
						minindex = j;
					}
					else if ((order.equalsIgnoreCase("d")) && (characters[j] > characters[minindex])) {
						minindex = j;
					}
				}
				char temp = characters[i];
				characters[i] = characters[minindex];
				characters[minindex] = temp;
			}
		}
		else if (variable.equalsIgnoreCase("i")) {
			for (int i = 0; i < integers.length - 1; i++) {
				minindex = i;
				for (int j = i + 1; j < integers.length; j++) {
					if ((order.equalsIgnoreCase("a")) && (integers[j] < integers[minindex])) {
						minindex = j;
					}
					else if ((order.equalsIgnoreCase("d")) && (integers[j] > integers[minindex])) {
						minindex = j;
					}
				}
				int temp = integers[i];
				integers[i] = integers[minindex];
				integers[minindex] = temp;
			}
		}
		System.out.println();
		for (int k = 0; k < 8; k++) {
			if (variable.equalsIgnoreCase("c")) {
				System.out.print(characters[k] + " ");
			}
			else if (variable.equalsIgnoreCase("i")) {
				System.out.print(integers[k] + " ");
			}
		}
		System.out.println("\n");
	}
}