package com.metro.Timer;
import org.springframework.stereotype.Component;
import java.time.LocalTime;

@Component
public interface Timer {
    LocalTime getTime();
    Long getTimeToNext(String nextArrival);
}
