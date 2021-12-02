public class Sentence {
    private String text;
    private String author;
    private String timestamp;

    public Sentence(String text, String author, String timestamp) {
        this.text = text;
        this.author = author;

        String[] splitTimestamp = timestamp.split(" ");
        this.timestamp = splitTimestamp[1] + " " + splitTimestamp[2] + " " + splitTimestamp[5];
    }

    public static Sentence convertLine(String inputLine) {
        String trimmedInputLine = inputLine.substring(1, inputLine.length()-1);
        String[] splitInput = trimmedInputLine.split("\",\"");

        /*
        splitInput[0] = polarity
        splitInput[1] = tweet id
        splitInput[2] = timestamp
        splitInput[3] = tweet query
        splitInput[4] = author
        splitInput[5] = text
        */
        
        String text = splitInput[5];
        String author = splitInput[4];
        String timestamp = splitInput[2];

        return new Sentence(removePunctuation(text), author, timestamp);
    }

    private static String removePunctuation(String text) {
        return text.replaceAll("[^a-zA-Z ]", ""); //regex from StackOverflow user Bohemian: https://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-javahttps://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-java
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setText(String newText) {
        text = newText;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public void setTimestamp(String newTimestamp) {
        timestamp = newTimestamp;
    }
    
    public String toString() {
        return "{author:" + author + ", sentence:\"" + text + "\", timestamp:\"" + timestamp + "\"}";
    }
}
