import java.util.Scanner;
	public class WeightedAvg {
		public static void main (String[]args) {

			Scanner reader = new Scanner (System.in);

			System.out.print("Enter the first student's name: ");
			String name1 = reader.nextLine();
			System.out.print("Enter the grade for tests/quizzes: ");
			int test1 = reader.nextInt();
			System.out.print("Enter the grade for projects: ");
			int project1 = reader.nextInt();
			System.out.print("Enter the grade for participation: ");
			int partic1 = reader.nextInt();
			System.out.print("Enter the grade for homework: ");
			int homework1 = reader.nextInt();
			reader.nextLine();
			System.out.println("");

			System.out.print("Enter the second student's name: ");
			String name2 = reader.nextLine();
			System.out.print("Enter the grade for tests/quizzes: ");
			int test2 = reader.nextInt();
			System.out.print("Enter the grade for projects: ");
			int project2 = reader.nextInt();
			System.out.print("Enter the grade for participation: ");
			int partic2 = reader.nextInt();
			System.out.print("Enter the grade for homework: ");
			int homework2 = reader.nextInt();
			reader.nextLine();
			System.out.println("");

			double weightedavg1 = (0.60)*(test1)+(0.15)*(project1)+(0.10)*(homework1)+(0.15)*(partic1);
			double weightedavg2 = (0.60)*(test2)+(0.15)*(project2)+(0.10)*(homework2)+(0.15)*(partic2);

			System.out.println("Name\t\tTests/Quizzes\tProjects\tParticipation\tHomework\tFinal Grade\n");
			System.out.println(name1 + "\t" + test1 + "\t\t" + project1 + "\t\t" + partic1 + "\t\t" + homework1 + "\t\t" + weightedavg1 + "\n");
			System.out.println(name2 + "\t" + test2 + "\t\t" + project2 + "\t\t" + partic2 + "\t\t" + homework2 + "\t\t" + weightedavg2 + "\n");

}
}