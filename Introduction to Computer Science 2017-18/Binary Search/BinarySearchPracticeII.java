public class BinarySearchPracticeII {
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
		int rcounter = 0;
		int bcounter = 0;
		boolean yes = false;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				rcounter++;
				yes = true;
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
				bcounter++;
				lo = mid + 1;
			}
			else if(arr[mid] > key){
				bcounter++;
				hi = mid - 1;
			}
		}

		if(yes == true)
			System.out.println(key + " is in the array.\nThe regular search ran " + rcounter + " times.\nThe binary search ran " + bcounter + " times.\n");
		else
			System.out.println(key + " is NOT in the array.\nThe regular search ran " + rcounter + " times.\nThe binary search ran " + bcounter + " times.\n");

	}
}