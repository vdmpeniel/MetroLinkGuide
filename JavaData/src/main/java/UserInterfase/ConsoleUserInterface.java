package UserInterfase;

import DataBaseAccess.Arrival;
import DataBaseAccess.Station;

import java.util.List;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface{
    public String getUserStation(){
        Scanner input = new Scanner(System.in);
        System.out.println("Would you please, let us know at what station are you now?");
        System.out.print("Please use the ID to select the station:>>");
        String answer = input.nextLine();
        return answer;
    }

    public void outputStations(List<Station> stations){
        System.out.println("\n\n\n              *** METROLINK STATIONS ***");
        System.out.println("╔══════╦════════════════════════════════╗");

        System.out.println("  ID:       STATION NAME:");
        System.out.println("╠══════╩════════════════════════════════╣");
        for(Station station : stations){
            String outputLine = station.getId() + " :  " + station.getName();
            System.out.print("║ " + outputLine);
            int numberOfSpaces = 49 - outputLine.length();
            System.out.println(addSpaces(numberOfSpaces) + "║");
        }
        System.out.println("╚═══════════════════════════════════════╝");
    }

    public void outputArrivals(Long timeToNext, List<Arrival> arrivals){
        System.out.println("\n\n                             *** ARRIVING NOW ***");
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("  Route: " + arrivals.get(0).getRouteID() +
                           " " + arrivals.get(0).getHeadSign() +
                           " is arriving in " + timeToNext + " minutes.");
        System.out.println("╚═════════════════════════════════════════════════════════╝");


        System.out.println("\n                   *** NEXT ARRIVALS ***");
        System.out.println("╔════════╦══════╦══════════════════════════╗");
        System.out.println("  TIME:       ROUTE:   DESTINATION:");
        System.out.println("╠════════╩══════╩══════════════════════════╣");
        for(Arrival train : arrivals){
            String outputLine = train.getArrivalTime() + " : " + train.getRouteID() + " : " + train.getHeadSign();
            System.out.print("║ " + outputLine);
            int numberOfSpaces = 53 - outputLine.length();
            System.out.println(addSpaces(numberOfSpaces) + "║");
        }
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println("Thank you very much for using our MetroLink console application!");
    }

    private String addSpaces(int numberOfSpaces){
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < numberOfSpaces; i++){
            build.append(" ");
        }
        return build.toString();
    }
}
