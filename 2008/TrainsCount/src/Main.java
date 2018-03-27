import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String inputFile = "input.txt";
    static String outputFile = "output.txt";
    static int currentCursorIndex;

    public static void main(String... args){
        IOHelper.deleteIfExist(outputFile);//delete the outputfile if it already exists
        List<String> input = IOHelper.readLines(inputFile);
        int numberOfTestCases = Integer.parseInt(input.get(currentCursorIndex));
        currentCursorIndex++;

        for(int t = 0; t < numberOfTestCases; t++){
            int turnaroundTime = Integer.parseInt(input.get(currentCursorIndex));
            currentCursorIndex++;

            int NA = Integer.parseInt(input.get(currentCursorIndex).split("\\s")[0]);
            int NB = Integer.parseInt(input.get(currentCursorIndex).split("\\s")[1]);
            currentCursorIndex++;

            Station stationA = new Station();
            Station stationB = new Station();

            fillStationList(input, turnaroundTime, NA, stationA, stationB);
            fillStationList(input, turnaroundTime, NB, stationB, stationA);

            stationA.calculateTrainsNeeded();
            stationB.calculateTrainsNeeded();

            IOHelper.writeLineToFile(outputFile, createAndFormatOutputString(t, stationA, stationB));//would be better to open connection to file only ones
        }
    }

    private static void fillStationList(List<String> input, int turnaroundTime, int numberOfLines, Station station1, Station station2) {
        for(int i = 0; i < numberOfLines; i++){
            String currentLine = input.get(currentCursorIndex);

            LocalTime departureTimeA = TimeUtils.convertHHmmStringToTime(currentLine.split("\\s")[0]);
            ScheduleItem departureItem = new ScheduleItem("D", departureTimeA);
            station1.addScheduleItemToDeparture(departureItem);

            LocalTime arrivalTimeB = TimeUtils.convertHHmmStringToTime(currentLine.split("\\s")[1]);
            ScheduleItem incomingItem = new ScheduleItem("I", arrivalTimeB.plusMinutes(turnaroundTime));
            station2.addScheduleItemToArrivals(incomingItem);

            currentCursorIndex++;
        }
    }

    private static String createAndFormatOutputString(int numberOfTestCase, Station stationA, Station stationB){
        return String.format("Case #%d: %d %d", numberOfTestCase+1, stationA.calculateTrainsNeeded(), stationB.calculateTrainsNeeded());
    }
}
