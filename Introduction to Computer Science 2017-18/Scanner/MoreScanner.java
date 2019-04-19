import java.util.Scanner;
  public class MoreScanner {
	public static void main (String[]args) {

		Scanner gpa = new Scanner(System.in);
		System.out.println("Please enter the name of the student:");
		String name = gpa.nextLine();
		System.out.println("");

		System.out.println("Please enter the name of the first class:");
		String subject1 = gpa.nextLine();
		System.out.println("How many credits is this course?");
		double credit1 = gpa.nextDouble();
		System.out.println("How many grade points did you earn?");
		double points1 = gpa.nextDouble();
		gpa.nextLine();
		System.out.println("");

		System.out.println("Please enter the name of the second class:");
		String subject2 = gpa.nextLine();
		System.out.println("How many credits is this course?");
		double credit2 = gpa.nextDouble();
		System.out.println("How many grade points did you earn?");
		double points2 = gpa.nextDouble();
		gpa.nextLine();
		System.out.println("");

		System.out.println("Please enter the name of the third class:");
		String subject3 = gpa.nextLine();
		System.out.println("How many credits is this course?");
		double credit3 = gpa.nextDouble();
		System.out.println("How many grade points did you earn?");
		double points3 = gpa.nextDouble();
		gpa.nextLine();
		System.out.println("");

		System.out.println(name + "\n");
		System.out.println("Class\t\tCredits\t\tGrade Point");
		System.out.println(subject1 + "\t\t" + credit1 + "\t\t" + points1);
		System.out.println(subject2 + "\t\t" + credit2 + "\t\t" + points2);
		System.out.println(subject3 + "\t\t" + credit3 + "\t\t" + points3 + "\n");
		System.out.println("GPA: " + (credit1 * points1 + credit2 * points2 + credit3 * points3)/(credit1 + credit2 + credit3) + "\n");

}
}