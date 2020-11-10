package com.sparta.reece.view;

import java.util.Arrays;

/**
 * @author Reece Louch
 */

public class Printer {
    public static void print(String message) {
        System.out.println(message);
    }

    public static void printError(Throwable e) {
        System.err.println(e.getMessage());
    }

    public static void print(int[] array) {
        System.out.println("Array: " + Arrays.toString(array));
    }

    public static void print(double duration) {
        if (duration > 1000000000) {
            duration = duration/1000000000;
            System.out.println("Time taken: " + duration + " seconds");
        } else if (duration > 1000000) {
            duration = duration/1000000;
            System.out.println("Time taken: " + duration + " milliseconds");
        } else {
            System.out.println("Time taken: " + duration + " nanoseconds");
        }
    }

    public static void print(String sorter, long timeTaken, int numberOfElements) {
        if (timeTaken > 1000000000) {
            double duration = timeTaken/1000000000.0;
            System.out.println(sorter + " took " + duration + " seconds to sort " + numberOfElements + " elements.");
        } else if (timeTaken > 1000000) {
            double duration = timeTaken/1000000.0;
            System.out.println(sorter + " took " + duration + " milli-seconds to sort " + numberOfElements + " elements.");
        } else {
            System.out.println(sorter + " took " + timeTaken + " nano-seconds to sort " + numberOfElements + " elements.");
        }

    }

    public static void print(String sorter, long timeTaken) {
        if (timeTaken > 1000000000) {
            double duration = timeTaken/1000000000.0;
            System.out.println("The fastest sorter was " + sorter + " with a time taken of " + duration + " seconds.");
        } else if (timeTaken > 1000000) {
            double duration = timeTaken/1000000.0;
            System.out.println("The fastest sorter was " + sorter + " with a time taken of " + duration + " milli-seconds.");
        } else {
            System.out.println("The fastest sorter was " + sorter + " with a time taken of " + timeTaken + " nano-seconds.");
        }

    }

    public static void printInt(Integer leftChild) {
        System.out.println(leftChild);
    }

    public static void print(String[] array) {
        System.out.println("Array: " + Arrays.toString(array));
    }
}
