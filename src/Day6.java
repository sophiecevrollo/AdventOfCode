import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day6 {
    public static void main(String[] args) throws Exception {
        Set<Character> groupAnswers = new HashSet<> ();
        int sumCounts = 0;

        File myFile = new File("inputs/day6.txt");
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if( line.length() != 0) {
                for ( int i = 0; i < line.length(); i++){
                    groupAnswers.add(line.charAt(i));
                }
            } else {
                sumCounts += groupAnswers.size();
                groupAnswers.clear();
            }
        }
        sumCounts += groupAnswers.size();
        scanner.close();
        System.out.println(sumCounts);
    }
}
