import java.util.Scanner;
public class StringMethodQuiz {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);

		System.out.print("Enter a two-word string: ");
		String a = reader.nextLine();
		String[] words = a.split(" ");
		String word1 = words[0], word2 = words[1];
		System.out.println(arrange(word1, word2) + "\n");

	}
	public static String arrange (String word1, String word2) {
		String temp = "";
		if (word1.length() == word2.length()) {
			for (int i = 0; i < word1.length(); i++) {
				temp += word1.charAt(i);
				temp += word2.charAt(i);
			}
		}
		else if (word1.length() > word2.length()) {
			for (int i = 0; i < word2.length(); i++) {
				temp += word1.charAt(i);
				temp += word2.charAt(i);
			}
			for (int i = word2.length(); i < word1.length(); i++) {
				temp += word1.charAt(i);
			}
		}
		else if (word1.length() < word2.length()) {
			for (int i = 0; i < word1.length(); i++) {
			 	temp += word1.charAt(i);
				temp += word2.charAt(i);
			}
			for (int i = word1.length(); i < word2.length(); i++) {
				temp += word2.charAt(i);
			}
		}
		word1 = temp;
		return word1;
	}
}