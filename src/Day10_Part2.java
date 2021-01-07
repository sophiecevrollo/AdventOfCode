import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Day10_Part2 {
    public static void main(String[] args) {
        Set<Integer> joltages = new TreeSet<>();

        try {
            File myFile = new File("inputs/day10.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                int joltage = Integer.parseInt(line);
                joltages.add(joltage);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        int prevJoltage = 0;
        int diff1 = 0;
        int diff3 = 1; //initiated to 1 due to your built-in adapter
        for (int joltage : joltages){
            int joltageDifference = Math.abs(joltage - prevJoltage);
            System.out.println(joltage);
            if ( joltageDifference == 3){
                diff3++;
            } else if ( joltageDifference == 1){
                diff1++;
            }
            prevJoltage = joltage;
        }
        System.out.println(diff1*diff3);
    }
}
