import java.util.Scanner;
	public class BodyMassIndex {
		public static void main (String[]args) {

			Scanner reader = new Scanner (System.in);

				System.out.print("Input weight in pounds: ");
				int weight = reader.nextInt();
				System.out.print("Input height in inches: ");
				int height = reader.nextInt();

				double bmi = ((weight)/(double)(height * height))*703;

				System.out.print("Body Mass index is: " + bmi);
				System.out.println("");

}
}