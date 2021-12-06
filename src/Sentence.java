import java.util.ArrayList;

public class Sentence {
    private String text;
    private String author;
    private String timestamp;
    private ArrayList<String> list;

    public Sentence(String text, String author, String timestamp) {
        this.text = text;
        this.author = author;
        this.list = new ArrayList<>();
        this.list.addAll(this.splitSentence());

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
    public ArrayList<String> splitSentence() {
        String[] stopwords = {"a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at", "be", "because", "been", "before", "being", "below", "between", "both", "but", "by", "can't", "cannot", "could", "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during", "each", "few", "for", "from", "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll", "he's", "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its", "itself", "let's", "me", "more", "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought", "our", "ours ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should", "shouldn't", "so", "some", "such", "than", "that", "that's", "the", "their", "theirs", "them", "themselves", "then", "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've", "this", "those", "through", "to", "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were", "weren't", "what", "what's", "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom", "why", "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours", "yourself", "yourselves"}; //from https://www.ranks.nl/stopwords
        // This part removes punctuations from stopword using the function made by Mark (partner)
        int cnt = 0;
        for(String i: stopwords) {
            String remo = removePunctuation(i);
            stopwords[cnt] = remo;
            cnt++;
        }
        // Main part of the method
        String[] tempVar = text.split(" "); // TempVar holds the split sentence
        ArrayList<String> finalList = new ArrayList<>(); // This is the list we'll return at the end

        // For loop goes through the split words of the sentence, and checks if they're in stop word list
        for(String i : tempVar) {
            boolean ToF = true;
            for(String j: stopwords) {
                if (i.toLowerCase().equals(j)) {
                    ToF = false;
                    break;
                }
                else if(i.isEmpty()) {
                    ToF = false;
                    break;
                }
            }
            if(ToF) {
                finalList.add(i.toLowerCase());
            }
        }
        return finalList;
    }

    public ArrayList<String[]> bigrams(String[] sentence) { // From stackoverflow user Dan Zheng on https://stackoverflow.com/a/40777617
        ArrayList<String[]> twgrams = new ArrayList<>();
        for(int i=0; i < sentence.length; i++) {
            for(int j=i+1; j< sentence.length; j++) {
                twgrams.add(new String[]{sentence[i],sentence[j]});
            }
        }
        return twgrams;
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

    //    Get List
    public ArrayList<String> getList() {
        return list;
    }

    //    Return details as string of tweet/data thingy
    public String toString() {
        return "{author: " + author + ", sentence: " + text + ", timestamp: " + timestamp + '}';
    }
}