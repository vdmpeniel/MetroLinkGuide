package Timer;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Implementation2 implements Timer{
    public String getTime(){
        // Get the current date and time
        LocalTime currentTime = LocalTime.now();
        return "" + currentTime;
    }

    public Long getTimeToNext(String nextArrival){
        LocalTime currentTime = LocalTime.now();
        LocalTime next = LocalTime.parse(nextArrival);
        return currentTime.until(next, ChronoUnit.MINUTES);
    }
}
