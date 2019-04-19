import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;

import java.awt.Color;

public class SpinBugRunner {


	public static void main(String[] args) {

		ActorWorld world = new ActorWorld();

		//alice is SpinBug with clockwise spin, starting vertically
		SpinBug alice = new SpinBug(true);
		world.add(new Location(3, 3), alice);

		//bob is SpinBug with counter-clockwise spin, starting horizontally
		SpinBug bob = new SpinBug(false);
		world.add(new Location(6, 6), bob);
		bob.setDirection(90);
		bob.setStartDirection(90);

		Rock patrick = new Rock();
		world.add(new Location(1,3), patrick);

		world.show();

	}

}