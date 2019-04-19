import java.util.ArrayList;

public class ArrayListDemo { //refer to https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

	public static void main (String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(list.size());

		for (int i = 1; i <= 10; i++)
			list.add(i); //add method allows insertion of elements to end of list

		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " "); //get method acquires element from the list, does not change it
		System.out.println();

		System.out.println(list); //only used to print array list in brackets, with commas in between elements

		list.add(1, -1); //add method inserts element to location in list by order of (index, element)
		System.out.println(list);

		list.set(2, -2); //set method replaces element at some index within the list
		System.out.println(list);

		list.remove(4); //remove method removes some index's element within the list
		System.out.println(list);

		System.out.println(list.remove(4)); //prints removed element and prints the resulting list
		System.out.println(list);

		list.add(4, list.remove(2)); //removes element from list at index 2, replaces it at new index 4
		System.out.println(list);

	}

}