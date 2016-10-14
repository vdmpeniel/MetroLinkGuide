package com.metro.UserInterface;

import com.metro.DataBaseAccess.Arrival;
import com.metro.DataBaseAccess.Station;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserInterface {
    String getUserStation();
    void outputStations(List<Station> stations);
    void outputArrivals(Long timeToNext, List<Arrival> arrivals);
}
