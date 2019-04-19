public class OOPReview {

    public static void main (String[] args) {

        XWing starFighter = new XWing(100, "Luke Skywalker", 100);
        starFighter.fireCannon();

        starFighter = new XWing(50);
        starFighter.fireCannon();

    }
}