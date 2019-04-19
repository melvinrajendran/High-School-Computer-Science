public class TwoDArrayPracticeI {
	public static void main (String[]args) {

//Let's Try 1

		int array1[][] = new int [3][5];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int row = 0; row < array1.length; row++) {
			for (int column = 0; column < array1[row].length; column++) {
				int i = (int)((Math.random()*50)+1);
				sum += i;
				array1[row][column] = i;
				System.out.print(array1[row][column] + "\t");
				if (i > max) {
					max = i;
				}
			}
			System.out.println();
		}
		System.out.println("\nSum: " + sum + "\nMaximum: " + max + "\n");

//Let's Try 2

		int array2[][] = new int [10][10];
		for (int row = 0; row < array2.length; row++) {
			for (int column = 0; column < array2[row].length; column++) {
				array2[row][column] = column;
				System.out.print(array2[row][column] + "\t");
			}
			System.out.println();
		}
		System.out.println("\n");

//Let's Try 2 Mod 1

		int array3[][] = new int [10][10];
		for (int row = 0; row < array3.length; row++) {
			for (int column = 0; column < array3[row].length; column++) {
				array3[row][column] = column + 1;
				System.out.print(array3[row][column] + "\t");
			}
			System.out.println();
		}

	}
}