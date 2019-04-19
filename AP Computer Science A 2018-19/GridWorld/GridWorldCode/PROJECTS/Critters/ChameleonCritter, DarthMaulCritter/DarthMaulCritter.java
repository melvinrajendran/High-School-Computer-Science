import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.util.ArrayList;

import java.awt.Color;

public class DarthMaulCritter extends Critter {

	public DarthMaulCritter() {
		setColor(null);
	}

	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<>();
		Location left = getLocation().getAdjacentLocation(getDirection() - 90);
		Location right = getLocation().getAdjacentLocation(getDirection() + 90);
		if (getGrid().isValid(left) && getGrid().get(left) != null)
			actors.add(getGrid().get(left));
		if (getGrid().isValid(right) && getGrid().get(right) != null)
			actors.add(getGrid().get(right));
		return actors;
	}

	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
			if (!(a instanceof Critter))
				a.removeSelfFromGrid();
		}
	}

	public void makeMove(Location loc) {
		setDirection(getLocation().getDirectionToward(loc));
		super.makeMove(loc);
	}

}