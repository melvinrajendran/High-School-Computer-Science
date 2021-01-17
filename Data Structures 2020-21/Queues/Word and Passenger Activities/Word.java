import javax.lang.model.util.ElementScanner6;

public class Word implements Comparable<Word> {
    private String text;

    public Word(String text) {
        this.text = text;
    }

    public String getText() { return text; }

    public int getLength() { return text.length(); }

    public int compareTo(Word other) { return -1 * text.compareTo(other.getText()); }

    public String toString() { return text; }
}