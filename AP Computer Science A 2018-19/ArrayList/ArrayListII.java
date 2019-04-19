import java.util.ArrayList;

public class ArrayListII {
	public static void main (String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

//1
		for (int i = 0; i < 10; i++)
			list.add((int)(Math.random()*10+1));
		System.out.println(list);

		System.out.println(removeOnes(list) + "\n");

//2
		list = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add((int)(Math.random()*10+1));
			list2.add((int)(Math.random()*10+1));
		}

		System.out.println(list + "\n" + list2 + "\n" + combineLists(list, list2) + "\n");

//3
		list = new ArrayList<>();
		list2 = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add((int)(Math.random()*10+1));
			list2.add((int)(Math.random()*10+1));
		}

		System.out.println(list + "\n" + list2 + "\n" + greatValueList(list, list2) + "\n");

	}
	public static ArrayList<Integer> removeOnes(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 1) {
				list.remove(i);
				i--; //alternate solution is backwards for loop
			}
		}
		return list;
	}
	public static ArrayList<Integer> combineLists(ArrayList<Integer> list, ArrayList<Integer> list2) {
		ArrayList<Integer> comboList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			comboList.add(list.get(i));
		for (int i = 0; i < list2.size(); i++)
			comboList.add(list2.get(i));
		return comboList;
	}
	public static ArrayList<Integer> greatValueList(ArrayList<Integer> list, ArrayList<Integer> list2) {
		ArrayList<Integer> greatList = new ArrayList<>();
		if (list.size() > list2.size()) {
			for (int i = 0; i < list.size(); i++) {
				if (list2.get(i) > list.get(i) && list2.isEmpty() == false)
					greatList.add(list2.get(i));
				else
					greatList.add(list.get(i));
			}
		}
		else {
			for (int i = 0; i < list2.size(); i++) {
				if (list.get(i) > list2.get(i) && list.isEmpty() == false)
					greatList.add(list.get(i));
				else
					greatList.add(list2.get(i));
			}
		}
		return greatList;
	}
}