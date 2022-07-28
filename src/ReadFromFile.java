import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {

    public ReadFromFile() { }

    public File openFile(String fileToRead){
        File file = new File(fileToRead);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
    public ArrayList<String> readFile(File file){
        ArrayList<String> myArrayList = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                myArrayList.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return myArrayList;
    }
    public static void writeFile(File file, String line){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath(),true));
            if (file.length() != 0) {
                writer.newLine();
            }
            writer.write(line);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void boardMaker(File file, List<List<String>> arr, ArrayList<Callience> calli, ArrayList<Zorde> zord){
        String stars = new String(new char[(arr.size() * 2) + 2]).replace('\0', '*');

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath(),true));
            if (file.length() != 0) {
                writer.newLine();
            }
            writer.write(stars);
            for (List<String> ar: arr){
                writer.newLine();
                writer.write("*");
                for (String piece: ar){
                    writer.write(piece);
                }
                writer.write("*");
            }
            writer.newLine();
            writer.write(stars);
            writer.newLine();
            for (Callience cal: calli){
                if (cal instanceof Dwarf){
                    writer.newLine();
                    String lineToWrite = cal.id + "\t" + cal.hp + "\t" + "(" + Constants.dwarfHP + ")";
                    writer.write(lineToWrite);
                }
            }
            for (Callience cal: calli){
                if (cal instanceof Elf){
                    writer.newLine();
                    String lineToWrite = cal.id + "\t" + cal.hp + "\t" + "(" + Constants.elfHP + ")";
                    writer.write(lineToWrite);
                }
            }
            for (Zorde zor: zord){
                if (zor instanceof Goblin){
                    writer.newLine();
                    String lineToWrite = zor.id + "\t" + zor.hp + "\t" + "(" + Constants.goblinHP + ")";
                    writer.write(lineToWrite);
                }
            }
            for (Callience cal: calli){
                if (cal instanceof Human){
                    writer.newLine();
                    String lineToWrite = cal.id + "\t" + cal.hp + "\t" + "(" + Constants.humanHP + ")";
                    writer.write(lineToWrite);
                }
            }
            for (Zorde zor: zord){
                if (zor instanceof Ork){
                    writer.newLine();
                    String lineToWrite = zor.id + "\t" + zor.hp + "\t" + "(" + Constants.orkHP + ")";
                    writer.write(lineToWrite);
                }
            }
            for (Zorde zor: zord){
                if (zor instanceof Troll){
                    writer.newLine();
                    String lineToWrite = zor.id + "\t" + zor.hp + "\t" + "(" + Constants.trollHP + ")";
                    writer.write(lineToWrite);
                }
            }
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
