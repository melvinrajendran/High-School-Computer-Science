import java.util.ArrayList;

public class OOPI {

    public static void main(String[] args) {

//2
        ArrayList<String> authorList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<Integer> yearList = new ArrayList<>();

        authorList.add("Dr. Seuss");
		authorList.add("J.K. Rowling");
		authorList.add("Edith Wharton");
		authorList.add("Charles Dickens");
		authorList.add("William Shakespeare");

		titleList.add("The Cat in the Hat");
		titleList.add("Harry Potter and the Sorceror's Stone");
		titleList.add("Ethan Frome");
		titleList.add("Oliver Twist");
		titleList.add("Romeo and Juliet");

		yearList.add(1973);
		yearList.add(1997);
		yearList.add(1911);
		yearList.add(1838);
		yearList.add(1597);

		ArrayList<BookCard> bookCardList = new ArrayList<>();

		for (int i = 0; i < authorList.size(); i++) {
			int rAuthor = (int)(Math.random()*5), rTitle = (int)(Math.random()*5), rYear = (int)(Math.random()*5);
			bookCardList.add(new BookCard(authorList.get(rAuthor), titleList.get(rTitle), yearList.get(rYear)));
			System.out.println(bookCardList.get(i) + "\n");
		}

		recentCard(bookCardList);

    }
//3.1
    public static BookCard recentCard (ArrayList list) {

		int recentYear = 0, iRecentCard = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getYear() > recentYear) {
				recentYear = list.get(i).getYear();
				iRecentCard = i;
			}
		}
		return list.get(iRecentCard);

	}
//3.2
	//public static void stringSearch (ArrayList list, String item) {

	//}

}
