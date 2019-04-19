public class ArraysI {
	public static void main (String[]args) {

//1
		int[] arr = new int[40];

		for (int i = 0; i < 40; i++) {
			arr[i] = (int)(Math.random()*31)+10;
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");


//2
		arr[arr.length-2] = 99;
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("\n");

//3
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0)
				arr[i] -= 2;
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");

//4
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 1)
				arr[i] *= 2;
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");

//5
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 4 == 1)
				arr[i] = 0;
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");

//6
		for (int i = 0; i < arr.length; i++) {
			if (i % 5 == 4)
				arr[i] = 5;
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");

//7
		int alt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1)
				alt++;
			if (arr[i] % 2 == 1 && alt % 2 == 1)
				arr[i] = 1;
			System.out.print(arr[i] + " ");

		}
		System.out.println("\n");

//8
		int [][] arr2 = new int [11][11];

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				if (i == 0)
					arr2[i][j] = j;
				else if (j == 0)
					arr2[i][j] = i;
				else
					arr2[i][j] = arr2[0][j] * arr2[i][0];
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

//9
		int [][] arr3 = new int [4][4];

		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				arr3[i][j] = (int)(Math.random()*16)+1;
				System.out.print(arr3[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}