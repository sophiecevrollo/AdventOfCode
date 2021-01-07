
import java.io.File;
import java.util.*;

public class Day8_Part2 {
    public static void main(String[] args) throws Exception {
        List<String> bootCode = loadData("inputs/day8.txt");
        GameConsole gameConsole = new GameConsole(bootCode);
        gameConsole.findFault();
        System.out.println(gameConsole.accumulator);
    }

    public static class GameConsole{
        private List<String> bootcode;

        private int accumulator = 0;
        private GameConsole(List<String> bootCode){
            this.bootcode = bootCode;
        }

        private boolean infiniteCheck(){
            String[] tracker = new String[bootcode.size()];
            int position = 0;
            String[] split;
            while (position != tracker.length){
                if ( tracker[position]==null ){
                    tracker[position] = bootcode.get(position);
                    split = bootcode.get(position).split(" ");
                    switch (split[0]){
                        case "nop":
                            position++;
                            break;
                        case "acc":
                            accumulator += Integer.parseInt(split[1]);
                            position++;
                            break;
                        case "jmp":
                            position += Integer.parseInt(split[1]);
                            break;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        private void findFault(){
            String[] split;

            for (int i = 0; i < bootcode.size(); i++){
                accumulator = 0;
                split = bootcode.get(i).split(" ");
                if (split[0].equals("nop")){
                    bootcode.set(i,"jmp "+Integer.parseInt(split[1]));
                    if (infiniteCheck()){ break; }
                    bootcode.set(i,"nop "+Integer.parseInt(split[1]));
                } else if (split[0].equals("jmp")){
                    bootcode.set(i, "nop " + Integer.parseInt(split[1]));
                    if (infiniteCheck()){ break; }
                    bootcode.set(i,"jmp "+Integer.parseInt(split[1]));
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
