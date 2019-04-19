public class ArraysTest {
	public static void main (String[]args) {

		int[] arr = new int [10];

		for (int i = 0; i < arr.length; i++)
			arr[i] = (int)(Math.random()*10)+1;

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("\n");

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0 && i != 0) {
				int temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
			}
		}

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("\n");

		int[][] arr2 = new int [4][4];

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = (i + 1)*(j + 1);
					System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				if (i % 2 == 1 && j < 2) {
					int temp = arr2[i][j];
					arr2[i][j] = arr2[i][arr2.length - 1 - j];
					arr2[i][arr2.length - 1 - j] = temp;
				}
			}
		}

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();


	}
}