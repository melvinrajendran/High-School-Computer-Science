public class WhileLoopsPracticeII {
	public static void main (String[]args) {

		int x = 1;
		int y = 10;
		int c = 0;

		do {
			if (x % 2 != 0) {
				y += x;
			}
			else if (x % 2 == 0) {
				y = (y / (x + 1));
			}
			x++;
			c++;
		} while (y != 0);
		System.out.println(c);
	}
}