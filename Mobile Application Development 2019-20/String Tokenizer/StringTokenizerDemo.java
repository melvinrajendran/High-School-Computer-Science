import java.util.StringTokenizer;

public class StringTokenizerDemo
{
	public static void main(String[] args) {

	    m1();

	    System.out.println();

	    m2();

	}

	public static void m1() {
	    String str = "The force will be with you.";
	    StringTokenizer tokenizer = new StringTokenizer(str);

	    while (tokenizer.hasMoreTokens()) {
	        String currentToken = tokenizer.nextToken();
	        System.out.println(currentToken);
	    }
	}

	public static void m2() {
	    String str = "The force will be with you.";
	    StringTokenizer tokenizer = new StringTokenizer(str, "e", true);

	    while (tokenizer.hasMoreTokens()) {
	        String currentToken = tokenizer.nextToken();
	        System.out.println(currentToken);
	    }
	}
}