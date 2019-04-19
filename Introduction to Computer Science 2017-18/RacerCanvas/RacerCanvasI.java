public class RacerCanvas1 {
	public static void main (String[]args) {

		RacerCanvas race = new RacerCanvas(800,800); //sets size of canvas to be 800 by 800 pixels
		race.setFiles("Flash.png_c200","Batman.png","Superman.png");
		race.moveRacer1(0 , 50);
		race.moveRacer2(0 , 300);
		race.moveRacer3(0 , 550); //starting positions of racers, evenly spaced vertically
		int flash = 0;
		int batman = 0;
		int superman = 0; //race win counters for each of the racers

		for (int i = 1; i <= 3; i++) {
			double a = (Math.random()*10)+1;
			double b = (Math.random()*10)+1;
			double c = (Math.random()*10)+1;
			while ((a == b) || (b == c) || (a == c)) {
				a = (Math.random()*10)+1;
				b = (Math.random()*10)+1;
				c = (Math.random()*10)+1; //three variables a, b, and c are randomly generated between 1 and 11, and are added to the positions of the races with each iteration of the following while loop
										  //they cannot hold the same value because of the while loop that reinitializes them if any of them are the same
			}
			int x1 = 0;
			int x2 = 0;
			int x3 = 0; //initial positions of racers at start of each race
			while ((x1 < 580) || (x2 < 580) || (x3 < 580)) {
				if (x1 < 580)
					x1 += a;
				if (x2 < 580)
					x2 += b;
				if (x3 < 580)
					x3 += c; //each racer moves at a randomly generated speed across the screen to its edge
				race.moveRacer1(x1 , 50);
				race.moveRacer2(x2 , 300);
				race.moveRacer3(x3 , 550);
				race.delay(20); //delay to make it so that the race is visibly moving, not too fast/slow
				race.repaint();
			}
			if ((a > b) && (b > c)) {
				race.setPlaces("1st: Flash   2nd: Batman   3rd: Superman", 50, 100, 30);
				flash++;
			}
			else if ((a > c) && (c > b)) {
				race.setPlaces("1st: Flash   2nd: Superman   3rd: Batman", 50, 100, 30);
				flash++;
			}
			else if ((b > a) && (a > c)) {
				race.setPlaces("1st: Batman   2nd: Flash   3rd: Superman", 50, 100, 30);
				batman++;
			}
			else if ((b > c) && (c > a)) {
				race.setPlaces("1st: Batman   2nd: Superman   3rd: Flash", 50, 100, 30);
				batman++;
			}
			else if ((c > a) && (a > b)) {
				race.setPlaces("1st: Superman   2nd: Flash   3rd: Batman", 50, 100, 30);
				superman++;
			}
			else if ((c > b) && (b > a)) {
				race.setPlaces("1st: Superman   2nd: Batman   3rd: Flash", 50, 100, 30);
				superman++;
			}
			race.showText(true);
			race.delay(5000);
			race.showText(false);
			race.repaint(); //compares randomly generated numbers of each racer to determine which one wins the race, which ones get second and third place, displays places of each racer for every race
		}
		if (flash > batman) {
			if (flash > superman) {
				race.setPlaces("Flash wins the game!", 200, 100, 30);
			}
			else if (flash < superman) {
				race.setPlaces("Superman wins the game!", 200, 100, 30);
			}
		}
		else if (batman > flash) {
			if (batman > superman) {
				race.setPlaces("Batman wins the game!", 200, 100, 30);
			}
			else if (batman < superman) {
				race.setPlaces("Superman wins the game!", 200, 100, 30);
			}
		}
		else if (superman > flash) {
			if (superman > batman) {
				race.setPlaces("Superman wins the game!", 200, 100, 30);
			}
			else if (superman < batman) {
				race.setPlaces("Batman wins the game!", 200, 100, 30);
			}
		}
		else if ((flash == batman) && (batman == superman) && (flash == superman)) {
			race.setPlaces("All three racers tie!", 200, 100, 30);
		}
		race.showText(true); //compares the race wins of each of the racers to determine who wins the game, or whether there is a three-way tie (because all three won a race), displays winner
	}
}