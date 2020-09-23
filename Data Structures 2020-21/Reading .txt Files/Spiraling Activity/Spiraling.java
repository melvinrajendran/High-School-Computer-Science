import java.io.*;

public class Spiraling {
    public static void main(String[] args) {
        File fileName = new File("/Users/melvinrajendran/Desktop/Data Structures 2020-21/Reading .txt Files/Spiraling Activity/Spiraling.txt");

        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text;

            while ((text = input.readLine()) != null) {
                printSpiral(Integer.parseInt(text));
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static void printSpiral(int size) {
        String[][] arr = new String[size][size];
        fill2DArray(arr, "-");

        int startX = 0, startY = 0, endX = arr.length - 1, endY = arr[0].length - 1;

        while (startX <= endX && startY <= endY) {
            for (int x = startX; x <= endX; x++) {
                arr[startY][x] = "*";
            }
            if (startX > 0) {
                startX++;
            }
            startY++;
            for (int y = startY; y <= endY; y++) {
                arr[y][endX] = "*";
            }
            startY++;
            endX--;
            if (arr.length % 4 == 2 && startX == endX) {
                break;
            }
            for (int x = endX; x >= startX; x--) {
                arr[endY][x] = "*";
            }
            endX--;
            endY--;
            for (int y = endY; y >= startY; y--) {
                arr[y][startX] = "*";
            }
            startX++;
            endY--;
        }

        print2DArray(arr);
    }

    public static void fill2DArray(String[][] arr, String text) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = text;
            }
        }
    }

    public static void print2DArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
