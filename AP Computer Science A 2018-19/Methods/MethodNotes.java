public class MethodsNotes {

	public static void printName() {
	//void methods print nothing, no parameter
	//static methods run static methods
		System.out.println("Melvin");
	}

	public static void showSum (int i, int j) {
		int sum = i + j;
		System.out.println(sum);
	}

	public static int addNumbers (int i, int j) {
		int sum = i + j;
		return sum;
	}

	public static int[] fillArray(int i, int j, int melvin) {
		int [] arr = {i, j, melvin};
		return arr;
	}

	public static boolean isEven(int i) {
		return i % 2 == 0;
	}

	public static boolean isEven(int i, int j) {
		//must have different parameters
		return ((i % 2 == 0) && (j % 2 == 0));
	}

	public static void main (String[]args) {
		printName();
		showSum(5,7);

		int sum = addNumbers(5,5);
		System.out.println(sum);

		int [] arr = fillArray(1, 2, 3);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		System.out.println(isEven(4));
	}

}