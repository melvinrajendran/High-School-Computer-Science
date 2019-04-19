public class Test {
	public static void main (String[]args) {

//9
		for (int i = 0; i < 5; i++) {
			for (int j = i; j < 5; j++) {
				System.out.print(j);
				if (j % 2 == 0)
					System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();

//10
		for (int i = 1; i < 10; i+=2) {
			for (int j = 0; j < i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();

//11
		int num1 = (int)(Math.random()*10)+1, num2 = (int)(Math.random()*10)+1;
		System.out.println("Integers: " + num1 + ", " + num2 + "\nSum: " + (num1 + num2) + "\nProduct: " + (num1 * num2));
		if (num1 > num2)
			System.out.println("Difference: " + (num1 - num2));
		else
			System.out.println("Difference: " + (num2 - num1));
		System.out.println("Quotient: " + (double)num1/num2 + "\n");
	}
}