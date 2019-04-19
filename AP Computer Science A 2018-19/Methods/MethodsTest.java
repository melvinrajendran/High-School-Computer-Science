public class MethodsTest {

	public static int rand() {
		int num = (int)(Math.random()*10)+1;
		return num;
	}

	public static boolean isEven(int num) {
		return num % 2 == 0;
	}

	public static boolean isArrayEven(int num[]) {
		boolean even = true;
		for (int i = 0; i < num.length; i++) {
			if (isEven(num[i]) == false) {
				even = false;
				break;
			}
		}
		return even;
	}

	public static boolean isMoreThanHalfEven(int num[]) {
		boolean halfEven = false;
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			if (isEven(num[i]) == true)
				count++;
		}
		if (count > num.length/2)
			halfEven = true;
		return halfEven;

	}

	public static int[] makeArray() {
		int arrayLength = 0;
		while (arrayLength != 3 && arrayLength != 6)
			arrayLength = rand();
		int[] arr = new int [arrayLength];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand();
		}
		return arr;
	}

	public static void outputArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Num " + (i + 1) + ": " + arr[i]);
		}
	}

	public static void main (String[]args) {
		int [] test = makeArray();

		outputArray(test);

		System.out.println("Are all of the values even "+isArrayEven(test));

		System.out.println("Are more than half of the items even "+isMoreThanHalfEven(test) + "\n");

		int [] test2 = {2,2,2};

		outputArray(test2);

		System.out.println("Are all of the values even "+isArrayEven(test2));

		System.out.println("Are more than half of the items even "+isMoreThanHalfEven(test2) + "\n");

		int [] test3 = {1,2,3,4,5,6};

		outputArray(test3);

		System.out.println("Are all of the values even "+isArrayEven(test3));

		System.out.println("Are more than half of the items even "+isMoreThanHalfEven(test3) + "\n");

		int [] test4 = {1,2,2,4,5,6};

		outputArray(test4);

		System.out.println("Are all of the values even "+isArrayEven(test4));

		System.out.println("Are more than half of the items even "+isMoreThanHalfEven(test4) + "\n");
	}

}