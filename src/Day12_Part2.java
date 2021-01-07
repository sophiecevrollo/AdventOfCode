import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day12_Part2 {

    public static void main (String[] args) throws Exception{
        List<String> directions = loadData("inputs/day12.txt");
        int[] ship = new int[4]; //NS=0,EW=1 North = + south = -, East = -
        int[] wayPoint = new int[]{1,10,0,0}; //N=0,E=1,S=2,W=3
        int position = 1; //ship starts facing East

        for (String direction : directions){
            String heading = direction.substring(0,1);
            int amount = Integer.parseInt(direction.substring(1));

            switch (heading) {
                case "N":
                    wayPoint[0] += amount;
                    break;
                case "E":
                    wayPoint[1] += amount;
                    break;
                case "S":
                    wayPoint[2] += amount;
                    break;
                case "W":
                    wayPoint[3] += amount;
                    break;
                case "L":
                    position = position - (amount/90);
                    if (position < 0){
//                        position = position+bearing.length;
                    }
                    break;
                case "R":
                    position = position + (amount/90);
//                    if (position > bearing.length-1){
//                        position = position-bearing.length;
//                    }
                    break;
                case "F":
                    for (int i = 0; i < ship.length; i++){
                        ship[i] = wayPoint[i]*amount;
                    }
                    break;
                default:
            }
        }

        int NSdir = ship[0]-ship[2];
        if ( NSdir < 0) {
            NSdir = Math.abs(NSdir);
            System.out.println("South " + Math.abs(NSdir));
        } else {
            System.out.println("North " + NSdir);
        }

        int EWdir = ship[1]-ship[3];
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
