public class Array2PracticeI {
	public static void main (String[]args) {

//Practice I
		int[] array1 = new int[6];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = (int)(Math.random()*20)+1;
			System.out.print(array1[i] + " ");
		}
		int temp = array1[3];
		array1[3] = array1[4];
		array1[4] = temp;
		System.out.println();
		for (int j = 0; j < array1.length; j++) {
			System.out.print(array1[j] + " ");
		}
		System.out.println("\n");

//Practice II
		double sum = 0;
		int[] array2 = new int[10];
		for (int i = 0; i < array2.length; i++) {
			array2[i] = i + 4;
			System.out.print(array2[i] + " ");
			sum += array2[i];
		}
		System.out.println("\n" + (double)(sum/array2.length) + "\n");

//Practice III
		int[] array3 = new int[8];
		for (int i = 0; i < array3.length; i++) {
			array3[i] = i + 1;
			System.out.print(array3[i] + " ");
		}
		int temp1 = array3[0], temp2 = array3[1], temp3 = array3[2], temp4 = array3[3];
		array3[0] = array3[7];
		array3[1] = array3[6];
		array3[2] = array3[5];
		array3[3] = array3[4];
		array3[7] = temp1;
		array3[6] = temp2;
		array3[5] = temp3;
		array3[4] = temp4;
		System.out.println();
		for (int j = 0; j < array3.length; j++) {
			System.out.print(array3[j] + " ");
		}
		System.out.println();
	}
}