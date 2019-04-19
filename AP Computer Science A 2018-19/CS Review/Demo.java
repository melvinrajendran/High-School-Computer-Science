import java.util.Scanner;
public class Demo {
	public static void main (String[]args) {

		Scanner number = new Scanner (System.in);

		/*int myVar = 0;
		for (int i = 0; i < 10; i++)
			System.out.println("value of i " + i);*/

//1
		int sum = 0;
		int values = 0;
		for (int i = 1; i <= 101; i++) {
			if (i % 2 == 0) {
				values++;
				sum += i;
			}
		}
		System.out.println((double)sum/values + "\n");

		sum = 0;
		values = 0;
		for (int i = 2; i <= 100; i += 2) {
			values++;
			sum += i;
		}
		System.out.println((double)sum/values + "\n");

//2
		for (int i = 5; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

//3
		for (int i = 1; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print(j);
			}
			if (i % 2 == 1)
				System.out.println("*");
			else
				System.out.println();
		}
		System.out.println();

//4a
		System.out.print("Please enter the number of bagels: ");
		int numBagels = number.nextInt();
		int gross = 0, dozen = 0, excess = 0;
		gross = numBagels/144;
		dozen = (numBagels - 144 * gross)/12;
		excess = numBagels - 144 * gross - 12 * dozen;
		System.out.println(numBagels + " bagels are " + gross + " gross, " + dozen + " dozen, and " + excess + " bagels.\n");

//4b
		numBagels = (int)(Math.random()*300)+1;
		gross = 0;
		dozen = 0;
		excess = 0;
		gross = numBagels/144;
		dozen = (numBagels - 144 * gross)/12;
		excess = numBagels - 144 * gross - 12 * dozen;
		System.out.println(numBagels + " bagels are " + gross + " gross, " + dozen + " dozen, and " + excess + " bagels.\n");

//5
		System.out.print("How many dice would you like to roll? ");
		int numDice = number.nextInt();
		int num6 = 0;
		for (int i = 0; i < numDice; i++) {
			int roll = (int)(Math.random()*6)+1;
			if (roll == 6)
				num6++;
		}
		System.out.println("Number of sixes rolled by " + numDice + " dice: " + num6 + "\n");

	}
}