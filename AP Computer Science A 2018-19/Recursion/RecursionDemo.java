public class RecursionDemo {

	public static int factorial (int i) {
		if (i == 0)
			return 1;
		return i*factorial(i-1);
	}

	public static int sumNumbers (int i) {
		//This method will add the numbers from 1 to i
		if (i == 0)
			return 0;
		return i+sumNumbers(i-1);
	}

	public static int printFactorial (int i) {
		//How program computes factorials
		if (i == 0) {
			System.out.println(1);
			return 1;
		}
		int result = i * printFactorial(i-1);
		System.out.println(result);
		return result;
	}

	public static void main (String[]args) {
		//System.out.println(factorial(5));
		//System.out.println(sumNumbers(10));
		printFactorial(5);
	}
}