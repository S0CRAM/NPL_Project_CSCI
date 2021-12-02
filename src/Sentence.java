import java.util.ArrayList;
import java.util.Arrays;

public class Sentence {
    private String text;
    private String author;
    private String timestamp;

    public Sentence(String text, String author, String timestamp) {
        this.text = text;
        this.author = author;


//        this.timestamp = timestamp;
        // Taken from partner's file (he big brain)
        String[] splitTimestamp = timestamp.split(" ");
        this.timestamp = splitTimestamp[1] + " " + splitTimestamp[2] + " " + splitTimestamp[5];
    }

    // Taken from partner's file (He knows more than me)
    public static Sentence convertString(String line) {
        String removaExtra = line.substring(1, line.length()-1);
        String[] splitLine = removaExtra.split("\",\"");

        String text = splitLine[5];
        String author = splitLine[4];
        String timestamp = splitLine[2];

        return new Sentence(removePunctuation(text), author, timestamp);
    }
    // Taken from partner's file
    private static String removePunctuation(String text) {
        return text.replaceAll("[^a-zA-Z ]", ""); //regex from StackOverflow user Bohemian: https://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-javahttps://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-java
    }

    // Sentence splitter
    public ArrayList<String> splitSentence(String text) {
        String[] tempVar = text.split(" ");
        return new ArrayList<>(Arrays.asList(tempVar));
    }

    //    Get Set for Text
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    //    Get Set for Author
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    //    Get Set for Timestamp
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    //    Return details as string of tweet/data thingy
    public String toString() {
        return "{author: " + author + ", sentence: " + text + ", timestamp: " + timestamp + '}';
    }
}