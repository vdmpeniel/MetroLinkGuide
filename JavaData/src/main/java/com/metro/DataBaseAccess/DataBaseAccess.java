package com.metro.DataBaseAccess;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface DataBaseAccess {
    List getStations();
    List getArrivals(String userStation, String time);
}
