package be.intecbrussel;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Assignments {
    public static void main(String[] args) {

        System.out.println("Number multiply by 5 and larger than 50.");
        Assignment1();
        System.out.println("\n");

        System.out.println("Number able to divide by 2.");
        Assignment2();
        System.out.println("\n");

        System.out.println("Combine first 2 strings to 1 and capitalize.");
        Assignment3();
        System.out.println("\n");

        System.out.println("Calculate all integer from array except first 2");
        Assignment4();
        System.out.println("\n");

        System.out.println("Convert String to int");
        Assignment5();


    }

    static Integer[] intArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 15};
    static String[] fruits = {"banana", "pear", "apple", "mango", "orange"};

    //Create a stream that will multiply each integer by 5 and then print it if the integer is larger than 50.
    public static void Assignment1() {

        Stream.of(intArray).map(number -> number * 5)
                .filter(number -> number > 50)
                .forEach(number -> System.out.printf("%s\t ", number ));



    }

    //Create a stream that will divide each integer in the array by 2 and capture the new stream in a new array.
    public static void Assignment2() {

        Stream.of(intArray).filter(number -> number % 2 == 0)
                .filter(number -> number >= 2)
                .forEach(number -> System.out.printf("%s\t ", number));

    }

    //Create a stream that will capitalize the first two strings and then combine the 2 strings to 1 string.
    public static void Assignment3() {


        String newString = Stream.of(fruits).limit(2)
                .map(String::toUpperCase)
                .reduce("", (acc, el) -> acc + el);
        System.out.printf("%s\t", newString);


    }

    //Create a stream that will calculate the sum of all integers in the array, except the first 2 integers.
    public static void Assignment4() {
        int[] sum = IntStream.of(intArray).skip(2).sum();
        System.out.println(sum);

    }

    //Create a stream that will convert all strings that can be converted to integers.
    // (Tip: Use a tool to capture an exception)
    public static void Assignment5() {
        String[] aMixString = {"0", "3", "six", "9", "12", "fifteen", "45"};
        Stream.of(aMixString).filter(num -> StringToInteger(num))
                .mapToInt(number -> Integer.valueOf(number))
                .forEach(number -> System.out.print(number + " "));


    }
    private static boolean StringToInteger(String number){
        if(Integer.valueOf(number) == null){
            return false;
        }
        return true;
    }
}
