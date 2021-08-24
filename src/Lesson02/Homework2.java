package Lesson02;

public class Homework2 {
    public static void main(String[] args) {
        System.out.println(doQuest1(11,9));
        doQuest2(10);
        System.out.println(doQuest3(-25));
        doQuest4("Boris", 7);

        System.out.println(doQuest5(1992));
    }

    // Quest 1.
    public static boolean doQuest1(int a, int b){
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        }
        return false;
    }

    // Quest 2.
    public static void doQuest2(int x) {
        if (x >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }
    // Quest 3.
        public static boolean doQuest3(int x) {
           if (x >= 0) {
               return true;
           } else {
               return false;
           }
        }
    // Quest 4.
        public static void doQuest4(String str, int n) {
            for (int i = 1; i <= n; i++) {
                System.out.println("[" + i + "]" + " " + str);
            }
        }
    // Quest 5.
        public static boolean doQuest5(int year) {
           if ((year % 4 == 0 && year % 100 !=0) || year % 400 ==0) {
               return true;
           } else {
               return false;
           }
        }
}
