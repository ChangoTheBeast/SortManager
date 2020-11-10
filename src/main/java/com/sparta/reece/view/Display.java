package com.sparta.reece.view;

import com.sparta.reece.sorters.Sorter;

/**
 * @author Reece Louch
 */

public class Display {
    public static void displayStartMenu(boolean firstRun) {
        Printer.print("Welcome " + (firstRun ? "" : "back ") + "user, Please select an option below:");
        Printer.print("--------------------------------------");
        Printer.print("1: Sorting Algorithms");
        Printer.print("2: Binary Trees");
        Printer.print("3: Complexity Check");
        Printer.print("4: Quit");
    }
    public static void displaySortingOptions() {
        Printer.print("Please select a sorting algorithm:");
        Printer.print("----------------------------------");
        Printer.print("1: Bubble Sort\n2: Merge Sort\n3: Binary Sort");
    }
    public static void displayArraySizePrompt() {
        Printer.print("Please supply a size of array to sort:");
    }
    public static void displayBoundsPrompt() {
        Printer.print("Would you like to set bounds for the integer size?");
    }
    public static void displayUpperBounds() {
        Printer.print("Please enter the upper bound");
    }
    public static void displayLowerBounds() {
        Printer.print("Please enter the lower bound");
    }
    public static void displayTimeTaken(double duration) {
        Printer.print(duration);
    }

    public static void displayBeforeSorting() {
        Printer.print("Before Sorting:");
    }

    public static void displayTimeTaken(String sorter, long timeTaken, int numberOfElements) {
        Printer.print(sorter, timeTaken, numberOfElements);
    }

    public static void displayFastestTime(String sorter, long time) {
        Printer.print(sorter, time);
    }

    public static void displayBinaryTreesChoice() {
        Printer.print("Please select a method to run:");
        Printer.print("1: Get Sorted Tree Ascending");
        Printer.print("2: Get Sorted Tree Descending");
        Printer.print("3: Add Element");
        Printer.print("4: Get Left Child");
        Printer.print("5: Get Right Child");
        Printer.print("6: Exit");
    }

    public static void displayBinaryTrees(int choice) {
        switch (choice) {
            case 1:
                Printer.print("Binary Tree Sorted Asc:");
                break;
            case 2:
                Printer.print("Binary Tree Sorted Desc:");
                break;
            case 3:
                Printer.print("After adding one element");
                break;
            case 4:
                Printer.print("Get Left Element:");
                break;
            case 5:
                Printer.print("Get Right Element:");
                break;
        }
    }

    public static void displayArray(int[] array) {
        Printer.print(array);
    }

    public static void displayIntPrompt() {
        Printer.print("Please give a number to add");
    }

    public static void displayTypeChoice() {
        Printer.print("Please choose what type of array you would like to sort:");
        Printer.print("1: int array");
        Printer.print("2: String array");
    }

    public static void displayAfterSorting() {
        Printer.print("After Sorting:");
    }

    public static void displayArray(String[] array) {
        Printer.print(array);
    }
}
