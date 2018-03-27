import java.util.List;

public class MainUniverseSaver {

    static String inputFile = "input2.txt";
    static String outputFile = "output.txt";

    static List<String> input;

    static int numberOfTestCases;
    static TestCase currentTestCase;
    static int numberOfCurrentTestCase;

    static int currentInputLine;

    public static void main(String... args){
        IOHandler.deleteIfExist(outputFile);
        input = IOHandler.readLines(inputFile);
        setNumberOfTestCases();
        for(int i = 0; i < numberOfTestCases; i++){
            setCurrentTestCase();
            currentTestCase.solve();
            IOHandler.writeLineToFile(outputFile, formatOutput(currentTestCase.getNumberOfSwitches()));
        }

    }


    static void setCurrentTestCase(){

        int numberOfEngines = Integer.parseInt(input.get(currentInputLine));
        incrementCurrentInputLine(1);

        List<String> tempListOfEngines = input.subList(currentInputLine, currentInputLine + numberOfEngines);
        incrementCurrentInputLine(numberOfEngines);

        int numberOfQueries = Integer.parseInt(input.get(currentInputLine));
        incrementCurrentInputLine(1);

        List<String> tempListOfQueries = input.subList(currentInputLine, currentInputLine + numberOfQueries);
        incrementCurrentInputLine(numberOfQueries);

        numberOfCurrentTestCase++;
        currentTestCase = new TestCase(tempListOfEngines, tempListOfQueries);
    }

    static void writeToOutputFile(String answerForThisTestCase){
        IOHandler.writeLineToFile(outputFile, answerForThisTestCase);
    }

    static String formatOutput(int numberOfSwitches){
        return String.format("Case #%d: %d", numberOfCurrentTestCase , numberOfSwitches );
    }

    static void setNumberOfTestCases(){
        numberOfTestCases = Integer.parseInt(input.get(0));
        incrementCurrentInputLine(1);
    }
    static void incrementCurrentInputLine(int amount){
        currentInputLine += amount;
    }
}
