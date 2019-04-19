public class BinarySearchPracticeIII {
	public static void main (String[]args) {

		int rcounter = 0;
		int bcounter = 0;
		for (int m = 0; m < 100; m++) {
			int[] arr = new int[1000];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int)((Math.random()*10000)+1);
			}
			for(int i = 1; i < arr.length; i++){
				int j = i;
				while(j > 0 && arr[j] < arr[j-1]){
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					j--;
				}
			}

			int lo = 0;
			int hi = arr.length-1;
			int key = (int)((Math.random()*10000)+1);
			boolean yes = false;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == key) {
					yes = true;
					rcounter++;
					break;
				}
				else {
					rcounter++;
				}
			}

			while(lo <= hi){
				int mid = (lo + hi)/2;
				if(arr[mid] == key){
					yes = true;
					bcounter++;
					break;
				}
				else if(arr[mid] < key){
					lo = mid + 1;
					bcounter++;
				}
				else if(arr[mid] > key){
					hi = mid - 1;
					bcounter++;
				}
			}
		}
		System.out.println("The average number of regular searches before finding the computer-generated value was " + (double)(rcounter)/100.0 + " times.\nThe average number of binary searches before finding the computer-generated value was " + (double)(bcounter)/100.0 + " times.\n");

	}
}