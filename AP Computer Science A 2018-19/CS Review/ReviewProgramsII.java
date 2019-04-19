import java.util.Scanner;
public class ReviewProgramsII {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in);

//1
		int var1 = 0, var2 = 0, var3 = 0, var4 = 0, var5 = 5, var6 = 9;
		var1++;
		var2 += 3;
		var3 -= -75;
		var4--;
		var5 *= -100;
		var6 /= 3;
		System.out.println(var1 + " " + var2 + " " + var3 + " " + var4 + " " + var5 + " " + var6 + "\n");

//2
		System.out.print("ab");
		System.out.println("cd");
		System.out.print("ef");
		System.out.println("g\nh");
		System.out.println("ij");
		System.out.print("kl");
		System.out.print("mn");
		System.out.println("o\n");

//3
		int num = 5, den = 2;
		System.out.println(num + " divided by " + den + " is " + num/den + " with a remainder of " + num%den + ".\n");

//4
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
				if (i%3 != 0)
					System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();

//5
		int i = 1;
		do {
			int j = 1;
			while (j <= i) {
				System.out.print(j);
				if (i%3 != 0)
					System.out.print(j);
				j++;
			}
			System.out.println();
			i++;
		} while (i <= 6);
		System.out.println();

//6
		int d20 = (int)(Math.random()*20)+1;
		if (d20 == 20) {
			System.out.println("Perfect Roll!\n");
		}
		else if (d20 == 15 || d20 == 16 || d20 == 17 || d20 == 18 || d20 == 19) {
			int d4 = (int)(Math.random()*4)+1;
			System.out.println("20-sided dice roll: " + d20 + "\n4-sided dice roll: " + d4 + "\nSum: " + (d20 + d4) + "\n");
		}
		else if (d20 == 10 || d20 == 11 || d20 == 12 || d20 == 13 || d20 == 14) {
			System.out.println("20-sided dice roll: " + d20 + "\n");
		}
		else if (d20 == 5 || d20 == 6 || d20 == 7 || d20 == 8 || d20 == 9) {
			System.out.print("20-sided dice roll: " + d20 + "\n");
			if (d20 % 2 == 1)
				System.out.println("Roll - 1: " + (d20 - 1) + "\n");
			else
				System.out.println("Roll + 2: " + (d20 + 2) + "\n");
		}
		else if (d20 == 1 || d20 == 2 || d20 == 3 || d20 == 4) {
			System.out.println("20-sided dice roll: " + d20);
			while (d20 < 5) {
				System.out.print("Would you like to re-roll? [Y]es / [N]o: ");
				String ans = reader.nextLine();
				if (ans.equalsIgnoreCase("Y")) {
					d20 = (int)(Math.random()*20)+1;
					System.out.println("Re-roll: " + d20 + "\n");
				}
				else if (ans.equalsIgnoreCase("N"))
					break;
			}
		}

	}
}