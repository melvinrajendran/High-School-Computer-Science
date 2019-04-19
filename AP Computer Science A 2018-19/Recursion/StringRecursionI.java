public class StringRecursionI {

	public static void main (String [] args) {
		System.out.println("returnNums: " + returnNums("n123m"));
		System.out.println("recursiveReturnNums: " + recursiveReturnNums("n123m") + "\n");
	}

	/**
	 * The following method uses a for-loop to return the sum of all numerical
	 * characters within the String inputted into it.
	 */
	public static int returnNums (String str) {
		int nums = 0;

		for (int i = 0; i < str.length(); i++) {
			if ((int)str.charAt(i) >= 48 && (int)str.charAt(i) <= 57)
				nums += Integer.parseInt(Character.toString(str.charAt(i)));
		}

		return nums;
	}

	/**
	 * The following method uses String recursion to return the sum of all numerical
	 * characters within the String inputted into it.  It uses String recursion to do so.
	 */
	public static int recursiveReturnNums (String str) {
		if (str.length() == 0)
			return 0;

		if ((int)str.charAt(0) >= 48 && (int)str.charAt(0) <= 57)
			return Integer.parseInt(Character.toString(str.charAt(0))) + recursiveReturnNums(str.substring(1));

		return recursiveReturnNums(str.substring(1));
	}
}