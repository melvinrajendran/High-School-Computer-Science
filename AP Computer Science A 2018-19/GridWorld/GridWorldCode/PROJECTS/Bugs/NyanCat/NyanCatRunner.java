import info.gridworld.grid.Location;

import info.gridworld.actor.ActorWorld;

import java.awt.Color;

public class NyanCatRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
        NyanCat cat = new NyanCat();
        Rainbow rainbow = new Rainbow();
        world.add(new Location(7, 8), cat);
        //world.add(new Location(5, 4), rainbow);
        world.show();
    }
}