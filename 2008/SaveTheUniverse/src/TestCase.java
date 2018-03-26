import java.util.HashMap;
import java.util.List;

public class TestCase {

    List<String> engines, queries;
    HashMap<String,Integer> mapWithEnginesAndNumberOfQueries;

    int numberOfEngines, numberOfQueries;

    int numberOfSwitches;
    int currentCursorIndex;
    
    boolean isSolved, mapIsFull;


    public TestCase(List<String> engines, List<String> queries) {
        this.engines = engines;
        this.queries = queries;
        numberOfEngines = engines.size();
        numberOfQueries = queries.size();
        mapWithEnginesAndNumberOfQueries = new HashMap<>();
    }

    public void solve(){
        fillMap();
        while(!isSolved){
            mapWithEnginesAndNumberOfQueries.clear();
            mapIsFull = false;
            numberOfSwitches++;
            fillMap();
            checkIsSolved();
        }
    }

    private void fillMap(){
        checkIsSolved();
        while(!mapIsFull && !isSolved){
            String currentSearchEngineInQuery = queries.get(currentCursorIndex);
            if(!mapWithEnginesAndNumberOfQueries.containsKey(currentSearchEngineInQuery)){
                mapWithEnginesAndNumberOfQueries.put(currentSearchEngineInQuery, currentCursorIndex);
            }
            currentCursorIndex++;
            checkIsSolved();
            checkMapIsFull();
        }
    }

    private void checkMapIsFull(){
        mapIsFull = mapWithEnginesAndNumberOfQueries.size() == engines.size();
    }

    private void checkIsSolved(){
        isSolved = currentCursorIndex == queries.size();//we reached the end of the queries
    }

    public int getNumberOfSwitches() {
        return numberOfSwitches;
    }

}

