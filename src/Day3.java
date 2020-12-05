import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3 {

    public static void main(String[] args) {
        List<String> lines = loadData();
        int trees = 0;
        int horizonPos = 0;
        for( int i = 1; i < lines.size(); i++){
            horizonPos += 3;
            if( horizonPos > lines.get(i).length()-1) {
                horizonPos = horizonPos-lines.get(i).length();
            }
            if( lines.get(i).charAt(horizonPos) == '#' ){
                trees++;
            }
        }
        System.out.println(trees);
    }

    private static List<String> loadData (){
        List<String> lines = new ArrayList<>();
        try {
            File myFile = new File("inputs/day3.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        return lines;
    }
}
