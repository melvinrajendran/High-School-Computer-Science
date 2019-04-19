import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;

import java.awt.Color;

public class JumperBugRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();

        JumperBug alice = new JumperBug();
        alice.setColor(Color.ORANGE);
        JumperBug bob = new JumperBug();
        Rock rick = new Rock();

        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.add(new Location(6, 8), rick);

        world.show();
    }
}