import java.util.ArrayList;

public class RecursionII {

	public static void main (String [] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 15; i++)
            list.add((int)(Math.random()*10)+1);

        //System.out.println("Test ArrayList: " + list + "\n");

        for (int i : list)
            System.out.print(i + " ");
        System.out.println("\n");

        //Task 1
        System.out.println(numberSearch(list, 1) + "\n");

        //Task 2
        System.out.println(recursiveNumberSearch(list, 1, 0) + "\n");

        //Task 3
        for (int i = 0; i < 10; i++)
            list.add((int)(Math.random()*10)+11);

        for (int i : list)
            System.out.print(i + " ");
        System.out.println("\n");

        //Task 4
        for (int i = 0; i < 5; i++) {
            int randomIndex = (int)(Math.random()*25);
            int element = (int)(Math.random()*10)+21;

            while (list.contains(element))
                element = (int)(Math.random()*10)+21;

            list.set(randomIndex, element);
        }

        for (int i : list)
            System.out.print(i + " ");
        System.out.println("\n");

    }

    public static int numberSearch(ArrayList<Integer> list, int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key)
                return i;
        }

        return -1;
    }

    public static int recursiveNumberSearch(ArrayList<Integer> list, int key, int index) {
        if (index == list.size())
            return -1;

        if (list.get(index) == key)
            return index;

        return recursiveNumberSearch(list, key, index + 1);
    }
}