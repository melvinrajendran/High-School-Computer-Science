public class ArrayQuiz {
	public static void main (String[]args) {

		int[] array = new int[20];
		double sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)((Math.random()*42)+13);
			if ((i == 4) || (i == 9) || (i == 14) || (i == 19)) {
				System.out.println(array[i]);
			}
			else {
				System.out.print(array[i] + " ");
			}
			sum += array[i];
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println("Sum:\t\t" + sum + "\nAverage:\t" + (sum/array.length) + "\nMin:\t\t" + min);
	}
}