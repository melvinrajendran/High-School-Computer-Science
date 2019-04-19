public class ArraysIII {
	public static void main (String[]args) {

//1
		int[] arr = new int [10];

	//a
		int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		double avg = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*21)+5;
			sum += arr[i];
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
			System.out.print(arr[i] + " ");
		}

		avg = (double)sum/arr.length;

		System.out.println("\n\nSum: " + sum + "\nAverage: " + avg + "\nMaximum: " + max + "\nMinimum: " + min + "\n");

	//b
		int temp = 0;
		for (int i = 0; i < arr.length/2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("\n");

//2
		int[][] arr2 = {{1,2,3,4,5,6,7},
						{8,9,10,11,12,13,14},
						{15,16,17,18,19,20,21},
						{22,23,24,25,26,27,28},
						{29,30,31,32,33,34,35}};

	//a,b
		int sumc2 = 0, sumr3 = 0;
		double avgc2 = 0, avgr3 = 0;

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0 ; j < arr2[i].length; j++) {
				if (j == 2)
					sumc2 += arr2[i][j];
				if (i == 3)
					sumr3 += arr2[i][j];
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}

		avgc2 = (double)sumc2/arr2.length;
		avgr3 = (double)sumr3/arr2[3].length;

		System.out.println("\nAverage of 3rd column: " + avgc2 + "\nAverage of 4th row: " + avgr3 + "\n");

	//c
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				if (j == 1) {
					temp = arr2[i][j];
					arr2[i][j] = arr2[i][5];
					arr2[i][5] = temp;
				}
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

	//d
		temp = arr2[0][6];
		arr2[0][6] = arr2[4][6];
		arr2[4][6] = temp;

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();


	}
}