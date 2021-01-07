import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day7 {
    public static void main(String[] args) {
         Map<String, List<String>> bagInfo = createMap();
        int containedIn = 0;


        for (Map.Entry<String, List<String>> entry : bagInfo.entrySet()) {
            System.out.println(entry.getValue());
            containedIn += findBag("shiny gold", entry.getValue(), bagInfo);
        }
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
                    String[] colours = line.split( " bags, [0-9]* | bag, [0-9]* | bag\\.| bags\\.| bags contain [0-9]* ");
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

    private static int findBag(String bagColour,  List<String> givenBag, Map<String, List<String>> bagInfo) {
        int total = 0;
        if (givenBag == null) {
            return 0;
        }else {
            for (String bag : givenBag) {
                if (bag.equals(bagColour)) {
                    return 1;
                }
            }
        }
        for (String aBag : givenBag) {
            total += findBag(bagColour, bagInfo.get(aBag), bagInfo);
        }

        if (total > 0)
            return 1;
        else
            return 0;
    }

}
