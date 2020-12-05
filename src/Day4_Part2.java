import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4_Part2 {
    public static void main(String[] args) {
        Map<String, Object> passport = new HashMap<> ();
        Map<String, Object> required = new HashMap<String, Object>() {{
            put("byr", new Integer[] { 1920, 2002});
            put("iyr",  new Integer[] { 2010, 2020});
            put("eyr",  new Integer[] { 2020, 2030});
            put("hgt",  new HashMap<String, Integer[]>(){{
                put("cm", new Integer[]{150,193});
                put("in",  new Integer[] { 59, 76});
            }});
            put("hcl",  "#([a-f]|[0-9]){6}"); //regex case
            put("ecl",  new HashSet<>(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth")));
            put("pid",  "[0-9]{9}");
        }};
        int valid = 0;

        try {
            File myFile = new File("inputs/day4.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNext()) {
                String[] lines = scanner.nextLine().split(" ");

                if( lines[0].length() != 0) {
                    for (String part : lines) {
                        String[] keyVal = part.split(":");
                        passport.put(keyVal[0], keyVal[1]);
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

    private static int valid(@NotNull Map<String, Object> required, Map<String, Object> passport){

        for(String field : required.keySet()) {
            if (!passport.containsKey(field)) {
                return 0;
            } else {
                if (field.equals("hcl") || field.equals("pid")) {
                    String regex = (String) required.get(field);
                    String val = (String) passport.get(field);

                    if (!val.matches(regex)) {
                        return 0;
                    }
                } else if ( field.equals("ecl") ){
                    Set colour = (Set) required.get(field);
                    String val = (String) passport.get(field);
                    if (!colour.contains(val)){
                        return 0;
                    }
                } else if (field.equals("hgt")) {
                    String entry = (String) passport.get(field);
                    if( !entry.contains("cm") && !entry.contains("in")){
                        return 0;
                    }
                    HashMap heightMap = (HashMap) required.get(field);
                    Integer val = Integer.parseInt(entry.substring(0, entry.length()-2));
                    Integer[] ranges = (Integer[]) heightMap.get(entry.substring(entry.length()-2));
                    if (val < ranges[0] || val > ranges[1]){
                        return 0;

                    }
                } else{
                    Integer[] range = (Integer[]) required.get(field);
                    Integer val = Integer.parseInt((String) passport.get(field));
                    if (val < range[0] || val > range[1]) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

}