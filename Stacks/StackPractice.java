import java.util.Stack;
import java.io.*;

public class StackPractice {
    public static void main(String[] args) {
        //Part 1
        Stack<Integer> numStack = convertToBinaryStack(0);

        while (!numStack.isEmpty())
            System.out.print(numStack.pop());
        System.out.println("\n");

        //Part 2
        Stack<Character> charStack = convertToCharStack("Melvin");

        while (!charStack.isEmpty())
            System.out.print(charStack.pop());
        System.out.println("\n");

        //Part 3
        Stack<SWCharacter> maleCharacters = new Stack<SWCharacter>(), femaleCharacters = new Stack<SWCharacter>(), droidCharacters = new Stack<SWCharacter>(), birthYearCharacters = new Stack<SWCharacter>();
        File fileName = new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/Stacks/StarWarsCharacters.csv");

        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text;

            while ((text = input.readLine()) != null) {
                String[] values = text.split(",");

                if (values[6].equals("male"))
                    maleCharacters.push(new SWCharacter(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]));
                if (values[6].equals("female"))
                    femaleCharacters.push(new SWCharacter(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]));
                if (values[8].equals("Droid"))
                    droidCharacters.push(new SWCharacter(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]));
                if (values[5].endsWith("BBY") && !values[0].equals("name"))
                    birthYearCharacters.push(new SWCharacter(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]));
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }

        System.out.println("Male Characters");
        System.out.printf("%-25s%-25s", "Name", "Homeworld");
        System.out.println();
        while (!maleCharacters.isEmpty())
            System.out.println(maleCharacters.pop());
        System.out.println();

        System.out.println("Female Characters");
        System.out.printf("%-25s%-25s", "Name", "Homeworld");
        System.out.println();
        while (!femaleCharacters.isEmpty())
            System.out.println(femaleCharacters.pop());
        System.out.println();

        System.out.println("Droids");
        System.out.printf("%-25s%-25s", "Name", "Homeworld");
        System.out.println();
        while (!droidCharacters.isEmpty())
            System.out.println(droidCharacters.pop());
        System.out.println();

        System.out.println("Ages");
        System.out.printf("%-25s%-25s%-25s", "Name", "Homeworld", "Birth Year (BBY)");
        System.out.println();
        while (!birthYearCharacters.isEmpty()) {
            System.out.printf("%-25s%-25s%-25s", birthYearCharacters.peek().getName(), birthYearCharacters.peek().getHomeWorld(), Double.parseDouble(birthYearCharacters.peek().getBirthYear().substring(0, birthYearCharacters.peek().getBirthYear().indexOf("B"))));
            System.out.println();
            birthYearCharacters.pop();
        }
        System.out.println();
    }

    public static Stack<Integer> convertToBinaryStack(int decimal) {
        Stack<Integer> stack = new Stack<Integer>();

        if (decimal != 0) {
            int temp = decimal;
            while (temp != 0) {
                stack.push(temp % 2);
                temp /= 2;
            }
            return stack;
        }

        stack.push(0);
        return stack;
    }

    public static Stack<Character> convertToCharStack(String str) {
        String temp = str;
        Stack<Character> stack = new Stack<Character>();

        while (!temp.isEmpty()) {
            stack.push(temp.charAt(0));
            temp = temp.substring(1);
        }

        return stack;
    }

    public static class SWCharacter {
        private String name, height, mass, hairColor, eyeColor, birthYear, gender, homeWorld, species;
    
        public SWCharacter(String name, String height, String mass, String hairColor, String eyeColor, String birthYear, String gender, String homeWorld, String species) {
            this.name = name;
            this.height = height;
            this.mass = mass;
            this.hairColor = hairColor;
            this.eyeColor = eyeColor;
            this.birthYear = birthYear;
            this.gender = gender;
            this.species = species;

            if (homeWorld.equals("NA"))
                this.homeWorld = "Unknown";
            else
                this.homeWorld = homeWorld;
        }

        public String getName() { return name; }

        public String getHeight() { return height; }

        public String getMass() { return mass; }

        public String getHairColor() { return hairColor; }

        public String getEyeColor() { return eyeColor; }

        public String getBirthYear() { return birthYear; }

        public String getGender() { return gender; }

        public String getHomeWorld() { return homeWorld; }

        public String getSpecies() { return species; }

        public String toString() { return String.format("%-25s%-25s", name, homeWorld); }
    }
}