public class APQuiz {

	public static void main (String [] args) {
		int[][] arr = new int [create2Darray().length][create2Darray()[0].length];
		arr = create2Darray();

		for (int[] row : arr) {
			for (int value : row) {
				System.out.print(value + "\t");
			}
			System.out.println();
		}
		System.out.println();

		int sum = sum1D(arr[0]);
		System.out.println(sum);

		sum = sum2D(arr);
		System.out.println(sum);
	}

	//Task 1
	public static int[][] create2Darray () {
		int[][] returnArray = new int[3][5];

		int val = 10;

		for (int i = 0; i < returnArray.length; i++) {
			for (int j = 0; j < returnArray[0].length; j++) {
				returnArray[i][j] = val;
				val += 10;
			}
		}

		return returnArray;
	}

	//Task 2
	public static int sum1D (int[] arr) {
		int sum = 0;

		for (int val : arr)
			sum += val;

		return sum;
	}

	//Task 3
	public static int sum2D (int[][] arr) {
		int sum = 0;

		for (int[] row : arr)
			sum += sum1D(row);

		return sum;
	}

	//Task 4
	/*public static int[][] create2Darray () {
		int[][] returnArray = new int[4][5];

		int val = 10;

		for (int i = 0; i < returnArray.length; i++) {
			for (int j = 0; j < returnArray[0].length; j++) {
				returnArray[i][j] = val;
				val += 10;
			}
		}

		return returnArray;
	}*/

}