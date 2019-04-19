//Melvin Rajendran, Nikitha Dixith

import java.util.ArrayList;

public class CardRunner {

    public static void main (String[] args) {

//Test 1
		Deck deck1 = new Deck();
		deck1.shuffle();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1 = deck1.getHand();
		ArrayList<Card> hand2 = new ArrayList<Card>();
		hand2 = deck1.getHand();

		System.out.println(deck1);
		System.out.println("Hand 1: " + hand1);
		System.out.println("Hand 2: " + hand2 + "\n");

//Test 2
		Deck deck2 = new Deck();
		deck2.shuffle();

		ArrayList<Card> hand3 = new ArrayList<Card>();
		hand3 = deck2.getHand();

		System.out.println(hand3);

		System.out.println(checkPair(hand3));

//Test 3
		/*Deck deck3 = new Deck();

		for (int i = 0; i < deck3.size(); i++)
			deck3.remove(i);

		System.out.println(deck3);*/


    }
    public static String checkPair(ArrayList<Card> hand) {
		for (int i = 0; i < hand.size(); i++) {
			for (int j = i + 1; j < hand.size(); j++) {
				if ((hand.get(i).getValue() == hand.get(j).getValue()) && (i != j))
					return "You have a pair of " + hand.get(i).getValue() + "s.";
			}
		}
		return "You do not have a pair of cards.";
	}
}