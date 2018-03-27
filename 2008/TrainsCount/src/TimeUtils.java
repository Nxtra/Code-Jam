import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    public static LocalTime convertHHmmStringToTime(String timeString){
        return LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
    }


}
