package UserInterface;

import DataBaseAccess.Arrival;
import DataBaseAccess.Station;
import java.util.List;

public interface UserInterface {
    String getUserStation();
    void outputStations(List<Station> stations);
    void outputArrivals(Long timeToNext, List<Arrival> arrivals);
}
