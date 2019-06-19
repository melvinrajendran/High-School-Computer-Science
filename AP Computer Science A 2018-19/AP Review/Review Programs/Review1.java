public class Review1 {

	public static void main (String [] args) {
		int [][] arr2D = new int[10][10];

		for (int row = 0; row < arr2D.length; row++)
			for (int col = 0; col < arr2D[row].length; col++)
				arr2D[row][col] = row * col;

		//Method 1
		for (int row = 0; row < arr2D.length; row++) {
			for (int col = 0; col < arr2D[row].length; col++)
				System.out.print(arr2D[row][col] + "\t");
			System.out.println();
		}

		System.out.println();

		//Method 2
		int r = 0, c = 0;

		while (r < arr2D.length && c < arr2D[0].length) {
			System.out.print(arr2D[r][c] + "\t");

			c++;

			if (c == arr2D[r].length) {
				r++;
				c = 0;

				System.out.println();
			}
		}

		System.out.println();

		//Method 3
		for (int[] row : arr2D) {
			for (int i : row)
				System.out.print(i + "\t");
			System.out.println();
		}
	}
}