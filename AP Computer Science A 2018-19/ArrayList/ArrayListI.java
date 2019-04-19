import java.util.ArrayList;

public class ArrayListI {
	public static void main (String[]args) {

		ArrayList<Integer> list = new ArrayList<>();

//1
		for (int i = 0; i < 10; i++)
			list.add((int)(Math.random()*11) + 10);
		System.out.println(list + "\n");

//2
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0)
				System.out.print(list.get(i) + " ");
		}
		System.out.println("\n");

//3
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0)
				list.set(i, list.get(i)+1);
		}
		System.out.println(list + "\n");

//4
		for (int i = 0; i < 10; i++)
			list.set(i, (int)(Math.random()*20)+1);
		System.out.println(list);

		System.out.println(firstLastSwap(list) + "\n");

//5
		for (int i = 0; i < 10; i++)
			list.set(i, (int)(Math.random()*20)+1);
		System.out.println(list);

		System.out.println(doubleOdds(list) + "\n");

	}
	public static ArrayList<Integer> firstLastSwap (ArrayList<Integer> list) {
		int temp = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.set(list.size()-1, temp);
		return list;
	}
	public static ArrayList<Integer> doubleOdds (ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i) % 2 == 1) && (i > 0))
				list.set(i, 2*list.get(i-1));
		}
		return list;
	}
}