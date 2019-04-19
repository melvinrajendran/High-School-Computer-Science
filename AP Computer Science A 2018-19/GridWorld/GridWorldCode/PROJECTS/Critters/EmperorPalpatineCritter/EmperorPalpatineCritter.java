import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

import info.gridworld.grid.Location;

import java.util.ArrayList;

import java.awt.Color;

public class EmperorPalpatineCritter extends Critter {

	public EmperorPalpatineCritter() {
		setColor(null);
	}

	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<>();

		Location loc = getLocation();
		Location adj = loc.getAdjacentLocation(getDirection());

		while (getGrid().isValid(adj)) {
			if (getGrid().get(adj) instanceof Actor) {
				actors.add(getGrid().get(adj));
				break;
			}
			else {
				loc = loc.getAdjacentLocation(getDirection());
				adj = loc.getAdjacentLocation(getDirection());
			}
		}

		return actors;
	}

	public void processActors(ArrayList<Actor> actors) {
		if (actors.size() == 0)
			return;
		for (Actor a : actors) {
			Location loc = a.getLocation();
			Ash ash = new Ash();
			ash.putSelfInGrid(getGrid(), loc);
		}
	}

	public void makeMove(Location loc) {
		setDirection(getLocation().getDirectionToward(loc));
		super.makeMove(loc);
	}

}