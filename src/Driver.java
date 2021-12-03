// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import java.util.Map; //place with imports
import java.util.Collections; //place with imports

// Program
public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner twt = new Scanner(new File("./twitter.csv")); // the ./ allows us to move up a folder
        twt.useDelimiter("\n");
        ArrayList<String> temp = new ArrayList<>();
        while (twt.hasNext()) {
            Sentence tweet = Sentence.convertString(twt.next());
            temp.addAll(tweet.getList());
//            System.out.println(twt.next());
        }
        twt.close();
        System.out.println(temp);
        HashMap<String, Integer> mappy = new HashMap<>();

        for(String i: temp) {
            if(mappy.containsKey(i)) {
                mappy.replace(i,mappy.get(i)+1);
            }
            else {
                mappy.put(i, 1);
            }
        }
//        System.out.println(mappy);
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