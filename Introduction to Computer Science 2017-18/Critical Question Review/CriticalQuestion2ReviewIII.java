public class CriticalQuestion2ReviewIII {
	public static void main (String[]args) {

		String a = "First", b = "Second";
		String temp = " ";
		System.out.println(a + " " + b);

		temp = a;
		a = b;
		b = temp;
		System.out.println(a + " " + b + "\n");

	}
}