import java.util.ArrayList;

public class ReferenceDemo
{
	public static void main (String [] args)
	{
		ArrayList<String> listA = new ArrayList<>();
		ArrayList<String> listB = new ArrayList<>();

		listA.add("a");
		listA.add("b");
		listA.add("c");

		listB.add("d");
		listB.add("e");
		listB.add("f");

		System.out.println("LIST A: " + listA);
		System.out.println("LIST B: " + listB);

		listA.add("A");
		listB.add("B");

		System.out.println("LIST A: " + listA);
		System.out.println("LIST B: " + listB);

		listA = listB;

		System.out.println("LIST A: " + listA);
		System.out.println("LIST B: " + listB);

		listA.add("1234567");

		System.out.println("LIST A: " + listA);
		System.out.println("LIST B: " + listB);
	}
}