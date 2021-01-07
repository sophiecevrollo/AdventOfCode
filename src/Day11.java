import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day11 {

    public static void main(String[] args) throws Exception {
        List<String> prevSeats = loadData("inputs/day11.txt");
        List<String> currSeats;

        boolean changes = true;
        while ( changes ){
            currSeats = seatChanges(prevSeats);

            if (currSeats.equals(prevSeats)) {
                changes = false;
            }
            for (int i = 0; i < prevSeats.size(); i++)
            {
                System.out.println(prevSeats.get(i));
            }
            System.out.println("");
            prevSeats = currSeats;

        }


        int occupied = 0;
        for (String row : prevSeats){
            for (int i = 0; i < row.length(); i++ ){
                if ( row.charAt(i) == '#' ) {
                    occupied++;
                }
            }
        }

        System.out.println(occupied);

    }

    private static List<String> seatChanges ( List<String> prevSeats ){
        List<String> currSeats = new ArrayList<>();

        for (int i = 0; i < prevSeats.size(); i++ ) {

            currSeats.add(seatChange(prevSeats, i));

        }
        return currSeats;
    }

    private static String seatChange ( List<String> prevSeats, int i ){
        StringBuilder str = new StringBuilder();
        String row = prevSeats.get(i);
        for (int j = 0; j < row.length(); j++) {

            Character seat = row.charAt(j);
            boolean occupy = true;
            int takenAdj = 0;

            //Row Above
            //Check upper left
            if (i > 0 && j > 0 && prevSeats.get(i - 1).charAt(j - 1) == '#') {
                takenAdj++;
                occupy = false;
            } else if (i > 0 && j > 0 && prevSeats.get(i - 1).charAt(j - 1) == '.') {

            }
            //Check above
            if (i > 0 && prevSeats.get(i - 1).charAt(j) == '#') {
                takenAdj++;
                occupy = false;
            }
            //Check upper right
            if (i > 0 && j < row.length() - 1 && prevSeats.get(i - 1).charAt(j + 1) == '#') {
                takenAdj++;
                occupy = false;
            }

            //Row Current
            if (j > 0 && prevSeats.get(i).charAt(j - 1) == '#') {
                takenAdj++;
                occupy = false;
            }
            if (j < row.length() - 1 && prevSeats.get(i).charAt(j + 1) == '#') {
                takenAdj++;
                occupy = false;
            }

            //Row Below
            if (j > 0 && i < prevSeats.size() - 1 && prevSeats.get(i + 1).charAt(j - 1) == '#') {
                takenAdj++;
                occupy = false;
            }
            if (i < prevSeats.size() - 1 && prevSeats.get(i + 1).charAt(j) == '#') {
                takenAdj++;
                occupy = false;
            }
            if (i < prevSeats.size() - 1 && j < row.length() - 1 && prevSeats.get(i + 1).charAt(j + 1) == '#') {
                takenAdj++;
                occupy = false;
            }

            if (seat.equals('L')) {
                if (occupy) {
                    str.append("#");
                } else {
                    str.append("L");
                }
            } else if (seat.equals('#')) {
                if (takenAdj >= 4) {
                    str.append("L");
                } else {
                    str.append("#");
                }
            } else if (seat.equals('.')) {
                str.append(".");
            }
        }
        return str.toString();
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
