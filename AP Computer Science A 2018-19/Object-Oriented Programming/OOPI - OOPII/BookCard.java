public class BookCard {

    private String author;
    private String title;
    private int year;

    public BookCard (String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String toString() { return "Author: " + author + "\nTitle: " + title + "\nPublication Year: " + year; }

    public String getAuthor() { return author; }

    public void setAuthor (String newAuthor) { this.author = newAuthor; }

    public String getTitle() { return title; }

    public void setTitle (String newTitle) { this.title = newTitle; }

    public int getYear() { return year; }

    public void setYear (int newYear) { this.year = newYear; }

}