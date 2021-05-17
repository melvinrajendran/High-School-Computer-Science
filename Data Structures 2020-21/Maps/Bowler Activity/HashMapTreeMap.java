import java.util.*;
import java.io.*;

public class HashMapTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, PriorityQueue<Bowler>> bMap = new TreeMap<>();
        
        File fileName = new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/Maps/BowlingData.txt");
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text;

            while ((text = input.readLine()) != null) {
                String[] instanceVars = text.split(" ");

                int score = Integer.parseInt(instanceVars[2]);
                if (!bMap.containsKey(score))
                    bMap.put(score, new PriorityQueue<Bowler>());
                Bowler bowler = new Bowler(instanceVars[0], instanceVars[1], score);
                bMap.get(score).add(bowler);
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String totalOutput = "{", keyOutput = "", entryOutput = "", valueOutput = "";
        for (Integer key : bMap.keySet()) {
            totalOutput += key + "=";
            keyOutput += key;
            entryOutput += key + "=";

            PriorityQueue<Bowler> bowlerQueue = new PriorityQueue<>();
            bowlerQueue.addAll(bMap.get(key));

            String output = "[";
            while (!bowlerQueue.isEmpty()) {
                output += bowlerQueue.poll().toString();
                if (bowlerQueue.peek() != null)
                    output += ", ";
            }
            output += "]";
            totalOutput += output;
            entryOutput += output;
            valueOutput += output;
            
            if (key != bMap.lastKey()) {
                totalOutput += ", ";
                keyOutput += "\n";
                entryOutput += "\n";
                valueOutput += "\n";
            }
        }
        totalOutput += "}";

        System.out.println(totalOutput);
        System.out.println("+++++++++++++++++++++++++++++++++++\n+++++++++++++++KEYS++++++++++++++++\n+++++++++++++++++++++++++++++++++++");
        System.out.println(keyOutput);
        System.out.println("+++++++++++++++++++++++++++++++++++\n+++++++++++++ENTRY SET+++++++++++++\n+++++++++++++++++++++++++++++++++++");
        System.out.println(entryOutput);
        System.out.println("+++++++++++++++++++++++++++++++++++\n++++++++++++++VALUES+++++++++++++++\n+++++++++++++++++++++++++++++++++++");
        System.out.println(valueOutput);
    }

    public static class Bowler implements Comparable<Bowler> {
        private String firstName, lastName;
        private int score;

        public Bowler(String firstName, String lastName, int score) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.score = score;
        }

        public String getFirstName() { return firstName; }

        public String getLastName() { return lastName; }

        public int getScore() { return score; }

        public int compareTo(Bowler other) {
            if (lastName.compareTo(other.getLastName()) < 0)
                return -1;
            else if (lastName.compareTo(other.getLastName()) > 0)
                return 1;
            if (firstName.compareTo(other.getFirstName()) < 0)
                return -1;
            else if (firstName.compareTo(other.getFirstName()) > 0)
                return 1;
            return 0;
        }

        public String toString() { return firstName + " " + lastName; }
    }
}