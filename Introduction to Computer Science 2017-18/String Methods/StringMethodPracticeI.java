public class StringMethodPracticeI {
	public static void main (String[]args) {

//Practice I
		String x = "The five boxing wizards jump quickly";
		char[] letters = new char [36];
		int num = 0;

		for (int i = x.length(); i > 0; i--) {
			letters[num] = (x.charAt(i - 1));
			num++;
		}
		for (int i = 0; i < letters.length; i++) {
			System.out.print(letters[i]);
		}
		System.out.println("\n");

//Practice II
		for (int i = 0; i < x.length(); i++) {
		    x = x.substring(1, x.length() - i)
		        + x.substring(0, 1)
		        + x.substring(x.length() - i, x.length());
 		}
		System.out.println(x + "\n");

//Practice III
		x = "The five boxing wizards jump quickly";
		System.out.println(x.toUpperCase() + "\n");

//Practice IV
		letters = new char [36];

		for (int i = 0; i < x.length(); i++) {
			if ((x.charAt(i) == 'a') || (x.charAt(i) == 'e') || (x.charAt(i) == 'i') || (x.charAt(i) == 'o') || (x.charAt(i) == 'u'))
				letters[i] = 'W';
			else
				letters[i] = x.charAt(i);
		}
		for (int i = 0; i < letters.length; i++) {
			System.out.print(letters[i]);
		}
		System.out.println("\n");

//Practice V
		letters = new char [18];
		num = 0;

		for (int i = 0; i < x.length(); i += 2) {
			letters[num] = x.charAt(i);
			num++;
		}
		for (int i = 0; i < letters.length; i++) {
			System.out.print(letters[i]);
		}
		System.out.println("\n");

//Practice VI
		String[] letters2 = x.split(" ");
		System.out.println(letters2.length + "\n");

//Practice VII
		letters2 = x.split(" ");
		double sum = 0;

		for (int i = 0; i < letters2.length; i++) {
			sum += letters2[i].length();
		}
		System.out.println(sum/letters2.length + "\n");

//Practice VIII
		letters2 = x.split(" ");

		for (int i = 5; i >= 0; i--) {
			System.out.print(letters2[i] + " ");
		}
		System.out.println("\n");

	}
}