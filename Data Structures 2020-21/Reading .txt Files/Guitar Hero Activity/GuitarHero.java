import java.io.*;

public class GuitarHero {
    public static void main(String[] args) {
        File fileName = new File("/Users/melvinrajendran/Desktop/Data Structures 2020-21/Reading .txt Files/Guitar Hero Activity/GuitarTabFile.txt");
        int fretNumber = 0, numChords = 0;

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
                        if (k == 0) {
                            if (i == 0)
                                formattedArr[29][j + 1] = "o";
                            else if (i == 1)
                                formattedArr[28][j + 1] = "o";
                            else if (i == 2)
                                formattedArr[27][j + 1] = "o";
                            else if (i == 3)
                                formattedArr[26][j + 1] = "o";
                            else if (i == 4)
                                formattedArr[25][j + 1] = "o";
                        } else if (k == 1) {
                            if (i == 0)
                                formattedArr[24][j + 1] = "o";
                            else if (i == 1)
                                formattedArr[23][j + 1] = "o";
                            else if (i == 2)
                                formattedArr[22][j + 1] = "o";
                            else if (i == 3)
                                formattedArr[21][j + 1] = "o";
                            else if (i == 4)
                                formattedArr[20][j + 1] = "o";
                        } else if (k == 2) {
                            if (i == 0)
                                formattedArr[19][j + 1] = "o";
                            else if (i == 1)
                                formattedArr[18][j + 1] = "o";
                            else if (i == 2)
                                formattedArr[17][j + 1] = "o";
                            else if (i == 3)
                                formattedArr[16][j + 1] = "o";
                            else if (i == 4)
                                formattedArr[15][j + 1] = "o";
                        } else if (k == 3) {
                            if (i == 0)
                                formattedArr[14][j + 1] = "o";
                            else if (i == 1)
                                formattedArr[13][j + 1] = "o";
                            else if (i == 2)
                                formattedArr[12][j + 1] = "o";
                            else if (i == 3)
                                formattedArr[11][j + 1] = "o";
                            else if (i == 4)
                                formattedArr[10][j + 1] = "o";
                        } else if (k == 4) {
                            if (i == 0)
                                formattedArr[10][j + 1] = "o";
                            else if (i == 1)
                                formattedArr[9][j + 1] = "o";
                            else if (i == 2)
                                formattedArr[8][j + 1] = "o";
                            else if (i == 3)
                                formattedArr[7][j + 1] = "o";
                            else if (i == 4)
                                formattedArr[6][j + 1] = "o";
                        } else if (k == 5) {
                            if (i == 0)
                                formattedArr[5][j + 1] = "o";
                            else if (i == 1)
                                formattedArr[4][j + 1] = "o";
                            else if (i == 2)
                                formattedArr[3][j + 1] = "o";
                            else if (i == 3)
                                formattedArr[2][j + 1] = "o";
                            else if (i == 4)
                                formattedArr[1][j + 1] = "o";
                        }
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