import java.util.ArrayList;

public class ReferencesI {

	public static void main (String [] args) {
		/**
		 * Four ArrayLists (list1, list2, list3, list4) are each initilized
		 * with three different integer values ranging from 1 - 12.
		 */
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(4);
		list2.add(5);
		list2.add(6);

		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(7);
		list3.add(8);
		list3.add(9);

		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(10);
		list4.add(11);
		list4.add(12);

		System.out.println("LIST 1: " + list1 + "\n" +
						   "LIST 2: " + list2 + "\n" +
						   "LIST 3: " + list3 + "\n" +
						   "LIST 4: " + list4 + "\n");

		/**
		 * list2, list3, and list4 are set equal to list1, setting their
		 * pointers to the ArrayList stored in memory for list1.  The data
		 * for list2, list3, and list4 is removed from memory through garbage
		 * collection.
		 */
		list2 = list1;
		list3 = list1;
		list4 = list1;

		System.out.println("LIST 1: " + list1 + "\n" +
						   "LIST 2: " + list2 + "\n" +
						   "LIST 3: " + list3 + "\n" +
						   "LIST 4: " + list4 + "\n");

		/**
		 * Since all four ArrayLists now point to the same data stored in
		 * memory for list1, when a new integer (4) is added to list2, the
		 * single set of data in memory is updated to now include the element
		 * 4.  When all four ArrayLists are subsequently referenced, they
		 * each now contain the integer 4.
		 */
		list2.add(4);

		System.out.println("LIST 1: " + list1 + "\n" +
						   "LIST 2: " + list2 + "\n" +
						   "LIST 3: " + list3 + "\n" +
						   "LIST 4: " + list4 + "\n");
	}
}