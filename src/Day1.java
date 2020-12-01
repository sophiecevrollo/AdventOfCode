import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day1{
    public static void main(String[] args){
        ArrayList<Integer> values = new ArrayList<>();
        values = loadData("input.txt");
        for ( int i = 0; i < values.size(); i++ ){
            int required =  2020 - values.get(i);
            if ( values.contains(required)  && (required != values.get(i))) {
                System.out.println( required * values.get(i) );
                break;
            } else if ( required == 1010){
                System.out.println(1010*2);
                break;
            }
        }
    }

    public static ArrayList<Integer> loadData (String fileName){
        ArrayList<Integer> values = new ArrayList<>();
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