import java.util.ArrayList;

public class StringsII {

	public static void main (String [] args) {
		String test = "The quick brown fox jumped over the lazy dog";

		System.out.println("Test String: " + test + "\n");

//Task 1
		for (int i = 0; i < test.length(); i++) {
			if (test.charAt(i) != ' ')
				System.out.print(test.charAt(i));
			else
				System.out.println();
		}

		System.out.println("\n");

//Task 2
		ArrayList<String> list = new ArrayList<>();

		String word = "";

		for (int i = 0; i < test.length(); i++) {
			if (test.charAt(i) != ' ') {
				word += test.charAt(i);
			}
			else {
				list.add(word);
				word = "";
			}
		}
		list.add(word);

		System.out.println(list + "\n");

//Task 3
		String firstLexo = "";

		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).toLowerCase().compareTo(firstLexo) > 0 && firstLexo == "")
				firstLexo = list.get(i).toLowerCase();
			else if (list.get(i).toLowerCase().compareTo(firstLexo) < 0 && firstLexo != "")
				firstLexo = list.get(i).toLowerCase();
		}

		System.out.println(firstLexo + "\n");

//Task 4
		System.out.println(removeFirstLastChars(test.substring(0, test.indexOf(" "))) + "\n");

//Task 5
		ArrayList<String> nList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			nList.add(removeFirstLastChars(list.get(i)));
			System.out.print(nList.get(i) + " ");
		}

		System.out.println("\n");
	}

	public static String removeFirstLastChars(String word) {
		return word.substring(1,word.length() - 1);
	}
}