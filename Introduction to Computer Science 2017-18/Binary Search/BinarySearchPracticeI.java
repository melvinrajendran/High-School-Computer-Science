public class BinarySearchPracticeI {
	public static void main (String[]args) {

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
		int counter = 0;
		boolean yes = false;

		while(lo <= hi){
			int mid = (lo + hi)/2;
			if(arr[mid] == key){
				yes = true;
				counter++;
				break;
			}
			else if(arr[mid] < key){
				counter++;
				lo = mid + 1;
			}
			else if(arr[mid] > key){
				counter++;
				hi = mid - 1;
			}
		}

		if(yes == true)
			System.out.println(key + " is in the array.  The computer searched " + counter + " times.\n");
		else
			System.out.println(key + " is NOT in the array.  The computer searched " + counter + " times.\n");

	}
}