import java.util.Scanner;
public class ArrayPracticeI {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);

//Practice I
		int[] array1 = new int[6];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = (int)(Math.random()*20)+1;
			System.out.print(array1[i] + " ");
		}
		System.out.println("\n");

//Practice II
		String output = "";
		String[] array2 = new String[6];
		for (int i = 0; i < array2.length; i++) {
			System.out.print("Name " + (i + 1) + ": ");
			array2[i] = reader.nextLine();
			output += array2[i] + " ";
		}
		System.out.println("\n" + output + "\n");

//Practice III
		int[] array3 = new int[5];
		int sum = 0;
		int small = 101;
		int large = 0;
		for (int i = 0; i < array3.length; i++) {
			array3[i] = (int)(Math.random()*100)+1;
			sum += array3[i];
			if (array3[i] > large) {
				large = array3[i];
			}
			if (array3[i] < small) {
				small = array3[i];
			}
		}
		System.out.println("Sum of the values: " + sum + "\nSmallest Value: " + small + "\nLargest Value: " + large + "\n");
	}
}