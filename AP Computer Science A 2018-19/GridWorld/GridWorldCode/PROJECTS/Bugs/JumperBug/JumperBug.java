import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Bug;

public class JumperBug extends Bug {

	public JumperBug() {

	}

	public void act() {
		if (canMove())
			move();
		else if (canJump())
			jump();
		else
			turn();
	}

	public boolean canJump() {
		Grid<Actor> g = getGrid();

		Location currentLocation = getLocation();
		Location obstruction = currentLocation.getAdjacentLocation(getDirection());
		Location jumpLocation = obstruction.getAdjacentLocation(getDirection());

		if (g.isValid(jumpLocation) && ((g.get(jumpLocation) instanceof Flower) || (g.get(jumpLocation) == null)))
			return true;
		else
			return false;
	}

	public void jump() {
		Grid<Actor> g = getGrid();

		Location currentLocation = getLocation();
		Location obstruction = currentLocation.getAdjacentLocation(getDirection());
		Location jumpLocation = obstruction.getAdjacentLocation(getDirection());

		moveTo(jumpLocation);

		Flower f = new Flower(getColor());
		f.putSelfInGrid(g, currentLocation);
	}

}