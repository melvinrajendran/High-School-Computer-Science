public class CriticalQuestion2ReviewI {
	public static void main (String[]args) {

		int[] array = new int[8];
		int min = Integer.MAX_VALUE, sum = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)((Math.random()*19)+1);
			sum += array[i];
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println(min + " " + sum + "\n");

	}
}