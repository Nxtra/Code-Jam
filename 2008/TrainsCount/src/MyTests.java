import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    @Test
    public void testHHmmTimeStringToTimeConversion(){
        String timeString = "11:00";
        LocalTime resultTime = TimeUtils.convertHHmmStringToTime(timeString);

        assertEquals(LocalTime.of(11,00), resultTime);
    }

    @Test
    public void testTrainsNeeded(){
        ScheduleItem item1 = new ScheduleItem("I", LocalTime.of(9,0));
        ScheduleItem item2 = new ScheduleItem("I", LocalTime.of(10,30));
        List<ScheduleItem> arrivals = Arrays.asList(new ScheduleItem[]{item1, item2});

        ScheduleItem item3 = new ScheduleItem("D", LocalTime.of(9,30));
        ScheduleItem item4 = new ScheduleItem("D", LocalTime.of(10,00));
        ScheduleItem item5 = new ScheduleItem("D", LocalTime.of(12,00));
        ScheduleItem item6 = new ScheduleItem("D", LocalTime.of(14,00));
        List<ScheduleItem> departures = Arrays.asList(new ScheduleItem[]{item3, item4, item5, item6});

        Station station = new Station();
        station.setArrivals(arrivals);
        station.setDepartures(departures);

        assertEquals(2, station.calculateTrainsNeeded());
    }

    @Test
    public void midnightTest(){
        LocalTime newTime = LocalTime.MIN.plusMinutes(-5);
        assertEquals(LocalTime.of(23,55), newTime);
    }



/*    @Test
    public void testGenerateSortedSchedule(){
        List<ScheduleItem> arrivals = Arrays.asList(new ScheduleItem[]{})
        Station station = new Station(5);
    }*/

}
