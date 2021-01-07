import java.io.File;
import java.util.*;

public class Day6_Part2 {
    public static void main(String[] args) throws Exception {
        Map<Character, Integer> groupAnswers = new HashMap<>();
        int sumCounts = 0;
        int groupSize = 0;

        File myFile = new File("inputs/day6.txt");
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if( line.length() != 0) {
                groupSize++;
                for ( int i = 0; i < line.length(); i++){
                    if ( groupAnswers.get(line.charAt(i))!= null) {
                        groupAnswers.put(line.charAt(i), groupAnswers.get(line.charAt(i))+1);
                    } else {
                        groupAnswers.put(line.charAt(i), 1);
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
