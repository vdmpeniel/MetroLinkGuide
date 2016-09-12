package Timer;
import java.time.LocalTime;

public interface Timer {
    LocalTime getTime();
    Long getTimeToNext(String nextArrival);
}
