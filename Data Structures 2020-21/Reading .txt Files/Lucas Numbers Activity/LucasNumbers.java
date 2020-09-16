import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class LucasNumbers {
    public static void main(String[] args) {
        File file = new File("/Users/melvinrajendran/Desktop/Data Structures 2020-21/Reading .txt Files/Lucas Numbers Activity/LucasNumsFile.txt");
        ArrayList<BigInteger> termList = new ArrayList<>();

        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;

            while ((text = input.readLine()) != null) {
                termList.add(new BigInteger(text));
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }

        for (BigInteger bi : termList) {
            System.out.println("Term: " + bi + " Value: " + findNthLucasTerm(bi));
        }
    }

    public static BigInteger findNthLucasTerm(BigInteger termNum) {
        if (termNum.equals(BigInteger.ZERO)) {
            return new BigInteger("2");
        } else if (termNum.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            BigInteger valueOne = new BigInteger("2"), valueTwo = new BigInteger("1");

            for (BigInteger i = new BigInteger("2"); i.compareTo(termNum) < 0; i = i.add(BigInteger.ONE)) {
                BigInteger temp = valueOne.add(valueTwo);
                valueOne = valueTwo;
                valueTwo = temp;
            }
    
            return (valueOne.add(valueTwo));
        }
    }
}
