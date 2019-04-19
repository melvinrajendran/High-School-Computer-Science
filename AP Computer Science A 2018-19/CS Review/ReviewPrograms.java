public class ReviewPrograms {
	public static void main (String[]args) {

//8
		/*for (int i = 0; i < 5; i++) {
			for (int j = i * 2; j < 10; j++) {
				System.out.print(j);
			}
			System.out.println(":" + i * 2);
		}
		System.out.println();

//9
		int dice1 = (int)(Math.random()*6)+1;
		int dice2 = (int)(Math.random()*6)+1;
		System.out.print("Dice 1: " + dice1 + "\tDice 2: " + dice2 + "\n\nSum: " + (dice1 + dice2) + "\nProduct: " + (dice1 * dice2) + "\nDifference: ");
		if (dice1 > dice2)
			System.out.println(dice1 - dice2 + "\n");
		else
			System.out.println(dice2 - dice1 + "\n");*/

//10
		int points1 = 0, points2 = 0;
		while (points1 < 20 && points2 < 20) {
			int p1d1 = (int)(Math.random()*6)+1, p1d2 = (int)(Math.random()*6)+1, p2d1 = (int)(Math.random()*6)+1, p2d2 = (int)(Math.random()*6)+1;
			System.out.println("Player 1 Roll: " + p1d1 + ", " + p1d2);
			System.out.println("Player 2 Roll: " + p2d1 + ", " + p2d2);
			if (p1d1 + p1d2 > p2d1 + p2d2)
				points1 += 3;
			else if (p1d1 + p1d2 < p2d1 + p2d2)
				points2 += 3;
			if (p1d1 > p2d1 + p2d2)
				points1 += 6;
			else if (p2d1 > p1d1 + p1d2)
				points2 += 6;
			if (p1d2 > p2d1 + p2d2)
				points1++;
			else if (p2d2 > p1d1 + p1d2)
				points2++;
			System.out.println("\nPlayer 1 Score: " + points1 + "\tPlayer 2 Score: " + points2 + "\n");

		}
		if (points1 >= 20)
			System.out.println("Player 1 wins!\n");
		else if (points2 >= 20)
			System.out.println("Player 2 wins!\n");

	}
}