public class TwoDArray2PracticeI {
	public static void main (String[]args) {

//Program I
		int[][] array1 = new int [4][6];
		int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int row = 0; row < array1.length; row++) {
			for (int col = 0; col < array1[row].length; col++) {
				array1[row][col] = (int)((Math.random()*71)+7);
				sum += array1[row][col];
				if (array1[row][col] < min) {
					min = array1[row][col];
				}
				if (array1[row][col] > max) {
					max = array1[row][col];
				}
				System.out.print(array1[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println("Sum: " + sum + "\nMaximum: " + max + "\tMinimum: " + min + "\n");

//Program II
		int[][] array2 = new int [5][4];
		int a = 2, b = 3, c = 1, d = 5;
		for (int row = 0; row < array2.length; row++) {
			a *= 2;
			b *= 3;
			c *= 4;
			d *= 5;
			for (int col = 0; col < array2[row].length; col++) {
				if (col == 0)
					array2[row][col] = a;
				else if (col == 1)
					array2[row][col] = b;
				else if (col == 2)
					array2[row][col] = c;
				else if (col == 3)
					array2[row][col] = d;
				System.out.print(array2[row][col] + "\t");
			}
			System.out.println();
		}
		System.out.println();

//Program III
		String[][] array3 = new String [3][3];
		String e = "*", f = "**", g = "***";
		int asterisk = 0;
		for (int row = 0; row < array3.length; row++) {
			for (int col = 0; col < array3[row].length; col++) {
				if (row == 0) {
					array3[row][col] = e;
					asterisk++;
				}
				else if (row == 1) {
					array3[row][col] = f;
					asterisk+=2;
				}
				else if (row == 2) {
					array3[row][col] = g;
					asterisk+=3;
				}
				System.out.print(array3[row][col] + "\t");
			}
			System.out.println();
		}
		System.out.println("Asterisks: " + asterisk + "\n");
	}
}