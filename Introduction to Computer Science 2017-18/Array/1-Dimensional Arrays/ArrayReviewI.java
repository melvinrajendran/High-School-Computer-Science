public class ArrayReviewI {
	public static void main (String[]args) {

//Practice I
		int[] array = new int[30];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)((Math.random()*31)+5);
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");

//Practice II
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				array[i] *= 3;
			}
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");

//Practice III
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 1) {
				array[i] = array[i - 1];
			}
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");

//Practice IV
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println(max + "\n");

//Practice V
		int emax = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] > emax) && (array[i] % 2 == 0)) {
				emax = array[i];
			}
		}
		System.out.println(emax + "\n");

//Practice VI
		int emin = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] < emin) && (array[i] % 2 == 0)) {
				emin = array[i];
			}
		}
		System.out.println(emin + "\n");

//Practice VII
		int omax = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] > omax) && (array[i] % 2 == 1)) {
				omax = array[i];
			}
		}
		System.out.println(omax + "\n");

//Practice VIII
		int omin = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] < omin) && (array[i] % 2 == 1)) {
				omin = array[i];
			}
		}
		System.out.println(omin + "\n");

//Practice IX
		for (int i = 0; i < array.length; i++) {
			if (i == (array.length - 1)) {
				array[i] = array[0];
			}
			else {
				array[i] = array[i + 1];
			}
				System.out.print(array[i] + " ");
		}
		System.out.println("\n");

//Practice X
		int[] tarray = new int[30];
		int maxindex = 29;
		for (int i = 0; i < array.length; i++) {
			tarray[i] = array[maxindex];
			maxindex--;
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(tarray[i] + " ");
		}
		System.out.println("\n");
	}
}