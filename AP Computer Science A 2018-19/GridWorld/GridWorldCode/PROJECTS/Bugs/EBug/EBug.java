import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class EBug extends Bug {

	private int steps;
	private int totalSteps;
	private int length;

	public EBug() {
		this.steps = 0;
		this.totalSteps = 0;
		this.length = 2;
		this.setDirection(90);
	}

	public void act() {
		if (totalSteps < 20) {
			if (getDirection() == 90) {
				if (steps < length) {
					move();
					steps++;
				}
				else {
					setDirection(270);
					steps = 0;
				}
			}
			else if (getDirection() == 0) {
				if (steps < length && canMove()) {
					move();
					steps++;
				}
				else {
					setDirection(90);
					steps = 0;
				}
			}
			else if (getDirection() == 270) {
				if (steps < length && canMove()) {
					move();
					steps++;
				}
				else {
					setDirection(0);
					steps = 0;
				}
			}
			totalSteps++;
		}
		else
			steps = length++;
		}

}