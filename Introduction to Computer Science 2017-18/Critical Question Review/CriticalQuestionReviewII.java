public class CriticalQuestionReviewII {
	public static void main (String[]args) {

		for (int i = 300; i <= 500; i++) {
			if (i % 2 == 0) {
				if (i % 11 == 0) {
					System.out.print(i + " ");
				}
			}
		}
		System.out.println("\n");
	}
}