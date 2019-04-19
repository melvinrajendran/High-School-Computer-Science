import info.gridworld.actor.Bug;

public class TriangleBug extends Bug {

	private int steps;
	private int side;
	private int sideLength;

	public TriangleBug() {
		this.steps = 0;
		this.side = 1;
		this.sideLength = 4;
		this.setDirection(45);
	}

	public TriangleBug(int sideLength) {
		this.steps = 0;
		this.side = 1;
		this.sideLength = sideLength;
		this.setDirection(45);
	}

	public void act() {
		if (side == 1) {
			if (steps < sideLength - 1) {
				steps++;
				move();
			}
			else {
				side++;
				steps = 0;
			}
		}
		else if (side == 2) {
			if (getDirection() != 135)
				turn();
			else {
				if (steps < sideLength - 1) {
					steps++;
					move();
				}
				else {
					side++;
					steps = 0;
				}
			}
		}
		else if (side == 3) {
			if (getDirection() != 270)
				turn();
			else {
				if (steps < 2 * sideLength - 2) {
					steps++;
					move();
				}
				else {
					side = -1;
					steps = 0;
				}
			}
		}
		else {
			if (getDirection() != 45)
				turn();
			else {
				side = 1;
				steps = 0;
			}
		}

	}

}