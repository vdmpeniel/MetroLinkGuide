import DataBaseAccess.DataBaseAccess;
import DataBaseAccess.MetrolinkDataBaseAccess;
import DataBaseAccess.Station;
import DataBaseAccess.Arrival;
import Timer.Timer;
import Timer.Implementation2;
import UserInterfase.ConsoleUserInterface;
import UserInterfase.UserInterface;

import java.util.List;

public class MetroLinkGuideApp {
    DataBaseAccess dataBaseAccess = null;
    UserInterface userInterface = null;
    Timer timer = null;

    public MetroLinkGuideApp(DataBaseAccess dataBaseAccess, UserInterface userInterface, Timer timer){
        this.dataBaseAccess = dataBaseAccess;
        this.userInterface = userInterface;
        this.timer = timer;
    }

    public static void main(String[] args){
        MetroLinkGuideApp JAD = new MetroLinkGuideApp(new MetrolinkDataBaseAccess(), new ConsoleUserInterface(), new Implementation2());

        List<Station> stations = JAD.dataBaseAccess.getStations();
        JAD.userInterface.outputStations(stations);
        String time = JAD.timer.getTime();

        String userStation = JAD.userInterface.getUserStation();
        List<Arrival> arrivals = JAD.dataBaseAccess.getArrivals(userStation, time);

        Long timeToNext = JAD.timer.getTimeToNext(arrivals.get(0).getArrivalTime());
        JAD.userInterface.outputArrivals( timeToNext, arrivals);

    }

}
