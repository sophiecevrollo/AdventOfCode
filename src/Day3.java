import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Day3 {

    public static void main(String[] args){
        Set<String> values  = loadData();
        Iterator<String> i = values.iterator();
        int horizonPos = 0;
        int verticalPos = 0;
        i.next();
        System.out.println(i.next());
        while( i.hasNext() )
        {
            horizonPos += 3;
            System.out.println(i.next() + "poopoo");
            System.out.println(verticalPos);
            verticalPos++;
//            if(i.hasNext()){
//                i.next();
//            } else {
//                System.out.println("NEXT");
//            }
           // }
        }
    }

    private static Set<String> loadData (){
        Set<String> values = new HashSet<>();
        try {
            File myFile = new File("inputs/day3.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                values.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        return values;
    }}
