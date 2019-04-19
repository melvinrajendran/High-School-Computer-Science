import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

public class EmperorPalpatineRunner {

	public static void main(String[] args) {

		ActorWorld world = new ActorWorld();

		world.add(new Location(3, 2), new Rock());
		world.add(new Location(7, 8), new Ash());
		world.add(new Location(4, 4), new EmperorPalpatineCritter());

		world.show();
	}

}