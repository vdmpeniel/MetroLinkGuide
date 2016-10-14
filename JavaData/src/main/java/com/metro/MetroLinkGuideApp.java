package com.metro;

import com.metro.DataBaseAccess.DataBaseAccess;
import com.metro.DataBaseAccess.Station;
import com.metro.DataBaseAccess.Arrival;
import com.metro.Timer.Timer;
import com.metro.UserInterface.UserInterface;

import java.time.LocalTime;
import java.util.List;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class MetroLinkGuideApp {
    @Autowired
    private DataBaseAccess dataBaseAccess;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private Timer timer;

    public MetroLinkGuideApp(){
    }

    //when using spring annotations a setter or a constructor are not needed
    public MetroLinkGuideApp(DataBaseAccess dataBaseAccess, UserInterface userInterface, Timer timer){
        this.dataBaseAccess = dataBaseAccess;
        this.userInterface = userInterface;
        this.timer = timer;

    }


    public void run(){
        //Get all stations from DB and output them
        List<Station> stations = dataBaseAccess.getStations();
        userInterface.outputStations(stations);
        LocalTime time = timer.getTime();

        //Get all arrivals from DB
        String userStation = userInterface.getUserStation();
        List<Arrival> arrivals = dataBaseAccess.getArrivals(userStation, time.toString());

        //Get time to next arrival and output next arrival and next ten in queue
        Long timeToNext = timer.getTimeToNext(arrivals.get(0).getArrivalTime());
        userInterface.outputArrivals( timeToNext, arrivals);

    }

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        MetroLinkGuideApp app = (MetroLinkGuideApp) context.getBean("metroLinkGuideApp");
        app.run();
    }

}
