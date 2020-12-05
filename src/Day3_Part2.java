import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3_Part2 {
    public static void main(String[] args) {
        List<String> lines = loadData();
        long trees = travel(lines, 1,1);
        trees = trees* travel(lines,3,1);
        trees = trees* travel(lines, 5,1);
        trees = trees* travel(lines,7,1);
        trees = trees* travel(lines,1,2);
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

    private static int travel(List<String> lines, int right, int down){
        int trees = 0;
        int horizonPos = 0;
        for( int i = down; i < lines.size(); i += down){
            horizonPos += right;
            if( horizonPos > lines.get(i).length()-1) {
                horizonPos = horizonPos-lines.get(i).length();
            }
            if( lines.get(i).charAt(horizonPos) == '#' ){
                trees++;
            }
        }
        System.out.println(trees);
        return trees;
    }
}
