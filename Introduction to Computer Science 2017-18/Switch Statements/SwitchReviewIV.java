import java.util.Scanner;
public class SwitchReviewIV {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);

		System.out.print("Please enter you score: ");
		int score = reader.nextInt();
		String lettergrade = " ";

		if ((score >= 93) && (score <= 100))
			lettergrade = "A";
		else if ((score >= 90) && (score <= 92))
			lettergrade = "A-";
		else if ((score >= 87) && (score <= 89))
			lettergrade = "B+";
		else if ((score >= 83) && (score <= 86))
			lettergrade = "B";
		else if ((score >= 80) && (score <= 82))
			lettergrade = "B-";
		else if ((score >= 77) && (score <= 79))
			lettergrade = "C+";
		else if ((score >= 73) && (score <= 76))
			lettergrade = "C";
		else if ((score >= 70) && (score <= 72))
			lettergrade = "C-";
		else if ((score >= 65) && (score <= 69))
			lettergrade = "D";
		else if (score <= 64)
			lettergrade = "F";

		switch (lettergrade) {
			case "A": System.out.println("Your grade is an A.\n");
				break;
			case "A-": System.out.println("Your grade is an A-.\n");
				break;
			case "B+": System.out.println("Your grade is a B+.\n");
				break;
			case "B": System.out.println("Your grade is a B.\n");
				break;
			case "B-": System.out.println("Your grade is a B-.\n");
				break;
			case "C+": System.out.println("Your grade is a C+.\n");
				break;
			case "C": System.out.println("Your grade is a C.\n");
				break;
			case "C-": System.out.println("Your grade is a C-.\n");
				break;
			case "D": System.out.println("Your grade is a D.\n");
				break;
			case "F": System.out.println("Your grade is an F.\n");
				break;
		}
	}
}