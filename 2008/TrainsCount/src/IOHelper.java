import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NiVH
 */
public class IOHelper {

    public static List<String> readLines(String filename) {
        List<String> inputList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                inputList.add(line);
            }

            fileReader.close();
            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return inputList;
    }

    public static void writeLineToFile(String filename, String str) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(filename, true));
            pw.write(str  + System.lineSeparator());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            pw.close();
        }
    }

    public static void deleteIfExist(String filename){
        try{
            Files.deleteIfExists(Paths.get(filename));
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
