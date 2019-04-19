import java.util.ArrayList;

public class DiceHolder {

	private ArrayList<Die> container;

	public DiceHolder() {
		this.container = new ArrayList<Die>();
	}

	public int addDie(Die die) {
		if (container.size() < 6) {
			container.add(die);
			return 1;
		}
		else
			return -1;
	}

	public void shake() {
		for (int i = 0; i < container.size(); i++) {
			container.get(i).roll();
		}
	}

	public String toString() {
		String x = "";
		for (int i = 0; i < container.size(); i++)
			x += "Dice " + (i + 1) + ": " + container.get(i).toString() + "\n";
		return x;
	}

}