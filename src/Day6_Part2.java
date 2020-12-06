import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6_Part2 {
    public static void main(String[] args) {
        Map<Character, Integer> groupAnswers = new HashMap<>();
        int sumCounts = 0;
        int groupSize = 0;

        try {
            File myFile = new File("inputs/day6.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNext()) {
                String[] lines = scanner.nextLine().split("\n\n\n\n");
                if( lines[0].length() != 0) {
                    groupSize++;
                    for (String part : lines) {
                        for ( int i = 0; i < part.length(); i++){
                            if ( groupAnswers.get(part.charAt(i))!= null) {
                                groupAnswers.put(part.charAt(i), groupAnswers.get(part.charAt(i))+1);
                            } else {
                                groupAnswers.put(part.charAt(i), 1);
                            }
                        }
                    }
                } else {
                    sumCounts += countAnswers(groupAnswers, groupSize);
                    groupAnswers.clear();
                    groupSize = 0;
                }
            }
            sumCounts += countAnswers(groupAnswers, groupSize);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        System.out.println(sumCounts);
    }

    public static int countAnswers(Map<Character, Integer> groupAnswers, int groupSize){
        int sumCounts = 0;
        for (Map.Entry<Character, Integer> entry : groupAnswers.entrySet()) {
            if ( entry.getValue() == groupSize ){
                sumCounts++;
            }
        }
        return sumCounts;
    }
}
