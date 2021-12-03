import java.util.ArrayList;
import java.util.HashMap;

public class ExtractTest {
    public static void main(String[] args) throws Exception{
        String commaTweet = "\"4\",\"3\",\"Mon May 11 03:17:40 UTC 2009\",\"kindle2\",\"TestAuthor\",\"The Grill, The Chill, The Thrill!@#%\"";
        Sentence check = new Sentence("The Grill The Chill The Thrill", "TestAuthor", "Mon May 11 03:17:40 UTC 2009");
        System.out.println("Correct Sentence: " + check);
        Sentence test = Sentence.convertString(commaTweet);
        System.out.println("Test Sentence: " + test);
        System.out.println("TEST CASE 1: " + test.toString().equals(check.toString()));

        System.out.println(test.getList());
//        HashMap<String, Integer> mappy = new HashMap<>();


    }
}