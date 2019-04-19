public class RandomNumbers {
	public static void main (String[]args) {

		/*double num = Math.random()*10;
		System.out.println(num);

		int rando = (int)(Math.random()*10)+1;
		System.out.println(rando);

//Practice I

		int rando = (int)(Math.random()*5)+1;
		System.out.println(rando);

		int rando = (int)(Math.random()*6);
		System.out.println(rando);

		int rando = (int)(Math.random()*11);
		System.out.println(rando);

		int rando = (int)(Math.random()*6)+5;
		System.out.println(rando);

		int rando = (int)(Math.random()*11)+10;
		System.out.println(rando);

		int rando = (int)(Math.random()*11)-5;
		System.out.println(rando);

//Practice II

		int rando1 = (int)(Math.random()*20)+1;
		int rando2 = (int)(Math.random()*13)+6;
		int rando3 = (int)(Math.random()*177)+38;

		int randosum = (rando1 + rando2 + rando3);
		double randoavg = (double)(randosum/3);
		int randoquotient = (rando1/rando2);
		int randoremainder = (rando3%rando1);

		System.out.println("First number: " + rando1 + "\n");
		System.out.println("Second number: " + rando2 + "\n");
		System.out.println("Third number: " + rando3 + "\n");
		System.out.println("Sum of numbers: " + randosum + "\n");
		System.out.println("Average of numbers: " + randoavg + "\n");
		System.out.println("Quotient of first/second: " + randoquotient + "\n");
		System.out.println("Remainder of third%first: " + randoremainder + "\n");

//Practice III

		int dice1 = (int)(Math.random()*6)+1;
		int dice2 = (int)(Math.random()*10)+1;
		int dice3 = (int)(Math.random()*20)+1;

		int dicesum = (int)(dice1 + dice2 + dice3);
		int diceprod = (int)(dice1 * dice2 * dice3);
		double diceavg = (double)(dicesum/3);

		System.out.println("6-Sided Die: " + dice1 + "\n");
		System.out.println("10-Sided Die: " + dice2 + "\n");
		System.out.println("20-Sided Die: " + dice3 + "\n");
		System.out.println("Sum of Dice: " + dicesum + "\n");
		System.out.println("Product of Dice: " + diceprod + "\n");
		System.out.println("Average of Dice: " + diceavg + "\n");*/

//Practice IV

		int seconds = (int)(Math.random()*999501)+500;
		int days = (seconds / 86400);
		int hours = ((seconds - (days * 86400)) / 3600);
		int minutes = ((seconds - (days * 86400 + hours * 3600)) / 60);
		int secondsrem = ((seconds - (days * 86400 + hours * 3600 + minutes * 60)) % 60);

		System.out.println("Total Seconds: " + seconds + "\n");
		System.out.println((days) + " days : " + (hours) + " hours : " + (minutes) + " minutes : " + (secondsrem) + " seconds \n");

	}
}