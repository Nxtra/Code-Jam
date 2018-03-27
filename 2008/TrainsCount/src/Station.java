import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Station{


    List<ScheduleItem> arrivals;
    List<ScheduleItem> departures;
    List<ScheduleItem> schedule;


    public Station(){
        arrivals = new ArrayList<>();
        departures = new ArrayList<>();
        schedule = new ArrayList<>();
    }

    public void generateSortedSchedule(){
        schedule = Stream.concat(arrivals.stream(), departures.stream()).collect(Collectors.toList());
        Collections.sort(schedule);
    }

    public int calculateTrainsNeeded() {
        generateSortedSchedule();
        int trainsCurrentlyInStation = 0, trainsNeeded = 0;
        for(ScheduleItem item: schedule){
            if(item.isDeparture()){
                if (trainsCurrentlyInStation == 0) {
                    trainsNeeded++;
                } else {
                    trainsCurrentlyInStation--;
                }
            }else{//it's an arrival
                trainsCurrentlyInStation++;
            }
        }
        return trainsNeeded;
    }

    public void addScheduleItemToArrivals(ScheduleItem item){
        arrivals.add(item);
    }

    public void addScheduleItemToDeparture(ScheduleItem item){
        departures.add(item);
    }

    public void setArrivals(List<ScheduleItem> arrivals) {
        this.arrivals = arrivals;
    }

    public void setDepartures(List<ScheduleItem> departures) {
        this.departures = departures;
    }
}
