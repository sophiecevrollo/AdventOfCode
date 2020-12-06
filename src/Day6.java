import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day6 {
    public static void main(String[] args) {
        Set<Character> groupAnswers = new HashSet<> ();
        int sumCounts = 0;

        try {
            File myFile = new File("inputs/day6.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNext()) {
                String[] lines = scanner.nextLine().split("\n\n\n\n");
                if( lines[0].length() != 0) {
                    for (String part : lines) {
                        for ( int i = 0; i < part.length(); i++){
                            groupAnswers.add(part.charAt(i));
                        }
                    }
                } else {
                    sumCounts += groupAnswers.size();
                    groupAnswers.clear();
                }
            }
            sumCounts += groupAnswers.size();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        System.out.println(sumCounts);
    }

}
