import info.gridworld.actor.Bug;

public class ZBug extends Bug {

	private int steps;
	private int sideLength;
	private int lines;

	public ZBug(int sideLength) {
		this.steps = 0;
		this.sideLength = sideLength;
		this.lines = 1;
		this.setDirection(90);
	}

	public void act() {
		if (canMove()) {
			if (steps < sideLength && lines <= 3) {
				move();
				steps++;
			}
			else {
				if (lines != 3 && getDirection() == 90) {
					for (int i = 0; i < 3; i++)
						turn();
					lines++;
					steps = 0;
				}
				else if (lines != 3 && getDirection() == 225) {
					for (int i = 0; i < 5; i++)
						turn();
					lines++;
					steps = 0;
				}
			}
		}
	}

}