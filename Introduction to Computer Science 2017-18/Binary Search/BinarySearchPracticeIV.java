import java.util.Scanner;
public class BinarySearchPracticeIV {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner number = new Scanner (System.in);

		int score = 0;
		int l = 0;
		while (l == 0) {
			System.out.print("Please select a number between 1 and 100: ");
			int key = number.nextInt();

			int[] arr = new int[10];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int)(Math.random()*100+1);
			}
			for (int i = 1; i < arr.length; i++) {
				int j = i;
				while (j > 0 && arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}

			int lo = 0;
			int hi = arr.length-1;
			boolean yes = false;

			while (lo <= hi) {
				int mid = (lo + hi)/2;
				if (arr[mid] == key) {
					yes = true;
					score++;
					break;
				}
				else if (arr[mid] < key) {
					lo = mid + 1;
				}
				else if (arr[mid] > key) {
					hi = mid - 1;
				}
			}
			if (yes == true) {
				System.out.println("Your guessed number was in the array!  Your score is " + score + " point(s).");
			}
			else {
				System.out.println("Your guessed number was not the array.  Your score is " + score + " point(s).");
			}
			System.out.print("\nWould you like to guess again ([Y]es or [N]o)?: ");
			String repeat = reader.nextLine();
			if (repeat.equalsIgnoreCase("N")) {
				l++;
			}
			else if (repeat.equalsIgnoreCase("Y")){
				System.out.println();
			}
		}
		System.out.println();
	}
}