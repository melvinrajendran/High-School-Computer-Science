public class Card {

    private int value; //numerical value of card
    private String suit;

    public Card() { //creates Joker card
        this.value = 0;
        this.suit = "";
    }

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() { return value; }

    public String getSuit() { return suit; }

    public String getFaceValue(){
        if ((value <= 10) && (value != 0))
            return value + "";
        else if (value == 11)
            return "Jack";
        else if (value == 12)
            return "Queen";
        else if (value == 13)
            return "King";
        else if (value == 14)
            return "Ace";
        else
            return "Joker";
    }

    public String toString() {
        if (!(getFaceValue().equals("Joker")))
            return getFaceValue() + " of " + getSuit();
        else
            return getFaceValue();
    }

}