import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4 {
    public static void main(String[] args) {

        Set<String> required = new HashSet<>(Arrays.asList("byr", "iyr","eyr","hgt","hcl","ecl","pid"));
        Set<String> passport = new HashSet<>();
        int valid = 0;

        try {
            File myFile = new File("inputs/day4.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNext()) {
                String[] lines = scanner.nextLine().split(" ");

                if( lines[0].length() != 0) {
                    for (String part : lines) {
                        String[] keyVal = part.split(":");
                        passport.add(keyVal[0]);
                    }
                } else {
                    valid += valid(required, passport);
                    passport.clear();
                }
            }
            valid += valid(required, passport);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        System.out.println(valid);
    }

    public static int valid(Set<String> required, Set<String> passport){
        for(String field : required){
            if (!passport.contains(field)){
                return 0;
            }
        }
        return 1;
    }
}