import java.util.*;

public class ForLoops {

	public static void main (String [] args) {

		ArrayList<String> list = new ArrayList<>();
		list.add("Bobby");
		list.add("Jim");


		/**
		 * enhanced for-loop
		 * runs through each object named 'item' in ArrayList list
		 * cannot access specific index in ArrayList
		 */
		for (String item : list)
			System.out.println(item);

	}

}