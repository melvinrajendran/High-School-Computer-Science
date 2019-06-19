public class Review2 {

	public static void main (String [] args) {
		//Comparable str = &quot;This is a test&quot;;

		//public int compareTo (Object obj)

		String one = "a";
		String two = "b";
		String three = "c";
		String four = "A";

		String five = "aa";
		String six = "aaabc";

		//b to c
		System.out.println(two.compareTo(three));

		//b to a
		System.out.println(two.compareTo(one));
		
		//b to b
		System.out.println(two.compareTo(two));
		
		//a to c
		System.out.println(one.compareTo(three));
		
		//A to a
		System.out.println(four.compareTo(one));
		
		System.out.println(five.compareTo(six));
		
		//complete AP-1 &gt; userCompare
	}
}