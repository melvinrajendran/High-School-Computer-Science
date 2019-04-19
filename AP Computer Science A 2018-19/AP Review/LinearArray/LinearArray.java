public class LinearArray {

	private int [] linearArray;

	public LinearArray (int[][] array2D) {
		this.linearArray = new int[array2D.length * array2D[0].length];

		for (int i = 0; i < array2D.length; i++) {

		}

	}

	public String toString() {
		String s = "";

		for (int i = 0; i < linearArray.length; i++)
			s += linearArray[i] + " ";

		return s;
	}

}