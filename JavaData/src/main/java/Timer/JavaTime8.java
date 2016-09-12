package Timer;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class JavaTime8 implements Timer{
    public LocalTime getTime(){
        // Get the current date and time
        LocalTime currentTime = LocalTime.now();
        //System.out.println(currentTime); //It is actually correct
        return currentTime;
    }

    public Long getTimeToNext(String nextArrival){
        LocalTime next = LocalTime.parse(nextArrival);
        return getTime().until(next, ChronoUnit.MINUTES);
    }
}
