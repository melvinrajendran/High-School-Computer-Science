import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;

public class NyanCat extends Bug {

	public NyanCat() {
		setColor(null);
	}

	public void act() {
		if (canMove())
			move();
		else
			turn();
	}

	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (gr.isValid(next))
			moveTo(next);
		else
			removeSelfFromGrid();
		Rainbow rainbow = new Rainbow();
		rainbow.putSelfInGrid(gr, loc);
		rainbow.setDirection(getDirection());
	}

	public boolean canMove() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;
		return true;
	}

}