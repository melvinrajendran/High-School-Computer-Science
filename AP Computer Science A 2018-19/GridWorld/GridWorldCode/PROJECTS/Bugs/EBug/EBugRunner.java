import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class EBugRunner {

	public static void main (String[] args) {

		ActorWorld world = new ActorWorld();
		EBug alice = new EBug();

		world.add(new Location(4, 4), alice);
		world.show();

	}
}