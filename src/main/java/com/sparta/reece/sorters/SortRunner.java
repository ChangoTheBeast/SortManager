package com.sparta.reece.sorters;

import com.sparta.reece.controller.UserInput;
import com.sparta.reece.view.Display;
import com.sparta.reece.view.Printer;

import java.util.Arrays;

public class SortRunner {
    public static void startSorting() {
        Sorter sorter = UserInput.getSorter();
        int type = UserInput.getArrayType();
        long startTime;
        long timeTaken;
        switch (type) {
            case 1:
                int[] intArrayToBeSorted = UserInput.getIntArray();
                Display.displayBeforeSorting();
                Display.displayArray(intArrayToBeSorted);
                startTime = System.nanoTime();
                int[] sortedInts = sorter.sort(intArrayToBeSorted);
                Display.displayAfterSorting();
                Printer.print(sortedInts);
                timeTaken = System.nanoTime()-startTime;
                Display.displayTimeTaken(timeTaken);
                break;
            case 2:
                String[] stringArrayToBeSorted = UserInput.getStringArray();
                Display.displayBeforeSorting();
                Display.displayArray(stringArrayToBeSorted);
                startTime = System.nanoTime();
                String[] sortedStrings = sorter.sort(stringArrayToBeSorted);
                Display.displayAfterSorting();
                Printer.print(sortedStrings);
                timeTaken = System.nanoTime()-startTime;
                Display.displayTimeTaken(timeTaken);
                break;
        }
    }
}
