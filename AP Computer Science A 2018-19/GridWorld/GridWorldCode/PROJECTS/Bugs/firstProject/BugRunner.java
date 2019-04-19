import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

public class BugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();

        CircleBug alice = new CircleBug(2);
        alice.setColor(Color.ORANGE);
        world.add(new Location(7, 8), alice);

        SpiralBug bob = new SpiralBug(3);
		world.add(new Location(2, 2), bob);

		ZBug mark = new ZBug(3);
        world.add(new Location(2, 5), mark);
		mark.setColor(Color.BLUE);
		world.show();

    }
}
