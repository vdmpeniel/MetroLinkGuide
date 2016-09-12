package DataBaseAccess;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetrolinkDataBaseAccess implements DataBaseAccess {
    private final String DATABASE = "jdbc:sqlite:src\\main\\resources\\metrolink.db";
    private final String SQLITE = "org.sqlite.JDBC";

    public List getStations(){
        List<Station> stations = new ArrayList<>();
        String sql = "SELECT  stop_id, stop_name FROM stops WHERE stop_name LIKE '%METROLINK STATION%';";

        try (Connection connection = getConnection();){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Station station = new Station();
                station.setId(resultSet.getString("stop_id"));
                station.setName(resultSet.getString("stop_name"));
                stations.add(station);
            }
        } catch(SQLException e){
            System.out.println("SQL exception occurred: " + e);
        }
        return stations;
    }


    public List getArrivals(String userStation, String time){
        List<Arrival> arrivals = new ArrayList<>();
        String sql =  "SELECT DISTINCT trips.route_id, stop_times.arrival_time, trips.trip_headsign " +
                      "FROM stop_times " +
                      "JOIN trips ON stop_times.trip_id = trips.trip_id " +
                      "WHERE stop_id = ?  AND arrival_time > ? ORDER BY arrival_time LIMIT 10;";

        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userStation);
            preparedStatement.setString(2, time);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Arrival train = new Arrival();
                train.setRouteID(resultSet.getString("route_id"));
                train.setArrivalTime(resultSet.getString("arrival_time"));
                train.setHeadSign(resultSet.getString("trip_headsign"));
                arrivals.add(train);
            }
        } catch(SQLException e){
            System.out.println("SQL exception occurred: " + e);
        }
        return arrivals;
    }

    private Connection getConnection() throws SQLException{
        try {
            Class.forName(SQLITE);
        } catch(ClassNotFoundException e) {
            System.out.println("Class couldn't be found:" + e);
        }
        return DriverManager.getConnection(DATABASE);
    }
}



