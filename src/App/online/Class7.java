package Lesson07.online;

import java.util.Scanner;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 01.09.2021
 */

public class Class7 extends Object {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char d = 'd';
        char d1 = 'D';

        System.out.println((int) d + " " + (int) d1);
//        String string0 = "Hello worlD!";
//        String string1 = "Hello";
//        string1 += " world!";
//
//        String string2 = scanner.nextLine(); // D d
//        String string3 = "Hello world!";
//
//        System.out.println("string0 > " + string0);
//        System.out.println("string1 > " + string1);
//        System.out.println("string2 > " + string2);
//        System.out.println("string3 > " + string3);
//
//        System.out.println("string0 = string1 > " + (string0 == string1));
//        System.out.println("string0 = string2 > " + (string0 == string2));
//        System.out.println("string0 = string3 > " + (string0 == string3));
//
//        System.out.println("string0 = string1 > " + (string0.equals(string1)));
//        System.out.println("string0 = string2 > " + (string0.equals(string2)));
//        System.out.println("string0 = string3 > " + (string0.equals(string3)));

//        long startTime = System.nanoTime(); //timeStamp UNIX;
//        String testString = "Test";
//        StringBuilder stringBuilder = new StringBuilder("Test");
//
//        for (int i = 0; i < 50000; i++) {
//            testString += i;  //Test01234567891011...49999
//        }
//
//        float delta = System.nanoTime() - startTime;
//        System.out.println(testString);
//        System.out.println("Time test string > " + delta * 0.000001f + " millisec.");
//
//        startTime = System.nanoTime();
//
//        for (int i = 0; i < 50000; i++) {
//            stringBuilder.append(i);
//        }
//
//        delta = System.nanoTime() - startTime;
//        System.out.println(stringBuilder.toString());
//        System.out.println(testString.equals(stringBuilder.toString()));
//        System.out.println("Time test stringBuilder > " + delta * 0.000001f + " millisec.");
    }
}
