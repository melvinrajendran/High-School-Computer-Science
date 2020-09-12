import java.io.*;
import java.util.ArrayList;

public class AmicableNumbers {
    public static void main(String[] args) {
        File fileName = new File("/Users/melvinrajendran/Desktop/Data Structures/Reading .txt Files/Amicable Numbers Activity/AmicableNumsFile.txt");

        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text;

            while ((text = input.readLine()) != null) {
                String[] numsArray = text.split(" ");
                int numOne = Integer.parseInt(numsArray[0]), numTwo = Integer.parseInt(numsArray[1]);
                
                if (checkAmicable(numOne, numTwo)) {
                    System.out.println(numOne + " and " + numTwo + " are amicable.");
                } else {
                    System.out.println(numOne + " and " + numTwo + " are not amicable.");
                }

                printFactorsAndSum(numOne);
                printFactorsAndSum(numTwo);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static ArrayList<Integer> findFactors(int num) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                list.add(i);
            }
        }

        return list;
    }

    public static boolean checkAmicable(int numOne, int numTwo) {
        ArrayList<Integer> listOne = findFactors(numOne), listTwo = findFactors(numTwo);
        int sumOne = 0, sumTwo = 0;

        for (Integer i : listOne) {
            sumOne += i;
        }

        for (Integer i : listTwo) {
            sumTwo += i;
        }

        if (sumOne == numTwo && sumTwo == numOne) {
            return true;
        } else {
            return false;
        }
    }

    public static void printFactorsAndSum(int num) {
        ArrayList<Integer> list = findFactors(num);
        int sum = 0;

        System.out.print("\tThe factors of " + num + " are ");
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);

            if (i != list.size() - 1) {
                System.out.print(list.get(i) + ", ");
            } else {
                System.out.println("and " + list.get(i) + ". Sum is " + sum + ".");
            }
        }
    }
}