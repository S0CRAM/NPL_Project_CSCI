public class Sentence {
    private String text;
    private String author;
    private String timestamp;

    public Sentence(String text, String author, String timestamp) {
        this.text = text;
        this.author = author;
        this.timestamp = timestamp;

    }
    //    Get Set for Text
    public String getText() {return text;}
    public String setText(String text) {this.text = text;
        return this.text;
    }
    //    Get Set for Author
    public String getAuthor() {return author;}
    public String setAuthor(String author) {this.author = author;
        return this.author;
    }
    //    Get Set for Timestamp
    public String getTimestamp() {return timestamp;}
    public String setTimestamp(String timestamp) {this.timestamp = timestamp;
        return this.timestamp;
    }
    //    Return details as string of tweet/data thingy
    public String toString() {
        return "{author: " + author + ", sentence: " + text + ", timestamp: " + timestamp + '}';
    }
}