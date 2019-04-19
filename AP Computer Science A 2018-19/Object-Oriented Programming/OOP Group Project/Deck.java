import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                for (int j = 2; j <= 14; j++)
                    this.deck.add(new Card(j, "Spades"));
            }
            else if (i == 1) {
                for (int j = 2; j <= 14; j++)
                    this.deck.add(new Card(j, "Diamonds"));
            }
            else if (i == 2) {
                for (int j = 2; j <= 14; j++)
                    this.deck.add(new Card(j, "Clubs"));
            }
            else {
                for (int j = 2; j <= 14; j++)
                    this.deck.add(new Card(j, "Hearts"));
            }
        }
    }

    public ArrayList<Card> getHand() {
        ArrayList<Card> hand = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            hand.add(deck.get(i));
            deck.remove(i);
        }

        return hand;
    }

    public void shuffle() {
        for (int i = 0; i < 50; i++) {
            int iCard = (int)(Math.random()*52), newIndex = (int)(Math.random()*52);
            while (newIndex == iCard)
                newIndex = (int)(Math.random()*52);
            Card temp = deck.get(iCard);
            deck.set(iCard, deck.get(newIndex));
            deck.set(newIndex, temp);
        }
    }

    public String toString() {
        String S = "";
        for (int i = 1; i <= deck.size(); i++)
            S += i + " - " + deck.get(i-1).toString() + "\n";
        return S;
    }

}