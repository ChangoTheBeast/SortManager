package com.sparta.reece.controller;


import com.sparta.reece.logger.Log;
import com.sparta.reece.exceptions.EqualBoundsException;
import com.sparta.reece.exceptions.InvalidOptionException;
import com.sparta.reece.exceptions.InvalidSorterException;
import com.sparta.reece.model.SortFactory;
import com.sparta.reece.sorters.Sorter;
import com.sparta.reece.utilities.RandomStringGenerator;
import com.sparta.reece.view.Display;
import com.sparta.reece.view.Printer;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Reece Louch
 */

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static class ArrayGenerator {
        public static int[] getInts(int size) throws IllegalArgumentException{
            Random random = new Random();
            return random.ints(size).toArray();
        }

        public static int[] getInts(int size, String[] bounds) throws IllegalArgumentException {
            int upperBound;
            int lowerBound;
            try {
                upperBound = Integer.parseInt(bounds[0]);
                lowerBound = Integer.parseInt(bounds[1]);
            } catch (Exception e) {
                return getInts(size);
            }
            Random random = new Random();
            return random.ints(size, lowerBound, upperBound).toArray();
        }
        public static String[] getStrings(int size) {
            return RandomStringGenerator.getStrings(size);
        }
    }

    public static int getArrayType() {
        while (true) {
            try {
                Display.displayTypeChoice();
                String choice = getString();
                switch (choice.toLowerCase()) {
                    case "1":
                    case "int array":
                    case "int":
                        return 1;
                    case "2":
                    case "string array":
                    case "string":
                        return 2;
                    default:
                        throw new InvalidOptionException("Could not find '" + choice + "' as an option.");
                }
            } catch (InvalidOptionException e) {
                Log log = new Log();
                log.logException(e);
                Printer.printError(e);
            }
        }
    }

    public static int getBinaryTreesChoice() {
        while (true) {
            try {
                Display.displayBinaryTreesChoice();
                String choice = getString();
                switch (choice.toLowerCase()) {
                    case "1":
                    case "get sorted tree ascending":
                        return 1;
                    case "2":
                    case "get sorted tree descending":
                        return 2;
                    case "3":
                    case "add element":
                        return 3;
                    case "4":
                    case "get left child":
                        return 4;
                    case "5":
                    case "get right child":
                        return 5;
                    case "6":
                    case "exit":
                        return 6;
                    default:
                        throw new InvalidOptionException("Could not find '" + choice + "' as an option.");
                }
            } catch (InvalidOptionException e) {
                Log log = new Log();
                log.logException(e);
                Printer.printError(e);
            }
        }
    }

    public static int getChoice(boolean firstRun) {
        Log log = new Log();
        while (true) {
            try {
                Display.displayStartMenu(firstRun);
                String choice = getString();
                switch (choice.toLowerCase()) {
                    case "1":
                    case "sorting algorithms":
                        return 1;
                    case "2":
                    case "binary trees":
                        return 2;
                    case "3":
                    case "complexity check":
                        return 3;
                    case "4":
                    case "quit":
                    case "exit":
                        return 4;
                    default:
                        throw new InvalidOptionException("Could not find '" + choice + "' as an option.");
                }
            } catch (InvalidOptionException e) {
                log.logException(e);
                Printer.printError(e);
            }
        }
    }

    public static int getInt() {
        while (true) {
            try {
                Display.displayIntPrompt();
                String output = getString();
                return Integer.parseInt(output);
            } catch (NumberFormatException e) {
                Log log = new Log();
                log.logException(e);
                Printer.printError(e);
            }
        }
    }

    public static String getString() {
        String output = scanner.nextLine();
        UserInput.reset();
        return output;
    }

    private static void reset() {
        scanner = new Scanner(System.in);
    }

    public static Sorter getSorter() {
        Log log = new Log();
        SortFactory sortFactory = new SortFactory();
        while (true) {
            try {
                Display.displaySortingOptions();
                return sortFactory.getSorter(UserInput.getString());
            } catch (InvalidSorterException e) {
                log.logException(e);
                Printer.printError(e);
            }
        }
    }

    public static int[] getIntArray() {
        Log log = new Log();
        int size = 0;
        String[] bounds = new String[2];
        boolean successful = false;
        while (size < 1) {
            try {
                Display.displayArraySizePrompt();
                size = Integer.parseInt(UserInput.getString());
            } catch (IllegalArgumentException e) {
                Printer.printError(e);
                log.logException(e);
            }
        }
        while (!successful) {
            try {
                Display.displayBoundsPrompt();
                String limit = UserInput.getString();
                limit = limit.toLowerCase();
                switch (limit) {
                    case "yes":
                    case "y":
                        Display.displayUpperBounds();
                        int upperBound = Integer.parseInt(UserInput.getString());
                        Display.displayLowerBounds();
                        int lowerBound = Integer.parseInt(UserInput.getString());
                        if (lowerBound == upperBound) {
                            throw new EqualBoundsException("Upper bound and Lower bound cannot be equal.");
                        }
                        bounds[0] = Integer.toString(upperBound);
                        bounds[1] = Integer.toString(lowerBound);
                        break;
                    case "no":
                    case "n":
                        break;
                    default:
                        throw new IllegalArgumentException("Input string '" + limit + "' is not a yes or no answer.");
                }
                successful = true;
                return ArrayGenerator.getInts(size, bounds);
            } catch (IllegalArgumentException | EqualBoundsException e) {
                Printer.printError(e);
                log.logException(e);
            }
        }
        return null;
    }
    public static String[] getStringArray() {
        Log log = new Log();
        int size = 0;

        while (size < 1) {
            try {
                Display.displayArraySizePrompt();
                size = Integer.parseInt(UserInput.getString());
            } catch (IllegalArgumentException e) {
                Printer.printError(e);
                log.logException(e);
            }
        }
        return ArrayGenerator.getStrings(size);
    }

}
