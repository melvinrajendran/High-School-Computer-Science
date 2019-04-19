import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class TriangleBugRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		TriangleBug alice = new TriangleBug();
		alice.setColor(Color.ORANGE);
		TriangleBug bob = new TriangleBug(3);
		world.add(new Location(8, 1), alice);
		world.add(new Location(3, 5), bob);
		world.show();
	}

}