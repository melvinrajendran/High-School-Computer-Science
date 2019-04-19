public class RecursionI {

	public static void main (String [] args) {
		System.out.println(halfSum(10) + "\n");
		System.out.println(productOfAllDigits(456) + "\n");
		System.out.println(sumPlusMinus(12345) + "\n");
		hailstone(27);
	}

	public static int halfSum(int x) {
		if (x == 1)
			return 1;
		return x+halfSum(x/2);
	}

	public static int productOfAllDigits(int x) {
		if (x % 10 == x)
			return x;
		return (x % 10) * productOfAllDigits(x / 10);
	}

	public static int sumPlusMinus (int x) { //might not work
		if (x % 10 == x)
			return x;
		else if ((x % 10) % 2 == 0)
			return (x % 10) - sumPlusMinus(x/10);
		else
			return (x % 10) + sumPlusMinus(x/10);

	}

	public static void hailstone(int num) { //must have if, else if, and else since then only one statement will run
		if (num == 0 || num == 1) {
			System.out.println(num + "\n");
		}
		else if (num % 2 == 0) {
			System.out.print(num + " ");
			hailstone(num/2);
		}
		else {
			System.out.print(num + " ");
			hailstone(num*3+1);
		}
	}


}