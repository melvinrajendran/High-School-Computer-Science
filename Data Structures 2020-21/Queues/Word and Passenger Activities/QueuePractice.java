import java.io.*;
import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuePractice {
    public static void main(String[] args) {
        // Task 1
        // See Word.java for object class

        Queue<Word> queue = new LinkedList<Word>();
        PriorityQueue<Word> pQueue = new PriorityQueue<Word>();

        try {
            BufferedReader input = new BufferedReader(new FileReader("/Users/melvinrajendran/Documents/Data Structures 2020-21/Queues/Paragraph.txt"));
            String text;

            while ((text = input.readLine()) != null) {
                String[] words = text.split("[!._,@? ]+");

                for (int i = 0; i < words.length; i++) {
                    String word = words[i].toLowerCase();
                    queue.add(new Word(word));
                    pQueue.add(new Word(word));
                }
            }
            input.close();
        } catch (IOException e) { System.out.println("File not found"); }

        while (queue.peek() != null)
            System.out.printf("%-15s%-15s\n", queue.poll(), pQueue.poll());
        System.out.println();

        // Task 2
        // See Passenger.java for object class

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("h:mm a");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("hh:mm a");

        LocalTime startTime = LocalTime.of(9, 3, 0);

        Queue<Passenger> passengerQueue = new LinkedList<Passenger>();
        PriorityQueue<Passenger> priorityPassengerQueue = new PriorityQueue<Passenger>();

        try {
            BufferedReader input = new BufferedReader(new FileReader("/Users/melvinrajendran/Documents/Data Structures 2020-21/Queues/PassengerInfo.txt"));
            String text;
            String fName = "";
            String lName = "";
            String flightCity = "";
            LocalTime flightTime = LocalTime.MIN;
            int count = 0;

            while ((text = input.readLine()) != null) {
                if (count % 3 == 0) {
                    String[] name = text.split(" ");
                    fName = name[0];
                    lName = name[1];
                }
                if (count % 3 == 1) {
                    flightCity = text;
                }
                if (count % 3 == 2) {
                    if (text.length() == 7)
                        flightTime = LocalTime.parse(text, dtf1);
                    if (text.length() == 8)
                        flightTime = LocalTime.parse(text, dtf2);

                    passengerQueue.add(new Passenger(fName, lName, flightCity, startTime, flightTime));
                    priorityPassengerQueue.add(new Passenger(fName, lName, flightCity, startTime, flightTime));
                    fName = "";
                    lName = "";
                    flightCity = "";
                    flightTime = LocalTime.MIN;
                }
                count++;
            }
            input.close();
        } catch (IOException e) { System.out.println("File not found"); }

        while (passengerQueue.peek() != null) {
            Passenger current = passengerQueue.poll();
            System.out.println(current.getLastName() + ", " + current.getFirstName() + " - " + current.flightCity() + " - " + current.flightTime().format(dtf2) + " - " + formatDuration(current.etdCalc()));
        }
        System.out.println();

        while (priorityPassengerQueue.peek() != null && formatDuration(priorityPassengerQueue.peek().etdCalc()).startsWith("0")) {
            Passenger current = priorityPassengerQueue.poll();
            System.out.println(current.getLastName() + ", " + current.getFirstName() + " - " + current.flightCity() + " - " + current.flightTime().format(dtf2) + " - " + formatDuration(current.etdCalc()));
        }
    }

    public static String formatDuration(Duration d) {
        int minutes = d.toMinutesPart();
        if (minutes >= 10)
            return d.toHoursPart() + ":" + d.toMinutesPart();
        else   
            return d.toHoursPart() + ":0" + d.toMinutesPart();
    }
}