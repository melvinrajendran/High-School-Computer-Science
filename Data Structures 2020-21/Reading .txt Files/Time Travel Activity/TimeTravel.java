import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeTravel {
    public static int count = 0;
    public static void main(String[] args) {
        File fileName = new File("/Users/melvinrajendran/Desktop/Data Structures 2020-21/Reading .txt Files/Time Travel Activity/TravelFile.txt");

        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text;

            while ((text = input.readLine()) != null) {
                String[] time = text.split(" ");
                timeTravel(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static void timeTravel(int numDays, int numHours, int numMinutes) {
        count++;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm aa 'on' MM/dd/yyyy");

        System.out.println("Trip " + count + ":\n\tDeparture Date and Time: " + sdf.format(calendar.getTime()));

        calendar.add(Calendar.DATE, numDays);
        calendar.add(Calendar.HOUR, numHours);
        calendar.add(Calendar.MINUTE, numMinutes);

        System.out.println("\tArrival Date and Time: " + sdf.format(calendar.getTime()));
    }
}