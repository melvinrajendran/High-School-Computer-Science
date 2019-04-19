import java.util.Scanner;
public class IfElsePracticeIV {
	public static void main (String[]args) {

	Scanner reader = new Scanner (System.in);

	int weight = (int)(Math.random()*211)+70;
	System.out.println("The person's weight is " + weight + ".");
	int life = (int)(Math.random()*2)+1;
	if (life == 1)
		System.out.println("The person has an active lifestyle.");
	else
		System.out.println("The person has a sedentary lifestyle.");
	if (life == 1)
		System.out.println("The recommended calories for the active person is " + (active(weight)) + " calories.\n");
	else if (life == 2)
		System.out.println("The recommended calories for the sedentary person is " + (sedentary(weight)) + " calories.\n");

	}
	public static int active (int c){
		int d = c * 15;
		return d;

	}
	public static int sedentary (int e){
		int f = e * 13;
		return f;

	}
}