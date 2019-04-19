public class IntegerDoubleOperationsPTIINotes {
	public static void main (String[]args) {

		int counter = 0;

		counter = counter + 1;
//adds 1 to original int
		System.out.println(counter);

		counter++;
//adds 1 to original int
		System.out.println(counter);

		counter += 11;
//adds any number to orginal int
		System.out.println(counter);

		counter -= 11;
		counter *= 5;
		counter /= 2;
		counter %= 8;
//shortcut is usable with all mathematical operations
		System.out.println(counter);

}
}