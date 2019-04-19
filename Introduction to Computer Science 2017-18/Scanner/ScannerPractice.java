import java.util.Scanner;
  public class ScannerPractice{
	public static void main(String[]args){

//Practice 1

		Scanner reader = new Scanner(System.in);
		System.out.println("Enter your number.");
		int number = reader.nextInt();
		System.out.println("Here is it's square:");
		System.out.println(number * number);
		System.out.println("");

//Practice II

		Scanner volume = new Scanner(System.in);
		double pi = 3.14;
		System.out.println("Please enter the radius of the cylinder:");
		int number1 = volume.nextInt();
		System.out.println("Please enter the height of the cylinder:");
		int number2 = volume.nextInt();
		System.out.println("The volume is:");
		System.out.println(pi * number1 * number1 * number2);
		System.out.println("The surface area is:");
		System.out.println(2 * pi * number1 * number2 + 2 * pi * number1 * number1);
		System.out.println("");

//Practice III

		Scanner average = new Scanner (System.in);
		System.out.println("Please enter your name:");
		String name = average.nextLine();
		System.out.println("Please enter your first score:");
		int score1 = average.nextInt();
		System.out.println("Please enter your second score:");
		int score2 = average.nextInt();
		System.out.println(name + " has an average of " + (score1 + score2)/2.0 + "%");
		System.out.println("");

}
}