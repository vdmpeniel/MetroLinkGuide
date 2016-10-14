package com.metro.Timer;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class JavaTime8Test {
    @Test
    public void getTime(){
        JavaTime8 time = new JavaTime8();
        LocalTime result = time.getTime();
        assertEquals(LocalTime.parse("10:20:00"), result);
    }


    @Test
    public void getTimeToNext(){
        JavaTime8 time = new JavaTime8();
        Long result = time.getTimeToNext("10:30:00");
        assertEquals(Long.valueOf(9), result);
    }

    //probably the best option would be to return a LocalTime instead of a string

}