import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("testdata.manual.2009.06.14.csv"));
        sc.useDelimiter("\n");

        ArrayList<Sentence> data = new ArrayList<Sentence>();

        while(sc.hasNext()) {
            Sentence s = Sentence.convertLine(sc.next());
            System.out.println(s);
            data.add(s);
        }
        sc.close();
    }

    
}
