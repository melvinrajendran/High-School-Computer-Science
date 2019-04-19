import java.util.ArrayList;
import java.util.Collections;

public class PokemonRunner {

	public static void main (String [] args) {

		ArrayList<Pokemon> list = new ArrayList<Pokemon>();

		list.add(new Pokemon("Pikachu", 90));
		list.add(new Pokemon("Bulbasaur", 50));
		list.add(new Pokemon("Ivysaur", 80));
		list.add(new Pokemon("Venusaur", 100));
		list.add(new Pokemon("Charmander", 60));
		list.add(new Pokemon("Charmeleon", 105));
		list.add(new Pokemon("Charizard", 140));
		list.add(new Pokemon("Squirtle", 60));
		list.add(new Pokemon("Wartortle", 95));
		list.add(new Pokemon("Blastoise", 120));

		System.out.println(Collections.sort(list));

	}

}