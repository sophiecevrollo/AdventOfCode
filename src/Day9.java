import java.io.File;
import java.util.*;

public class Day9 {
    private int preambleLimit;

    public static void main (String[] args) throws Exception{
        Day9 day9 = new Day9(25);
        List<Long> XMAS = day9.loadData("inputs/day9.txt");
        System.out.println(day9.encryptionWeakness(XMAS));
    }

    public Day9(int preambleLimit){
        this.preambleLimit = preambleLimit;
    }

    public List<Long> loadData(String file) throws Exception{
        List<Long> output = new ArrayList<>();

        File myFile = new File(file);
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()) {
            output.add(Long.parseLong(scanner.nextLine()));
        } //throw io exception
        scanner.close();
        return output;
    }

    public long encryptionWeakness(List<Long> XMAS){
        Set<Long> preamble = new TreeSet<>();

        for ( int i = preambleLimit; i < XMAS.size(); i++ ){
            boolean valid = false;
            for ( int j = i-preambleLimit; j < i; j++ ){
                preamble.add(XMAS.get(j));
            }
            for ( int j = 1; j < preambleLimit; j++ ){

                if ( preamble.contains(XMAS.get(i)-XMAS.get(i-j))){
                    valid = true;
                }
            }
            if (!valid){
               return XMAS.get(i);
            }
            preamble.clear();
        }
        return 0;
    }
}
