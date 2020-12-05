import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5 {
    public static void main(String[] args) {
        int highest = 0;

        try {
            File myFile = new File("inputs/day5.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                String pass = scanner.nextLine();
                int minR = 0;
                int maxR = 127;
                int minC = 0;
                int maxC = 7;
                for (int i = 0; i < pass.length(); i++) {
                    if(pass.charAt(i) == 'F'){
                        maxR = maxR - (maxR - minR)/2 - 1;
                    }else if (pass.charAt(i) == 'B'){
                        minR = minR + (maxR - minR)/2 + 1;
                    }else if (pass.charAt(i) == 'L'){
                        maxC = maxC - (maxC - minC)/2 - 1;
                    }else if (pass.charAt(i) == 'R'){
                        minC = minC + (maxC - minC)/2 + 1;
                    }
                }
                if((minR*8)+minC > highest){
                    highest = (minR*8)+minC;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        System.out.println(highest);
    }
}
