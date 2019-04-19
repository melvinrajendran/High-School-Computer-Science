public class StringsDemo {

	public static void main (String [] args) {
		String word = "Hello";
		String word2 = new String("Hello");
		String word3 = "Hello";
		String word4 = "abc";

		/**
		 * word == "Hello" returns boolean
		 */
		System.out.println(word == "Hello");

		/**
		 * returns false since Strings are instantiated differently
		 */
		System.out.println(word == word2);

		System.out.println(word == word4);

		System.out.println(word.equals("Hello"));
		System.out.println(word.equals(word2)); //*

		System.out.println(word.indexOf("el"));
		System.out.println(word.charAt(3));

		System.out.println(word.substring(1,4));
		System.out.println(word.substring(1,word.length()));

		System.out.println(word.substring(2));
	}
}