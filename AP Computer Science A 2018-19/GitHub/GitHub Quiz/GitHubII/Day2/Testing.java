import java.util.ArrayList;

public class Testing {

	public static void main(String [] args) {

		int x = 1234;
		ArrayList<Integer> list = convertToArrayList(x);

		System.out.println(list);
		System.out.println(convertToInteger(list));

	}

	public static ArrayList<Integer> convertToArrayList (int n) {
		ArrayList<Integer> list = new ArrayList<>();
		while (n != 0) {
			int x = n % 10;
			list.add(0, x);
			 n = n / 10;
		}
		return list;
	}

	public static int convertToInteger (ArrayList<Integer> list) {
		String term = "";
		for (int i = 0; i < list.size(); i++)
			term += list.get(i);
		return Integer.parseInt(term);
	}

}