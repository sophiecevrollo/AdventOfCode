import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day7_Part2 {
    public static void main(String[] args) {
        Map<String, List<String>> bagInfo = createMap();
        long containedIn = -1; //start at -1 as don't wish to count shiny bag
        containedIn += findBag("shiny gold", bagInfo);
        System.out.println(containedIn);
    }

    private static Map<String, List<String>> createMap(){
        Map<String, List<String>> bagInfo = new HashMap<>();

        try {
            File myFile = new File("inputs/day7.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if( line.length() != 0) {
                    String[] colours = line.split( " bags, | bag, | bag\\.| bags\\.| bags contain |no other");
                    for (int i = 1; i < colours.length; i++) {
                        if (!bagInfo.containsKey(colours[0])) {
                            bagInfo.put(colours[0], Arrays.asList(colours[i]));
                        } else {
                            List<String> existing = new ArrayList<>();
                            existing.addAll(bagInfo.get(colours[0]));
                            existing.add(colours[i]);
                            bagInfo.put(colours[0], existing);
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        return bagInfo;
    }

    private static long findBag(String givenBag, Map<String, List<String>> bagInfo) {
        long total = 0;
        List<String> currentBag = bagInfo.get(givenBag);
        if (currentBag == null) {
            return 1;
        }
        for (String aBag : currentBag) {
            String[] bagDesc = aBag.split("(?<=[0-9]) (?=[a-zA-Z])");
            total += Integer.parseInt(bagDesc[0])*findBag(bagDesc[1], bagInfo);
        }
        return total+1;
    }



}
