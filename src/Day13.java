import java.io.File;
import java.util.Scanner;

public class Day13 {
    static int timestamp = 0;
    String[] schedule;

    public static void main (String[] args) throws Exception{
        Day13 part1 = new Day13();
        part1.loadData("inputs/day13.txt");

        int currentTime = timestamp;
        int answer = part1.getWaitTime(currentTime);

        while ( answer == 0){
            answer = part1.getWaitTime(currentTime++);
        }
        System.out.println(answer);
    }

    public void loadData(String file) throws Exception{
        File myFile = new File(file);
        Scanner scanner = new Scanner(myFile);

        timestamp = Integer.parseInt(scanner.nextLine());
        schedule = scanner.nextLine().split(",");

        scanner.close();
    }

    public int getWaitTime(int currentTime){
        for (String service : schedule){
            if (!service.equals("x")){
                int serviceNum = Integer.parseInt(service);
                if (currentTime % serviceNum == 0){
                    return (currentTime - timestamp)*serviceNum;
                }
            }
        }
        return 0;
    }
}
