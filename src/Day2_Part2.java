import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2_Part2 {

    public static void main(String[] args) {
        int valid = 0;
        try {
            File myFile = new File("inputs/day2.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                String[] policy = parts[0].split("-");
                Character rule = parts[1].charAt(0);

                if(parts[2].length() > Integer.valueOf(policy[1])-1){
                    if (parts[2].charAt(Integer.valueOf(policy[0])-1) == rule ^ parts[2].charAt(Integer.valueOf(policy[1])-1) == rule ) {
                        valid++;
                    }
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
