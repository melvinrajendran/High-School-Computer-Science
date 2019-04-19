import java.util.ArrayList;

public class GitHubI {

	public static void main (String[] args) {

		ArrayList<Integer> list = new ArrayList<>(), list2 = new ArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(1);

		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(9);
		list2.add(8);
		list2.add(7);

		System.out.println(combine(list, list2) + "\n");

		print(list);

		System.out.println("\n" + removeDuplicates(list2) + "\n");

	}

	public static ArrayList<Integer> combine (ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> newList = new ArrayList<>();

		for (int i = 0; i < list1.size(); i++)
			newList.add(list1.get(i));
		for (int i = 0; i < list2.size(); i++)
			newList.add(list2.get(i));

		return newList;
	}

	public static void print (ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size() - 1)
				System.out.print(list.get(i) + ", ");
			else
				System.out.println(list.get(i));
		}
	}

	public static ArrayList<Integer> removeDuplicates (ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) == list.get(j))
					list.remove(j);
			}
		}
		return list;
	}

}