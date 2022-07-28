import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // arg commands
        String initialString = args[0];
        String commandString = args[1];
        String outputString = args[2];

        // reading all the files
        ReadFromFile readFromFile = new ReadFromFile();
        File initialFile = readFromFile.openFile(initialString);
        File commandFile = readFromFile.openFile(commandString);
        File outputFile = readFromFile.openFile(outputString);
        ArrayList<String> initialArraylist = readFromFile.readFile(initialFile);
        ArrayList<String> commandArrayList = readFromFile.readFile(commandFile);

        //setting initials
        ArrayList<String> boardBoundary = new ArrayList<>(Arrays.asList(initialArraylist.get(1).split("x")));
        int boardSize = Integer.parseInt(boardBoundary.get(0));
        List<List<String>> myBoard = new ArrayList<List<String>>();
        for (int i = 0; i < boardSize; i++){
            ArrayList<String> random = new ArrayList<>();
            for (int j = 0; j <boardSize; j ++){
                random.add("  ");
            }
            myBoard.add(random);
        }

        //arraylist for each team
        ArrayList<Callience> callienceArrayList = new ArrayList<>();
        ArrayList<Zorde> zordeArrayList = new ArrayList<>();

        //getting player objects with polymorphism - using their reference types
        for (String il: initialArraylist){
            ArrayList<String> ilArrayList = new ArrayList<>(Arrays.asList(il.split(" ")));
            if (ilArrayList.get(0).equals("ELF")){
                callienceArrayList.add(new Elf(ilArrayList.get(1), Constants.elfHP, Constants.elfAP, Constants.elfMaxMove));
                myBoard.get(Integer.parseInt(ilArrayList.get(3))).set(Integer.parseInt(ilArrayList.get(2)), ilArrayList.get(1));
            }
            if (ilArrayList.get(0).equals("DWARF")){
                callienceArrayList.add(new Dwarf(ilArrayList.get(1), Constants.dwarfHP, Constants.dwarfAP, Constants.dwarfMaxMove));
                myBoard.get(Integer.parseInt(ilArrayList.get(3))).set(Integer.parseInt(ilArrayList.get(2)), ilArrayList.get(1));
            }
            if (ilArrayList.get(0).equals("HUMAN")){
                callienceArrayList.add(new Human(ilArrayList.get(1), Constants.humanHP, Constants.humanAP, Constants.humanMaxMove));
                myBoard.get(Integer.parseInt(ilArrayList.get(3))).set(Integer.parseInt(ilArrayList.get(2)), ilArrayList.get(1));
            }
            if (ilArrayList.get(0).equals("GOBLIN")){
                zordeArrayList.add(new Goblin(ilArrayList.get(1), Constants.goblinHP, Constants.goblinAP, Constants.goblinMaxMove));
                myBoard.get(Integer.parseInt(ilArrayList.get(3))).set(Integer.parseInt(ilArrayList.get(2)), ilArrayList.get(1));
            }
            if (ilArrayList.get(0).equals("TROLL")){
                zordeArrayList.add(new Troll(ilArrayList.get(1), Constants.trollHP, Constants.trollAP, Constants.trollMaxMove));
                myBoard.get(Integer.parseInt(ilArrayList.get(3))).set(Integer.parseInt(ilArrayList.get(2)), ilArrayList.get(1));
            }
            if (ilArrayList.get(0).equals("ORK")){
                zordeArrayList.add(new Ork(ilArrayList.get(1), Constants.orkHP, Constants.orkAP, Constants.orkMaxMove));
                myBoard.get(Integer.parseInt(ilArrayList.get(3))).set(Integer.parseInt(ilArrayList.get(2)), ilArrayList.get(1));
            }
        }

        //initial point
        ReadFromFile.boardMaker(outputFile, myBoard, callienceArrayList, zordeArrayList);

        for (int i = 0; i<commandArrayList.size(); i++){
            ReadFromFile.boardMaker(outputFile, myBoard, callienceArrayList, zordeArrayList);
        }

        ReadFromFile.writeFile(outputFile, "Game Finished");
    }
}