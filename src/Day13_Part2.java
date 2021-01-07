import java.io.File;
import java.util.Scanner;
import java.util.List;
public class Day13_Part2 {
    static int timestamp = 0;
    String[] schedule;
    List<Integer> busses;

    public static void main (String[] args) throws Exception{
        Day13_Part2 day13 = new Day13_Part2();
        day13.loadData("inputs/test.txt");
        day13.seperateOperating();
        //int currentTime = timestamp;
        String answer = day13.part2();

        System.out.println(answer);
    }

    public void loadData(String file) throws Exception{
        File myFile = new File(file);
        Scanner scanner = new Scanner(myFile);

        timestamp = Integer.parseInt(scanner.nextLine());
        schedule = scanner.nextLine().split(",");

        scanner.close();
    }

    public void seperateOperating(){
        for (String entry : schedule){
            if (entry != "x"){
                busses.add(Integer.parseInt(entry));
            }
        }

    }
    public String part2(){
        long time = 0L;
        int[] deltaTime = new int[9];
        int[] modulos = new int[9];

        int index = 0;

        for(int i = 0; i < busses.size(); i++){
            if(busses.get(i) != -1) {
                modulos[index] = busses.get(i);
                deltaTime[index] = i;
                index++;
            }
        }

        long M = 1L;
        for (int m : modulos) {
            M *= m;
        }
//        for (int i = 0; i < modulos.length; i++) {
//            //Get greatest common divider in form 1 = my * modulos[i] + lam * (M / modulos[i])
//            Solution res = .getGCD(M / modulos[i], modulos[i]);
//
//            //Add this to the time, according to the CRT
//            time += res.lam * (M / modulos[i]) * dtime[i];
//        }
        return "" + Math.abs(time % M);
    }


}
