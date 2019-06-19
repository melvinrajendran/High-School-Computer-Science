public class Review3 {

	public static void main (String [] args) {
		//Example 1
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		int temp = list.set(0,20);
		System.out.println(temp);
		System.out.println(list);

		//Example 2
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.set(3,list.remove(0));
		//what happens first?
		System.out.println(list);
		//the index is selected for use with the set method then the remove method is called.
		//[2, 3, 4, 1]
	}
}