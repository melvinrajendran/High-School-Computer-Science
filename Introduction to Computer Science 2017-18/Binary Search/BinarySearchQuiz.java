import java.util.Scanner;
public class BinarySearchQuiz {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner number = new Scanner (System.in);

		int game = 1;
		int score = 0;

		while (game > 0) {
			System.out.print("Please enter the number of integers to be generated in the array (1 - 25000): ");
			int n = number.nextInt();

			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int)((Math.random()*25000)+1);
			} //array has length equal to user input

			System.out.print("\nPlease guess a value in the array: ");
			int key = number.nextInt();

			System.out.println();
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("\n");

			for (int i = 1; i < arr.length; i++) {
				int j = i;
				while (j > 0 && arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					j--;
				} //sorts the array using insertion sort
			}

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("\n");

			int lo = 0;
			int hi = arr.length - 1;
			int mid2 = 0;
			boolean yes = true; //variable for usage in binary sort are established

			while (lo <= hi) {
				int mid = (lo + hi)/2;
				if (arr[mid] == key) {
					yes = false;
					score++;
					break; //if the arr[mid] = key, the element has been found and the loop may be broken

				}
				else if (arr[mid] < key) {
					lo = mid + 1;
				}
				else if (arr[mid] > key) {
					hi = mid - 1; //in other cases, either the lo or hi is adjusted to lessen the portion of the array being searched
				}
				mid2 = mid;
			}

			if (yes = true) {
				System.out.println("You lose.  Your guessed number " + key + " is not in the array.  Your score is " + score + ".");
			}
			else {
				System.out.println("You win!  Your guessed number " + key + " is in the array at index " + mid2 + "!  Your score is " + score + ".");
			} //outputs of winning or losing if the binary search is able to find the key value

			System.out.print("\nWould you like to play again ([Y]es or [N]o)?: ");
			String replay = reader.nextLine();
			if (replay.equalsIgnoreCase("Y")) {
				System.out.println();
			}
			else if (replay.equalsIgnoreCase("N")) {
				System.out.println();
				game--; //user input for whether or not he/she would like to play again either repeats the loop or breaks it
			}
		}
	}
}