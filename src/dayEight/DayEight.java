package dayEight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayEight {

    private static String[] operations;

    public void readFile(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayTwo/passwords.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                if (line != null) {
                    entries.add(line);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
