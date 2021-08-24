package Lesson03;

public class Homework3 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0}; // Array for Quest 1
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; // Array for Quest 3
        int[] arr6 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; // Array for Quest 6

        System.out.println("Quest 1: ");
        doQuest1(arr1); // Quest 1 check
        System.out.println("\nQuest 2: ");
        doQuest2(100); // Quest 2 check
        System.out.println("\nQuest 3: ");
        doQuest3(arr3); // Quest 3 check
        System.out.println("\nQuest 4: ");
        doQuest4(); // Quest 4 check
        System.out.println("\nQuest 5: ");
        doQuest5(5, 1); // Quest 5 check
        System.out.println("\nQuest 6: ");
        doQuest6(arr6); // Quest 6 check

    }
    // Quest1
    public static void doQuest1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            System.out.print(arr[i] + " ");
        }
    }

    // Quest2
    public static void doQuest2(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
            System.out.print(arr[i] + " ");
        }
    }

    // Quest3
    public static void doQuest3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i]*2;
            }
            System.out.print(arr[i] + " ");
        }
    }

    // Quest4
    public static void doQuest4() {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Quest5
    public static void doQuest5(int len, int initiaValue){
        int[] arr = new int[len];
        for  (int i = 0; i < len; i++) {
            arr[i] = initiaValue;
            System.out.print("[" + i + "]" + arr[i] + " ");
        }
    }

    // Quest6
    public static void doQuest6(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(max);
        System.out.print(min);
    }
    // Quest7
   //не смог=(

}
