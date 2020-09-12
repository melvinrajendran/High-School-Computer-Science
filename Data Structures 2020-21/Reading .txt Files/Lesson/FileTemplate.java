import java.io.*;

public class FileTemplate {

    public FileTemplate() {
        File fileName = new File("example.txt");

        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text;
            int sum = 0;

            while ((text = input.readLine()) != null) {
                String[] pieces = text.split(",");
                
                try {
                    for (int i = 0; i < pieces.length; i++) {
                        int num = Integer.parseInt(pieces[i]);
                        sum += num;
                    }
                } catch (NumberFormatException nfe) {

                }

                // System.out.println(text);
            }
            System.out.println(sum);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) {
        FileTemplate app = new FileTemplate();
    }
}