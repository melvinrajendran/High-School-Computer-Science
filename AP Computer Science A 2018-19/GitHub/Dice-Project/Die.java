public class Die {

	private int sides;
	private int value;

	public Die() {
		this.sides = 6;
		this.value = (int)(Math.random()*6)+1;
	}

	public Die(int sides) {
		this.sides = sides;
		this.value = (int)(Math.random()*sides)+1;
	}

	public int getValue(){
		return value;
	}

	public void roll(){
		value = (int)(Math.random()*sides)+1;
	}

	public String toString(){
		return "Number of sides: " + sides + ", Value: " + value;
	}

}