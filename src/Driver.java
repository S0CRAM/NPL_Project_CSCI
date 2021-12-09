// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Program
public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner twt = new Scanner(new File("testdata.manual.2009.06.14.csv"));
        twt.useDelimiter("\n");
        ArrayList<String[]> temp = new ArrayList<>();
        while (twt.hasNext()) {
            Sentence tweet = Sentence.convertString(twt.next());
            temp.addAll(tweet.getList());
        }
        twt.close();

        HashMap<String, Integer> mappy = new HashMap<>();
        for(String[] i: temp) {
            String j = Arrays.toString(i);
            if(mappy.containsKey(j)) {
                mappy.replace(j,mappy.get(j)+1);
            }
            else {
                mappy.put(j, 1);
            }
        }

        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : mappy.entrySet())
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                maxEntry = entry;
        int maxValueLen = maxEntry.getValue().toString().length();
        ArrayList <String> results = new ArrayList<String>();
        for (Map.Entry set : mappy.entrySet()){
            String value = set.getValue().toString();
            while(value.length() < maxValueLen)
                value = " " + value;
            results.add(value + " of " + set.getKey());
        }
        Collections.sort(results);
        Collections.reverse(results);
        for (int i = 0; i < 100; i++)
            System.out.println(results.get(i));
    }
}