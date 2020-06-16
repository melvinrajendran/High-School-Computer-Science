@FunctionalInterface
interface FormatInterface {
    public String format(String name, int age);
}

@FunctionalInterface
interface CountVowelsInterface {
    public int countVowels(String str);
}

public class LambdaExpressions {
    public static void main (String[] args) {
        FormatInterface formatInterface = (String name, int age) -> name + " is " + age + " years old.";
        System.out.println(formatInterface.format("Melvin", 17));

        CountVowelsInterface countVowelsInterface = (String str) -> {
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'A' || str.charAt(i) == 'a' || str.charAt(i) == 'E' || str.charAt(i) == 'e' || str.charAt(i) == 'I' || str.charAt(i) == 'i' || str.charAt(i) == 'O' || str.charAt(i) == 'o' || str.charAt(i) == 'U' || str.charAt(i) == 'u') {
                    count++;
                }
            }

            return count;
        };
        System.out.println(countVowelsInterface.countVowels("Melvin Rajendran"));
    }
}