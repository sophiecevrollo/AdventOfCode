import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Day1{
    public static void main(String[] args){
        Set<Integer> values  = loadData("inputs/day1.txt");
        Iterator<Integer> i = values.iterator();
        boolean solved = false;
        while(i.hasNext() && !solved)
        {
            int current = i.next();
            int required = 2020 - current;
            if (required == 1010){
                System.out.println(2020);
                solved = true;
            } else if(values.contains(required)){
                System.out.println( required * current);
                solved = true;
            }
        }
    }

    public static Set<Integer> loadData (String fileName){
        Set<Integer> values = new HashSet<>();

        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                values.add( Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        return values;
    }
}