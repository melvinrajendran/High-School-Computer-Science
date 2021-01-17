import java.time.Duration;
import java.time.LocalTime;

public class Passenger implements Comparable<Passenger> {
    private String firstName, lastName, flightCity;
    LocalTime startTime, flightTime;
    
    public Passenger(String firstName, String lastName, String flightCity, LocalTime startTime, LocalTime flightTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightCity = flightCity;
        this.startTime = startTime;
        this.flightTime = flightTime;
    }
    
    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String flightCity() { return flightCity; }

    public LocalTime flightTime() { return flightTime; }

    public Duration etdCalc() { return Duration.between(startTime, flightTime); }

    public int compareTo(Passenger other) { return etdCalc().compareTo(other.etdCalc()); }

    public String toString() { return lastName + ", " + firstName + " – " + flightCity + " – " + flightTime; }
}
