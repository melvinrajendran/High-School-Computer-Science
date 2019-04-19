public class FinalReviewI {

    public static void main(String[] args) {

//Task 1
        /*for (int i = 2; i <= 50; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        int i = 2;
        while (i <= 50) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
            i++;
        }
        System.out.println();

        i = 2;
        do {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
            i++;
        } while (i <= 50);
        System.out.println("\n");

//Task 2
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }
        System.out.println(sum);

        sum = 0;
        int i = 1;
        while (i <= 5) {
            sum += i;
            i++;
        }
        System.out.println(sum);

        sum = 0;
        i = 1;
        do {
            sum += i;
            i++;
        } while (i <= 5);
        System.out.println(sum + "\n");

//Task 3
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        int i = 1;
        while (i <= 4) {
            for (int j = 0; j < 4; j++) {
                System.out.print(i);
            }
            i++;
            System.out.println();
        }
        System.out.println();

        for (i = 4; i >= 1; i--) {
            for (int j = i; j <= 4; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
        System.out.println();

        for (i = 5; i < 9; i++) {
            for (int j = 9; j > i; j--) {
                System.out.print(j);
            }
            System.out.println();
        }

//Task 4
        int[] arr = {2, 5, 1, -1, 10, 3, 4, 6, 7, 9, 8};

        boolean result = checkSort(arr);
        if (result == true) {
            System.out.println("The array is sorted.\n");
        } else {
            System.out.println("The array is not sorted.\n");
        }

//Task 5
        pattern();
        System.out.println();

//Task 6
        int[] arr = {2, 5, 1, -1, 10, 3, 4, 6, 7, 9, 8};
        System.out.println(arraySum(arr));*/

//Task 7
        int[] arr = {2, 5, 1, -1, 10, 3, 4, 6, 7, 9, 8};
        System.out.println(arraySum3(arr));

    }
    public static boolean checkSort(int[] arr) {
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
    public static void pattern() {
        System.out.print("a ");
        System.out.print("b ");
        System.out.println("c");
        System.out.print("d ");
        System.out.print("e ");
        System.out.println("f");
        System.out.println("g\t\th\nij");


    }
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 1) {
                sum += arr[i];
            }
        }
        if (arr.length > 10) {
            sum *= 2;
        }
        return sum;
    }
    public static double arraySum3(int[] arr) {
        double sum = 0;
        double num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 3 == 0) {
                sum += arr[i];
                num++;
            }
        }
        double average = sum/num;
        return average;
    }
}
