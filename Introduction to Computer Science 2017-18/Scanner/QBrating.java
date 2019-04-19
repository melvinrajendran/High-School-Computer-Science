import java.util.Scanner;
	public class QBrating {
		public static void main (String[]args) {

			Scanner rating = new Scanner(System.in);

			System.out.print("Enter the name of the first Quarterback: ");
			String name1 = rating.nextLine();
			System.out.println("");
			System.out.println("Enter the Yards of " + name1 + ":");
			int yards1 = rating.nextInt();
			System.out.println("Enter the Completions of " + name1 + ":");
			int comp1 = rating.nextInt();
			System.out.println("Enter the Touchdowns of " + name1 + ":");
			int touch1 = rating.nextInt();
			System.out.println("Enter the Interceptions of " + name1 + ":");
			int inter1 = rating.nextInt();
			System.out.println("Enter the Attempts of " + name1 + ":");
			int att1 = rating.nextInt();
			System.out.println("");

			double a1 = (((comp1/(double)att1)*100)-30)/(double)20;
			double b1 = ((touch1/(double)att1)*100)/(double)5;
			double c1 = (9.5-((inter1/(double)att1)*100))/(double)4;
			double d1 = ((yards1/(double)att1)-3)/(double)4;
			double rating1 = (a1 + b1 + c1 + d1)/.06;
			rating.nextLine();

			System.out.print("Enter the name of the second quaterback: ");
			String name2 = rating.nextLine();
			System.out.println("");
			System.out.println("Enter the Yards of " + name2 + ":");
			int yards2 = rating.nextInt();
			System.out.println("Enter the Completions of " + name2 + ":");
			int comp2 = rating.nextInt();
			System.out.println("Enter the Touchdowns of " + name2 + ":");
			int touch2 = rating.nextInt();
			System.out.println("Enter the Interceptions of " + name2 + ":");
			int inter2 = rating.nextInt();
			System.out.println("Enter the Attempts of " + name2 + ":");
			int att2 = rating.nextInt();
			System.out.println("");

			double a2 = (((comp2/(double)att2)*100)-30)/(double)20;
			double b2 = ((touch2/(double)att2)*100)/(double)5;
			double c2 = (9.5-((inter2/(double)att2)*100))/(double)4;
			double d2 = ((yards2/(double)att2)-3)/(double)4;
			double rating2 = (a2 + b2 + c2 + d2)/.06;

			System.out.println("Player\t\tYards\tCompletions\tTouchdowns\tInterceptions\tAttempts\tRating");
			System.out.println(name1 + "\t" + yards1 + "\t" + comp1 + "\t\t" + touch1 + "\t\t" + inter1 + "\t\t" + att1 + "\t\t" + rating1);
			System.out.println(name2 + "\t" + yards2 + "\t" + comp2 + "\t\t" + touch2 + "\t\t" + inter2 + "\t\t" + att2 + "\t\t" + rating2);
			System.out.println("");

}
}