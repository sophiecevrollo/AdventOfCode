
import java.io.File;
import java.util.*;

public class Day8 {
    public static void main(String[] args) throws Exception {
        List<String> bootCode = loadData("inputs/day8.txt");
        GameConsole gameConsole = new GameConsole(bootCode);
        gameConsole.infiniteCheck();
        System.out.println(gameConsole.accumulator);
    }

    public static class GameConsole{
        private List<String> bootcode;
        private int accumulator = 0;

        private GameConsole(List<String> bootCode){
            this.bootcode = bootCode;
        }

        private void infiniteCheck(){
            String[] tracker = new String[bootcode.size()];
            int position = 0;
            boolean complete = false;
            String[] split;

            while (!complete){
                if ( tracker[position]==null ){
                    tracker[position] = bootcode.get(position);
                    split = bootcode.get(position).split(" ");
                    if (split[0].equals("nop")){
                        position++;
                    } else if (split[0].equals("acc")){
                        accumulator += Integer.parseInt(split[1]);
                        position++;
                    } else if (split[0].equals("jmp")){
                        position += Integer.parseInt(split[1]);
                    }
                } else {
                    complete = true;
                }
            }
        }

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
