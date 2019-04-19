public class ArraysII {
	public static void main (String[]args) {

//1
		int[][] arr = new int[12][30];

		int people = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int month = (int)(Math.random()*12), day = (int)(Math.random()*30);
				while (arr[month][day] < 3) {
					arr[month][day]++;
					people++;
				}
			}
		}
		System.out.println(people + " people were selected before three had the same birthday.\n");

//2
		int[][] arr2 = new int[2][2];
		int x = 0;
		int[] count = new int [2];

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				while(true) {
					x = (int)(Math.random()*2);
					if (count[x] < 2) {
						count[x]++;
						break;
					}
				}
				arr2[i][j] = x + 1;
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		int[][] arr3 = new int[4][4];
		x = 0;
		count = new int [2];

		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				while(true) {
					x = (int)(Math.random()*2);
					if (count[x] < 8) {
						count[x]++;
						break;
					}
				}
				arr3[i][j] = x + 1;
				System.out.print(arr3[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		int[][] arr4 = new int[6][6];
		x = 0;
		count = new int[18];

		for (int i = 0; i < arr4.length; i++) {
			for (int j = 0; j < arr4[i].length; j++) {
				while(true) {
					x = (int)(Math.random()*18);
					if (count[x] < 2) {
						count[x]++;
						break;
					}
				}
				arr4[i][j] = x + 1;
				System.out.print(arr4[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

		int[][] arr5 = new int[6][6];
		x = 0;
		count = new int[9];

		for (int i = 0; i < arr5.length; i++) {
			for (int j = 0; j < arr5[i].length; j++) {
				while(true) {
					x = (int)(Math.random()*9);
					if (count[x] < 4) {
						count[x]++;
						break;
					}
				}
				arr5[i][j] = x + 1;
				System.out.print(arr5[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

	}
}