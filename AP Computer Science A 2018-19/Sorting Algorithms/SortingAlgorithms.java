public class SortingAlgorithms {

	public static void main (String[] args) {
		int arr[] = {2, 5, 3, 9, 10, 0};

		printArray(arr, arr.length);

		System.out.print("\nSelection Sorted Array: ");
		printArray(SelectionSort(arr), arr.length);

		int arr2[] = {2, 5, 3, 9, 10, 0};

		System.out.print("\nInsertion Sorted Array: ");
		printArray(InsertionSort(arr2), arr2.length);

		System.out.println();
	}

	public static int[] SelectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}

			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			}

		return arr;
	}

	public static int[] InsertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				arr[j] = key;
				j--;
			}
		}

		return arr;
	}

	public static void printArray(int[] arr, int index) {
		for (int i = 0; i < index; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

}