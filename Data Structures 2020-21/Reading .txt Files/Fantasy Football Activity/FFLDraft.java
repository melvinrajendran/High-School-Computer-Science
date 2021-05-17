import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class FFLDraft {
    public static void main(String[] args) {
        File fileName = new File("/Users/melvinrajendran/Desktop/Data Structures 2020-21/Reading .txt Files/Fantasy Football Activity/FFLDraftAverages.txt");
        ArrayList<FBPlayer> playerList = new ArrayList<>();

        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text;

            while ((text = input.readLine()) != null) {
                if (!(text.startsWith("#"))) {
                    String[] statsArray = text.split(";");

                    if (statsArray[7].endsWith(".1"))
                        statsArray[7] += "0";
                    if (statsArray[8].endsWith(".1"))
                        statsArray[8] += "0";

                    playerList.add(new FBPlayer(Double.parseDouble(statsArray[0]), statsArray[1], statsArray[2], statsArray[3], Integer.parseInt(statsArray[4]), Double.parseDouble(statsArray[5]), Double.parseDouble(statsArray[6]), new BigDecimal(statsArray[7]), new BigDecimal(statsArray[8]), Integer.parseInt(statsArray[9])));
                }
            }

            playerList = sortFBPlayerList(playerList);

            for (FBPlayer player : playerList)
                System.out.println(player);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static class FBPlayer implements Comparable<FBPlayer> {
        int bye, timesDrafted;
        String name, position, team;
        double pick, overall, stdDev;
        BigDecimal highRd, lowRd;
    
        public FBPlayer(double pick, String name, String position, String team, int bye, double overall, double stdDev, BigDecimal highRd, BigDecimal lowRd, int timesDrafted) {
            this.pick = pick;
            this.name = name;
            this.position = position;
            this.team = team;
            this.bye = bye;
            this.overall = overall;
            this.stdDev = stdDev;
            this.highRd = highRd;
            this.lowRd = lowRd;
            this.timesDrafted = timesDrafted;
        }
    
        public double getPick() { return this.pick; }
    
        public String getName() { return this.name; }
    
        public String getPosition() { return this.position; }
    
        public String getTeam() { return this.team; }
    
        public int getBye() { return this.bye; }
    
        public double getOverall() { return this.overall; }
    
        public double getStdDev() { return this.stdDev; }
    
        public BigDecimal getHighRd() { return this.highRd; }
    
        public BigDecimal getLowRd() { return this.lowRd; }
    
        public int getConsistency() {
            String lowStr = this.lowRd.toString(), highStr = this.highRd.toString();
            int lowIndex = lowStr.indexOf("."), highIndex = highStr.indexOf(".");
            int lWhole = Integer.parseInt(lowStr.substring(0, lowIndex)), lDecimal = Integer.parseInt(lowStr.substring(lowIndex + 1));
            int hWhole = Integer.parseInt(highStr.substring(0, highIndex)), hDecimal = Integer.parseInt(highStr.substring(highIndex + 1));
            int overallLowPos = (lWhole - 1) * 12 + lDecimal, overallHighPos = (hWhole - 1) * 12 + hDecimal;

            return overallLowPos - overallHighPos;
        }
    
        public int getTimesDrafted() { return this.timesDrafted; }
    
        @Override
        public int compareTo(FBPlayer otherPlayer) {
            if (getConsistency() > otherPlayer.getConsistency())
                return 1;
            if (getConsistency() < otherPlayer.getConsistency())
                return -1;
            if (getOverall() > otherPlayer.getOverall())
                return 1;
            if (getOverall() < otherPlayer.getOverall())
                return -1;

            return 0;
        }
    
        public String toString() { return String.format("%-25sPos: %-7sTeam: %-7sBye: %2s    Pick: %5s    Overall: %5s    Std Dev: %4s    High: %5s    Low: %5s    Drafted: %4s", name, position, team, bye, pick, overall, stdDev, highRd, lowRd, timesDrafted); }
    }

    public static ArrayList<FBPlayer> sortFBPlayerList(ArrayList<FBPlayer> list) {
        for (int i = 1; i < list.size(); i++) {
            FBPlayer key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                list.set(j, key);
                j--;
            }
        }

        return list;
    }
}