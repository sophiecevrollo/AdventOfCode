import java.io.File;
import java.util.*;

public class Day12 {

    public static void main (String[] args) throws Exception{
        List<String> directions = loadData("inputs/day12.txt");
        int[] bearing = new int[4];
        //N=0,E=1,S=2,W=3
        int position = 1; //ship starts facing East

        for (String direction : directions){
            String heading = direction.substring(0,1);
            int amount = Integer.parseInt(direction.substring(1));

            switch (heading) {
                case "N":
                    bearing[0] += amount;
                    break;
                case "E":
                    position = 1;
                    bearing[position] += amount;
                    break;
                case "S":
                    bearing[2] += amount;
                    break;
                case "W":
                    position = 3;
                    bearing[position] += amount;
                    break;
                case "L":
                    position = position - (amount/90);
                    if (position < 0){
                        position = position+bearing.length;
                    }
                    break;
                case "R":
                    position = position + (amount/90);
                    if (position > bearing.length-1){
                        position = position-bearing.length;
                    }
                    break;
                case "F":
                    bearing[position] += amount;
                    break;
                default:
            }
        }

        int NSdir = bearing[0]-bearing[2];
        if ( NSdir < 0) {
            NSdir = Math.abs(NSdir);
            System.out.println("South " + Math.abs(NSdir));
        } else {
            System.out.println("North " + NSdir);
        }

        int EWdir = bearing[1]-bearing[3];
        if ( EWdir < 0) {
            EWdir = Math.abs(EWdir);
            System.out.println("West " + Math.abs(EWdir));
        } else {
            System.out.println("East " + EWdir);
        }
        System.out.println(NSdir+EWdir);
    }

    private static List<String> loadData(String file) throws Exception{
        List<String> output = new ArrayList<>();

        File myFile = new File(file);
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()) {
            output.add(scanner.nextLine());
        }
        scanner.close();
        return output;
    }
}
