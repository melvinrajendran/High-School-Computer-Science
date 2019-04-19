public class Random_MelvinRajendran {
	public static void main (String[]args) {

		int rando1 = (int)(Math.random()*19);
		int rando2 = (int)(Math.random()*13)-8;
		int rando3 = (int)(Math.random()*17)+10;
		int rando4 = (int)(Math.random()*56)+37;
		int rando5 = (int)(Math.random()*46)+43;

		int randosum = (int)(rando1 + rando2 + rando3 + rando4 + rando5);
		double randoavg = (double)(randosum / 5.0);

		System.out.println("Random # 1: " + rando1);
		System.out.println("Random # 2: " + rando2);
		System.out.println("Random # 3: " + rando3);
		System.out.println("Random # 4: " + rando4);
		System.out.println("Random # 5: " + rando5 + "\n");
		System.out.println("Sum = " + randosum);
		System.out.println("Average = " + randoavg + "\n");

	}
}