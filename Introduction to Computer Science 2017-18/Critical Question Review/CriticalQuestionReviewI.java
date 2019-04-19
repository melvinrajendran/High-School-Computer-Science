public class CriticalQuestionReviewI {
	public static void main (String[]args) {

		int[] array = new int[10];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)((Math.random()*8)+3);
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println(max + "\n");

	}
}