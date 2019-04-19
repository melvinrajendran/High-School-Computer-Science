public class LinearArrayRunner {

	public static void main (String [] args) {
		int [][] array = new int[][] {{1, 2, 3},
									  {4, 5, 6},
									  {7, 8, 9}};

		LinearArray la1 = new LinearArray (array);
		System.out.println(la1);

	}
}