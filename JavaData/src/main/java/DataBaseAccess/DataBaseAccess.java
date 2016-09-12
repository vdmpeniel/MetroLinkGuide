package DataBaseAccess;

import java.util.List;

public interface DataBaseAccess {
    List getStations();
    List getArrivals(String userStation, String time);
}
