public class StringsI {

	public static void main (String [] args) {
		String exampleString = "ThIs is A tEst";

		System.out.println("Example String: " + exampleString + "\n");

//Task 1
		for (int i = 0; i < exampleString.length(); i++)
			System.out.print(exampleString.charAt(i));

		System.out.println("\n");

//Task 2
		System.out.println(exampleString.substring(0, exampleString.indexOf(" ")) + "\n");

//Task 3
		for (int i = 0; i < exampleString.indexOf(" "); i++)
			System.out.print(exampleString.charAt(i));

		System.out.println("\n");

//Task 4
		String newString = "";

		for (int i = exampleString.length() - 1; i >= 0; i--)
			newString += exampleString.charAt(i);

		System.out.println(newString + "\n");

//Task 5
		String[] arrayString = new String[exampleString.length()];

		for (int i = 0; i < exampleString.length(); i++)
			arrayString[i] = exampleString.charAt(i) + "";

		for (int i = 0; i < exampleString.length()/2; i++) {
			String temp = arrayString[i];
			arrayString[i] = arrayString[arrayString.length - 1 - i];
			arrayString[arrayString.length - 1 - i] = temp;
		}

		exampleString = "";

		for (int i = 0; i < arrayString.length; i++)
			exampleString += arrayString[i];

		System.out.println(exampleString + "\n");

//Task 6
		int lowerCase = 0;

		for (int i = 0; i < exampleString.length(); i++) {
			int charValue = (int)exampleString.charAt(i);

			if (charValue >= 97 && charValue <= 122)
				lowerCase++;
		}

		System.out.println(lowerCase + "\n");
	}
}