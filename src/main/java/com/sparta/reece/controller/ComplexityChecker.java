package com.sparta.reece.controller;

import com.sparta.reece.model.SortFactory;
import com.sparta.reece.sorters.Sorter;
import com.sparta.reece.utilities.TimeMeasurer;
import com.sparta.reece.view.Display;

import java.util.Arrays;

public class ComplexityChecker {
    public static void startComplexityCheck() {
        int[] mergeSortArray = UserInput.getIntArray();
        int size = mergeSortArray.length;
        int[] bubbleSortArray = Arrays.copyOf(mergeSortArray, size);
        int[] binarySortArray = Arrays.copyOf(mergeSortArray, size);
        int[] arraysSortArray = Arrays.copyOf(mergeSortArray, size);
        SortFactory sortFactory = new SortFactory();
        Sorter bubble = sortFactory.getSorter("1");
        Sorter merge = sortFactory.getSorter("2");
        Sorter binary = sortFactory.getSorter("3");

        long timeTakenBubble = TimeMeasurer.measureTime(bubble, bubbleSortArray);
        long timeTakenMerge = TimeMeasurer.measureTime(merge, mergeSortArray);
        long timeTakenBinary = TimeMeasurer.measureTime(binary, binarySortArray);
        long timeTakenJava = TimeMeasurer.measureTime(arraysSortArray);

        Display.displayTimeTaken("Bubble Sort", timeTakenBubble, size);
        Display.displayTimeTaken("Merge Sort", timeTakenMerge, size);
        Display.displayTimeTaken("Binary Sort", timeTakenBinary, size);
        Display.displayTimeTaken("Java's Arrays.sort()", timeTakenJava, size);
        long fastest = Math.min(timeTakenJava, Math.min(timeTakenBinary, Math.min(timeTakenBubble, timeTakenMerge)));
        String fastestSorter;
        if (fastest == timeTakenJava) {
            fastestSorter = "Java's Arrays.sort()";
        } else if (fastest == timeTakenBinary) {
            fastestSorter = "Binary Sort";
        } else if (fastest == timeTakenBubble) {
            fastestSorter = "Bubble Sort";
        } else {
            fastestSorter = "Merge Sort";
        }
        Display.displayFastestTime(fastestSorter, fastest);
    }
}
