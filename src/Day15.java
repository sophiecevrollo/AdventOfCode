import java.util.HashMap;

public class Day15 {

    public static void main (String[] args) {
        // InputData can be updated with different inputs
        int[] inputData = {0,12,6,13,20,1,17};

        memoryGame(inputData, 2020);
        memoryGame(inputData, 30000000);
    }

    private static HashMap<Integer, Integer> setup(int[] input){
        HashMap<Integer,Integer> data = new HashMap<>();

        //put all data but nth from input into the hashMap
        for ( int i = 1; i < input.length; i++) {
            data.put(input[i-1], i);
        }
        return data;
    }

    private static int checkRule(HashMap<Integer,Integer> data, int prevNum, int turn){
        int newNum;

        //Update the newNum var according to the rules.
        if ( data.containsKey(prevNum)){
            newNum =  turn-data.get(prevNum);
        } else {
            newNum =  0;
        }

        data.put(prevNum, turn);
        return newNum;
    }

    private static void memoryGame(int[] inputData, int maxTurns){
        int prevNum = inputData[inputData.length-1];
        HashMap<Integer,Integer> data = setup(inputData);
        int turn = inputData.length;

        //change constant to find different nth number
        while ( turn != maxTurns){
            prevNum = checkRule(data, prevNum, turn++);
        }
        System.out.println(prevNum);
    }
}
