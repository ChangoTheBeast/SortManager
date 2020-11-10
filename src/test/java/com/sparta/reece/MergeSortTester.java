package com.sparta.reece;

import com.sparta.reece.controller.UserInput;
import com.sparta.reece.exceptions.PrimitiveConversionException;
import com.sparta.reece.exceptions.SortingException;
import com.sparta.reece.sorters.MergeSort;
import com.sparta.reece.sorters.Sorter;
import com.sparta.reece.utilities.Converter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortTester {
    @Test
    @DisplayName("Merge Sort Test")
    public void mergeSortTest() throws SortingException, PrimitiveConversionException {
        int[] unsorted = UserInput.ArrayGenerator.getInts(1000);
        int[] sorted = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(sorted);
        Integer[] unsortedInts = Converter.toObject(unsorted);
        Integer[] sortedInts = Converter.toObject(sorted);
        Sorter mergeSort = new MergeSort();
        Assertions.assertArrayEquals(sortedInts, mergeSort.sort(unsortedInts));
    }
}
