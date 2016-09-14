import DataBaseAccess.DataBaseAccess;
import DataBaseAccess.Station;
import DataBaseAccess.Arrival;
import Timer.Timer;
import UserInterface.UserInterface;

import java.time.LocalTime;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MetroLinkGuideApp {
    private static DataBaseAccess dataBaseAccess;
    private static UserInterface userInterface;
    private static Timer timer;

    public MetroLinkGuideApp(DataBaseAccess dataBaseAccess, UserInterface userInterface, Timer timer){
        this.dataBaseAccess = dataBaseAccess;
        this.userInterface = userInterface;
        this.timer = timer;
    }

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        List<Station> stations = dataBaseAccess.getStations();
        userInterface.outputStations(stations);
        LocalTime time = timer.getTime();

        String userStation = userInterface.getUserStation();
        List<Arrival> arrivals = dataBaseAccess.getArrivals(userStation, time.toString());

        Long timeToNext = timer.getTimeToNext(arrivals.get(0).getArrivalTime());
        userInterface.outputArrivals( timeToNext, arrivals);
    }

}
