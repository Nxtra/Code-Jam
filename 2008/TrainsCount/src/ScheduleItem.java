import java.time.LocalTime;

public class ScheduleItem implements Comparable<ScheduleItem>{

    String type; //I is incoming, D is departure
    LocalTime time;

    public ScheduleItem(String type, LocalTime time){
        this.type = type;
        this.time = time;
    }

    public int compareTo(ScheduleItem item){
        return this.time.compareTo(item.time);
    }

    public boolean isDeparture(){
        return this.type.equals("D");
    }
}
