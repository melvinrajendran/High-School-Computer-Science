public class NestedLoopsProgram {
	public static void main (String[]args) {

//Part 1A
		for (int i = 1; i <= 1000; i++) {
			int prime = 1;
			for (int j = 2; j <= (i - 1); j++) {
				if (i % j == 0) {
					prime = 0;
					break;
				}
			}
			if (prime == 1) {
				System.out.println(i);
			}
		}
	}
}
//Part 1B
/*The program's algorithm functions through the usage of a for loop and nested for loop.  The outer loop runs for all values of integer i from 1 to 1000, and
the loop's code determines whether or not i is a prime number, and outputs i if it is prime.  Since we know that all integers are divisible by 1 and
themselves, the inner loop defines integer j as all values from 2 to (i - 1), which checks whether or not i is divisible by any numbers besides 1 and itself,
making it not a prime number.  Furthermore, an integer prime is defined inside the outer loop to hold a value of 1, and changes to 0 if the integer i is
divisible by j.  If this condition is not met, i is a prime number and is printed.*/
