import java.io.File;
import java.util.*;

public class Day9_Part2 {
    public static void main (String[] args) throws Exception{
        List<Long> XMAS = loadData("inputs/day9.txt");
        int weaknessPos =  part1(XMAS);
        List<Long> preamble2 = part2(XMAS, weaknessPos);
        Collections.sort(preamble2);
        System.out.println(preamble2.get(0) + preamble2.get(preamble2.size()-1));
    }

    private static int part1 (List<Long> XMAS){
        Set<Long> preamble = new TreeSet<>();
        int preambleLimit = 25;

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
                return i;
            }
            preamble.clear();
        }
        return 0;
    }

    private static List<Long> part2 (List<Long> XMAS, int weaknessPos){
        long total = 0;
        List<Long> preamble = new ArrayList<>();
        long weakness = XMAS.get(weaknessPos);

        for ( int i = XMAS.size()-1; i > 0; i--){
            total += XMAS.get(i);
            preamble.add(XMAS.get(i));
            while ( total > weakness) {
                total -= preamble.get(0);
                preamble.remove(0);
            }
            if (total == weakness && preamble.size()>1){
                break;
            }
        }
        return preamble;
    }

    private static List<Long> loadData(String file) throws Exception{
        List<Long> output = new ArrayList<>();

        File myFile = new File(file);
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()) {
            output.add(Long.parseLong(scanner.nextLine()));
        }
        scanner.close();
        return output;
    }
}