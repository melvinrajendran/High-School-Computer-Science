import java.util.ArrayList;

public class ArrayListQuiz {

	public static ArrayList<Integer> removeEven (ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				list.remove(i);
				i--;
			}
		}
		return list;
	}

	public static ArrayList<Integer> swapNumbers (ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 3 == 0 && i > 0) {
				int temp = list.get(i);
				list.set(i, list.get(i-1));
				list.set(i-1, temp);
			}
		}
		return list;
	}

	public static void main (String [] args){

		ArrayList<Integer> list1 = new ArrayList<Integer> ();
		ArrayList<Integer> list2 = new ArrayList<Integer> ();
		ArrayList<Integer> list3 = new ArrayList<Integer> ();
		ArrayList<Integer> list4 = new ArrayList<Integer> ();

		//list1 will be empty

		//list2 1,2,3,4,5,6,7,8,9
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(9);

		//list3 1,2,3,4,4,5,6
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		list3.add(4);
		list3.add(5);
		list3.add(6);

		//list4 3,2,4,5,9,10,12
		list4.add(3);
		list4.add(2);
		list4.add(4);
		list4.add(5);
		list4.add(9);
		list4.add(10);
		list4.add(12);

		//outputs

		System.out.println( removeEven(list1) );
		System.out.println( removeEven(list2) );
		System.out.println( removeEven(list3) );
		System.out.println( removeEven(list4) );


		ArrayList<Integer> list5 = new ArrayList<Integer> ();
		ArrayList<Integer> list6 = new ArrayList<Integer> ();
		ArrayList<Integer> list7 = new ArrayList<Integer> ();
		ArrayList<Integer> list8 = new ArrayList<Integer> ();

		//list5 will be empty

		//list6 1,2,3,4,5,6,7,8,9
		list6.add(1);
		list6.add(2);
		list6.add(3);
		list6.add(4);
		list6.add(5);
		list6.add(6);
		list6.add(7);
		list6.add(8);
		list6.add(9);

		//list7 1,2,3,4,4,5,6
		list7.add(1);
		list7.add(2);
		list7.add(3);
		list7.add(4);
		list7.add(4);
		list7.add(5);
		list7.add(6);

		//list8 3,2,4,5,9,10,12
		list8.add(3);
		list8.add(2);
		list8.add(4);
		list8.add(5);
		list8.add(9);
		list8.add(10);
		list8.add(12);

		//outputs

		System.out.println( swapNumbers(list5) );
		System.out.println( swapNumbers(list6) );
		System.out.println( swapNumbers(list7) );
		System.out.println( swapNumbers(list8) );


	}
}