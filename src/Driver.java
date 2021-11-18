// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Program
public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner twt = new Scanner(new File("./twitter.csv"));
        twt.useDelimiter("\n");
        while (twt.hasNext()) {
            System.out.println(twt.next());
        }
        twt.close();
    } // the ./ allows us to move up a folder
}