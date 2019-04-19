public class Melvin_RajendranStrings {
	public static void main (String[]args) {

		String name = "Melvin Rajendran";

//Part I
		char[] letters = new char [name.length()];
		int num = 0;

		for (int i = name.length(); i > 0; i--) {
			letters[num] = (name.charAt(i-1));
			num++;
		}
		for (int i = 0; i < letters.length; i++) {
			System.out.print(letters[i]);
		}
		System.out.println("\n");

//Part II
		System.out.println(cap(name) + "\n");

//Part III
		String name2 = "";

		for (int i = 0; i < name.length(); i++) {
			if (!(name.charAt(i) == ' ')) {
				name2 += name.charAt(i);
			}
		}
		for (int i = 0; i < name2.length(); i++) {
			if (i % 2 == 0) {
				System.out.print(name2.charAt(i));
			}
		}
		System.out.println("\n");

//Part IV
		letters = new char [name.length()];

		for (int i = 0; i < name.length(); i++) {
			if ((name.charAt(i) == 'a') || (name.charAt(i) == 'e') || (name.charAt(i) == 'i') || (name.charAt(i) == 'o') || (name.charAt(i) == 'u'))
				letters[i] = 'S';
			else
				letters[i] = name.charAt(i);
		}
		for (int i = 0; i < letters.length; i++) {
			System.out.print(letters[i]);
		}
		System.out.println("\n");

//Part V
		String name3 = name.substring(name.length() - 3);
		System.out.println(name3 + "\n");

//Part VI
		String[] words = name.split(" ");
		for (int i = words.length - 1; i >= 0; i--) {
			System.out.print(words[i] + " ");
		}
		System.out.println("\n");

	}
	public static String cap (String name) {
		for (int i = 0; i < name.length(); i++) {
			name.toLowerCase();
			if (i % 2 == 0) {
				char first = Character.toUpperCase(name.charAt(i));
				name = name.replace(name.charAt(i), first);
			}
		}
		return name;
	}
}