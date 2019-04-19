public class BinarySearch {

	public static void main (String [] args) {
		int[] arr = {0, 2, 5, 8, 11, 43, 87, 94};

		System.out.print("Test Array: ");

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		System.out.println();

		System.out.println("Binary Search for 87: " + binarySearch(arr, 87) + "\n");
	}

	public static int binarySearch (int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key)
				lo = mid + 1;
			else
				hi = mid - 1;
		}

		return -1;
	}
}