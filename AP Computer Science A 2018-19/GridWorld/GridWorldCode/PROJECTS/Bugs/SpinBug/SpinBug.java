import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class SpinBug extends Bug {

	private boolean spinDirection;
	private int spin;
	private int startDirection;


	public SpinBug(boolean spinDirection) {
		this.spinDirection = spinDirection;
		this.spin = 0;
		this.startDirection = getDirection();
	}

	public void act() {
		if (canMove() && spin == 0) {
			move();
			spin++;
		}
		else if (spin == 1) {
			if (spinDirection == true) {
				turn();
				spin++;
			}
			else {
				counterTurn();
				spin++;
			}
		}
		else if (spin > 1 && spin < 8) {
			if (spinDirection == true && spin < 8 && startDirection != getDirection()) {
				turn();
				spin++;
			}
			else if (spinDirection == false && spin < 8 && startDirection != getDirection()) {
				counterTurn();
				spin++;
			}
		}
		else {
			spin = 0;
			if (spinDirection == true)
				turn();
			else
				counterTurn();
			startDirection = getDirection();
		}
	}

	public void counterTurn() {
		setDirection(getDirection() - 45);
	}

	public void setStartDirection(int newStartDirection) {
		this.startDirection = newStartDirection;
	}

}