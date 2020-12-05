import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day1_Part2 {
    public static void main(String[] args) {
        Set<Integer> values = loadData("inputs/day1.txt");

        for (Integer firstNum : values) {
            for(Integer secondNum : values){
                int required =  2020 - secondNum - firstNum;
                if (values.contains(required)) {
                    System.out.println( firstNum * secondNum * required);
                    return;
                }
            }
    }
}

    public static Set<Integer> loadData (String fileName) {
        Set<Integer> values = new HashSet<>();

        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                values.add(Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        return values;
    }
}
