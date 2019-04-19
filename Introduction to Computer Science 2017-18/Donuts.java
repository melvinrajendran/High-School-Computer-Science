public class Donuts {
	public static void main (String[]args) {

		int sizea = 100;
		int sizeb = 63;
		int sizec = 11;

		int dozena = (sizea / 12);
		int dozenb = (sizeb / 12);
		int dozenc = (sizec / 12);

		int remaininga = (sizea % 12);
		int remainingb = (sizeb % 12);
		int remainingc = (sizec % 12);

		System.out.println(sizea + " donuts\n");
		System.out.println(dozena + " dozen\n");
		System.out.println(remaininga + " left over\n\n");
		System.out.println(sizeb + " donuts\n");
		System.out.println(dozenb + " dozen\n");
		System.out.println(remainingb + " left over\n\n");
		System.out.println(sizec + " donuts\n");
		System.out.println(dozenc + " dozen\n");
		System.out.println(remainingc + " left over\n\n");

}
}