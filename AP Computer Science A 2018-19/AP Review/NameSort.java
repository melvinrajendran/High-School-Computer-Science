import java.util.*;

//DOES NOT WORKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK

public class NameSort {

	public static void main (String [] args) {
		ArrayList<String> list = new ArrayList<>();

		list.add("Melvin Rajendran");
		list.add("John Rogers");
		list.add("Spongebob Squarepants");
		list.add("Michael Poot");
		list.add("Alex Anderson");
		list.add("Bart Simpson");
		list.add("John Johnny");
		list.add("Samuel Jackson");

		System.out.println(list);
		System.out.println(sortByLastName(list));
	}

	public static ArrayList<String> sortByLastName (ArrayList<String> list) {
		ArrayList<String> sortedList = new ArrayList<>();

		for (int i = 0; i < list.size() - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j).charAt(list.indexOf(" ") + 1) < list.get(i).charAt(list.indexOf(" ") + 1))
					minIndex = j;
			}

			String temp = list.get(i);
			sortedList.add(i, list.get(minIndex));
			sortedList.add(minIndex, temp);
		}

		return sortedList;
	}
}