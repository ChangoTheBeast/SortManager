package com.sparta.reece.utilities;

import com.sparta.reece.sorters.Sorter;

import java.util.Arrays;

public class TimeMeasurer {
    public static long measureTime(Sorter sorter, int[] array) {
        long startTime = System.nanoTime();
        sorter.sort(array);
        return System.nanoTime()-startTime;
    }

    public static long measureTime(int[] array) {
        long startTime = System.nanoTime();
        Arrays.sort(array);
        return System.nanoTime()-startTime;
    }
}
