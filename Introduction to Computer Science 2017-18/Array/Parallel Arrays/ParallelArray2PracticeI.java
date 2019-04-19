import java.util.Scanner;
public class ParallelArray2PracticeI {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);
		Scanner num = new Scanner (System.in);

//Practice I
		/*String[] name = {"Clayton Kershaw", "Jake Arrieta", "David Price", "Max Scherzer", "Chris Sale", "Dallas Keuchel", "Zack Greinke", "Corey Kluber", "Gerrit Cole"};
		String[] Stat = {"Team", "Wins", "Losses", "Games", "IP", "Strikeouts", "Walks", "ERA"};
		String[] Team = {"Dodgers", "Cubs", "Red Sox", "Nationals", "White Sox", "Astros", "Dodgers", "Indians", "Pirates"};
		int[] Wins = {16, 22, 18, 14, 13, 20, 19, 9, 19};
		int[] Losses = {7, 6, 5, 12, 11, 8, 3, 16, 8};
		int[] Games = {33, 33, 32, 33, 31, 33, 32, 32, 32};
		double[] IP = {232.2, 229, 220.1, 228.2, 208.2, 232, 222.2, 222, 208};
		double[] Strikeouts = {11.64, 9.28, 9.19, 10.86, 11.82, 8.38, 8.08, 9.93, 8.74};
		double[] Walks = {1.62, 1.89, 1.92, 1.34, 1.81, 1.98, 1.62, 1.82, 1.9};
		double[] ERA = {2.13, 1.77, 2.45, 2.79, 3.41, 2.48, 1.66, 3.49, 2.6};

		int a = 0;
		while (a == 0) {
			System.out.print("Which player\'s stats would you like to research? ");
			String player = reader.nextLine();
			if (player.equalsIgnoreCase("quit"))
				break;
			int b = 0;
			for (int i = 0; i < name.length; i++) {
				if (player.equals(name[i]))
					b = i;
			}
			System.out.print("Which stat would you like? ");
			String stat = reader.nextLine();
			int c = 0;
			for (int j = 0; j < Stat.length; j++) {
				if (stat.equalsIgnoreCase(Stat[j]))
					c = j;
			}
			if (c == 0)
				System.out.println(name[b] + " is on the " + Team[b] + ".");
			else if (c == 1)
				System.out.println(name[b] + " had " + Wins[b] + " wins last season.");
			else if (c == 2)
				System.out.println(name[b] + " had " + Losses[b] + " losses last season.");
			else if (c == 3)
				System.out.println(name[b] + " played " + Games[b] + " games last season.");
			else if (c == 4)
				System.out.println(name[b] + " pitched " + IP[b] + " innings last season.");
			else if (c == 5)
				System.out.println(name[b] + " had " + Strikeouts[b] + " strikeouts per nine innings last season.");
			else if (c == 6)
				System.out.println(name[b] + " had " + Walks[b] + " walks last season.");
			else if (c == 7)
				System.out.println(name[b] + " had a " + ERA[b] + " earned run average last season.");
		}*/

//Practice II
		System.out.print("Please enter how many inputs you would like to make: ");
		int input = num.nextInt();
		String[] name = new String[input];
		int[] age = new int[input];
		int[] heightft = new int[input];
		int[] heightin = new int[input];
		double[] weight = new double[input];
		double agesum = 0;
		double heightsum = 0;
		double weightsum = 0;
		System.out.println();

		for (int i = 0; i < input; i++) {
			System.out.print("Please enter the name of the person: ");
			name[i] = reader.nextLine();
			System.out.print("Please enter his/her age: ");
			age[i] = num.nextInt();
			System.out.print("Please enter his/her height (feet): ");
			heightft[i] = num.nextInt();
			System.out.print("Please enter his/her height (inches): ");
			heightin[i] = num.nextInt();
			System.out.print("Please enter his/her weight: ");
			weight[i] = num.nextDouble();
			System.out.println();
		}
		for (int j = 0; j < input; j++) {
			agesum += age[j];
			heightsum += (heightft[j] + ((double)heightin[j]/12));
			weightsum += weight[j];
		}

		System.out.println("Average Age: " + (agesum/input) + " years\nAverage Height: " + (heightsum/input) + " feet\nAverage Weight: " + (weightsum/input) + " pounds\n");
	}
}