import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {
        int valid = 0;
        try {
            File myFile = new File("inputs/day2.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                String[] policy = parts[0].split("-");
                Character rule = parts[1].charAt(0);
                int charCount = 0;

                for (int i = 0; i < parts[2].length(); i++) {
                    if (parts[2].charAt(i) == rule) {
                        charCount++;
                    }
                }
                if (charCount >= Integer.valueOf(policy[0]) && charCount <= Integer.valueOf(policy[1])) {
                    valid++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        System.out.println(valid);
    }
}
