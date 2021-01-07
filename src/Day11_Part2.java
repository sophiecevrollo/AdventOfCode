import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day11_Part2 {

    public static void main(String[] args) throws Exception {
        List<String> prevSeats = loadData("inputs/day11.txt");
        List<String> currSeats;

        boolean changes = true;
        while ( changes ){
            System.out.println("\n SEATS");
            printSeat(prevSeats);
            currSeats = seatChanges(prevSeats);

            if (currSeats.equals(prevSeats)) {
                changes = false;
            }
//            for (int i = 0; i < prevSeats.size(); i++)
//            {
//                System.out.println(prevSeats.get(i));
//            }
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
    public static void printSeat(List<String> seats){
        for (String seatRow:seats) {
            System.out.println(seatRow);
        }
    }

    private static List<String> seatChanges ( List<String> prevSeats ){
        List<String> currSeats = new ArrayList<>();
        int occupied;

        for (int y = 0; y < prevSeats.size(); y++) {
            StringBuilder str = new StringBuilder();
            for (int x = 0; x < prevSeats.get(y).length(); x++) {
//                System.out.println("YSize = " + prevSeats.size() + " XSize = " + prevSeats.get(0).length());
                char seat = prevSeats.get(y).charAt(x);
                if (seat != '.') {
                    // return occupied total here
                    occupied = countOccupied(x, y, prevSeats);
                    // check if need to change
                    if (seat == 'L' && occupied == 0) {
                        //change
                        str.append("#");
                    } else if (seat == '#' && occupied >= 5) {
                        //change
                        str.append("L");
                    } else {
                        str.append(prevSeats.get(y).charAt(x));
                    }


                } else {
                    str.append(".");
                }
            }
            // add together with new string
            currSeats.add(str.toString());


        }
        return currSeats;
    }


    public static int countOccupied( int x, int y, List<String> seats){
        int total = 0;

        for (int xInc = -1; xInc < 2; xInc++) {
            for (int yInc = -1; yInc < 2; yInc++) {
//                total += checkSeat(row, seat, rowInc, seatInc, seats);
                total += checkSeat(x, y, xInc, yInc, seats);
            }
        }
        return total;
    }



    private static int checkSeat(int xInp, int yInp, int xIncrements, int yIncrements, List<String> seats) {
        int occupied = 0;
        int x;
        int y;
        x = xInp;
        y = yInp;
        if (!(xIncrements == 0 && yIncrements == 0)) {
            while ((y + yIncrements != seats.size() && x + xIncrements != seats.get(0).length() && x + xIncrements > -1 && y + yIncrements > -1)) {
                x += xIncrements;
                y += yIncrements;
//                System.out.println(" x = " + x + " : y = " + y);

                if (seats.get(x).charAt(y) == '#') {
                    if (!(x == xInp && y == yInp)) {
                        return 1;
                    }
                } else if (seats.get(x).charAt(y) == 'L') {
                    break;
                }
            }
        }
        return 0;
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
