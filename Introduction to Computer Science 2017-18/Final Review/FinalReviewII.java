import java.util.Scanner;
public class FinalReviewII {

    public static void main(String[] args) {

        Scanner number = new Scanner (System.in);

//Task 1
        /*System.out.println("\"Hello World!\"\n");

//Task 2
        System.out.println("*****\n****\n***\n**\n*\n");

//Task 3
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

//Task 4
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < i; j += 2) {
                System.out.print("*");
            }
            System.out.println(i);
        }
        System.out.println();

//Task 5
		System.out.println((int)(Math.random()*8)+56 + "\n");

//Task 6
        int[] randomNums = new int[10];
        double sum = 0;
        for (int i = 0; i < randomNums.length; i++) {
            randomNums[i] = (int)((Math.random()*67)+7);
            sum += randomNums[i];
            System.out.print(randomNums[i] + " ");
        }
        System.out.println("\nAverage: " + sum/randomNums.length + "\n");

//Task 7
        System.out.print("Enter the numerator of the fraction: ");
        int numerator = number.nextInt();
        System.out.print("Enter the denominator of the fraction: ");
        int denominator = number.nextInt();
        String fraction = Integer.toString(numerator);
        fraction += "\\" + Integer.toString(denominator);
        if (numerator == 0) {
            System.out.println(0 + "\n");
        }
        else if (denominator == 0) {
            System.out.println("undefined\n");
        }
        else {
            System.out.println(fraction + "\n");
        }

//Task 8
        System.out.print("Enter length (feet): ");
        double length = number.nextDouble();
        System.out.print("Enter width (feet): ");
        double width = number.nextDouble();
        double area = length * width;
        double areaAcres = (length * width)/43560;
        System.out.println("Area measure is " + area + " square feet or " + areaAcres + " acres.\n");
        System.out.println("Property tax is $" + (5000 * areaAcres) + ".");
        System.out.println("Cost Per Month is " + (5000 * areaAcres)/12 + "\n");

//Task 9
        System.out.print("Enter the first integer: ");
        int int1 = number.nextInt();
        System.out.print("Enter the second integer: ");
        int int2 = number.nextInt();
        System.out.println(int1 + " " + int2);
        swapEm(int1, int2);

//Task 10
		int roll = 0, point = 0;
		while (roll >= 0) {
			roll++;
			int dice1 = 0, dice2 = 0;
			if (roll == 1) {
				System.out.print("Roll " + roll + ": New Game\t");
				dice1 = (int)(Math.random()*6)+1;
				dice2 = (int)(Math.random()*6)+1;
				point = dice1 + dice2;
			}
			else {
				System.out.print("Roll " + roll + "\t\t\t");
				dice1 = (int)(Math.random()*6)+1;
				dice2 = (int)(Math.random()*6)+1;
			}
			System.out.print("Player rolls a sum of " + (dice1 + dice2) + ".");
			if (roll == 1) {
				if ((point == 7) || (point == 11)) {
					System.out.println("\tPlayer wins!");
					break;
				}
				else if ((point == 2) || (point == 3) || (point == 12)) {
					System.out.println("\tPlayer loses.");
					break;
				}
				else {
					System.out.println("\tContinue.");
				}
			}
			else {
				if (dice1 + dice2 == point) {
					System.out.println("\tPlayer wins!");
					break;
				}
				else if (dice1 + dice2 == 7) {
					System.out.println("\tPlayer loses.");
					break;
				}
				else {
					System.out.println("\tContinue.");
				}
			}
		}
		System.out.println();*/

//Task 11
		double wins = 0, losses = 0;
		for (int i = 0; i < 10000; i++) {
			int roll = 0, point = 0;
			while (roll >= 0) {
				roll++;
				int dice1 = 0, dice2 = 0;
				if (roll == 1) {
					dice1 = (int)(Math.random()*6)+1;
					dice2 = (int)(Math.random()*6)+1;
					point = dice1 + dice2;
				}
				else {
					dice1 = (int)(Math.random()*6)+1;
					dice2 = (int)(Math.random()*6)+1;
				}
				if (roll == 1) {
					if ((point == 7) || (point == 11)) {
						wins++;
						break;
					}
					else if ((point == 2) || (point == 3) || (point == 12)) {
						losses++;
						break;
					}
				}
				else {
					if (dice1 + dice2 == point) {
						wins++;
						break;
					}
					else if (dice1 + dice2 == 7) {
						losses++;
						break;
					}
				}
			}
		}
		System.out.println("Total Wins: " + wins + "\nTotal Losses: " + losses + "\nEstimated Probability of Winning: " + (wins/(wins+losses))*100 + "%\n");

    }
    public static void swapEm (int int1, int int2) {
        int temp = int1;
        int1 = int2;
        int2 = temp;
        System.out.println(int1 + " " + int2);
    }
}
