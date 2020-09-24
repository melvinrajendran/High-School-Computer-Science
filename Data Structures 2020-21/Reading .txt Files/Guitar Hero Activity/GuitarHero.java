import java.io.*;

public class GuitarHero {
    public static void main(String[] args) {
        File fileName = new File("/Users/melvinrajendran/Desktop/Data Structures 2020-21/Reading .txt Files/Guitar Hero Activity/GuitarTabFile.txt");
        int fretNumber = 0, numChords = 0;
        int[][] helperArr = {{29, 28, 27, 26, 25},
                             {24, 23, 22, 21, 20},
                             {19, 18, 17, 16, 15},
                             {14, 13, 12, 11, 10},
                             {10, 9, 8, 7, 6},
                             {5, 4, 3, 2, 1}};

        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            numChords = input.readLine().split(",").length;
        } catch (IOException e) {
            System.out.println("File not found");
        }

        String[][] arr = new String[5][numChords];

        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text;

            while ((text = input.readLine()) != null) {
                String[] chordPieces = text.split(",");

                for (int i = 0; i < chordPieces.length; i++) {
                    arr[fretNumber][i] = chordPieces[i];
                }
                fretNumber++;
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }

        String[][] formattedArr = createFormattedArray(numChords);

        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length; i++) {
                for (int k  = 0; k < arr[i][j].length(); k++) {
                    if (arr[i][j].charAt(k) == 'o' || arr[i][j].charAt(k) == '*') {
                        formattedArr[helperArr[k][i]][j + 1] = "o";
                    }
                }
            }
        }

        print2DArray(formattedArr);
    }

    public static String[][] createFormattedArray(int numChords) {
        String[][] arr = new String[30][numChords + 1];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = "";
            }
        }
        arr[0][0]  = "Measure";
        for (int i = 1; i <= numChords; i++) {
            arr[0][i] = i + "";
        }
        arr[1][0] = "G#";arr[2][0] = "G";arr[3][0] = "F#";arr[4][0] = "F";arr[5][0] = "E";arr[6][0] = "D#";
        arr[7][0] = "D";arr[8][0] = "C#";arr[9][0] = "C";arr[10][0] = "B";arr[11][0] = "A#";arr[12][0] = "A";
        arr[13][0] = "G#";arr[14][0] = "G";arr[15][0] = "F#";arr[16][0] = "F";arr[17][0] = "E";arr[18][0] = "D#";
        arr[19][0] = "D";arr[20][0] = "C#";arr[21][0] = "C";arr[22][0] = "B";arr[23][0] = "A#";arr[24][0] = "A";
        arr[25][0] = "G#";arr[26][0] = "G";arr[27][0] = "F#";arr[28][0] = "F";arr[29][0] = "E";

        return arr;
    }

    public static void print2DArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}