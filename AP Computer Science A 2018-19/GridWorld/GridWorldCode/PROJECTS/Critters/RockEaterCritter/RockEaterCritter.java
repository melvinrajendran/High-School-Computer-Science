import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

import info.gridworld.grid.Location;

import java.util.ArrayList;

import java.awt.Color;

public class RockEaterCritter extends Critter {

	public static int rocksEaten;

	public RockEaterCritter() {
		setColor(new Color(102, 51, 0));
	}

	public ArrayList<Actor> getActors() {
		return getGrid().getNeighbors(getLocation());
	}

	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors){
			if (a instanceof Rock) {
				a.removeSelfFromGrid();
				rocksEaten++;
			}
		}
		if (rocksEaten % 10 == 0 && rocksEaten != 0) {
			Rock r1 = new Rock(new Color(128, 0, 128));

			Location back = getLocation().getAdjacentLocation(getDirection() + 180);
			Location front = getLocation().getAdjacentLocation(getDirection());
			Location left = getLocation().getAdjacentLocation(getDirection() - 90);
			Location right = getLocation().getAdjacentLocation(getDirection() + 90);

			if (getGrid().isValid(back))
				r1.putSelfInGrid(getGrid(), back);
			else if (getGrid().isValid(front))
				r1.putSelfInGrid(getGrid(), front);
			else if (getGrid().isValid(left))
				r1.putSelfInGrid(getGrid(), left);
			else
				r1.putSelfInGrid(getGrid(), right);

			rocksEaten = 0;
		}
	}

	public void makeMove(Location loc) {
		setDirection(getLocation().getDirectionToward(loc));
		super.makeMove(loc);
	}

}