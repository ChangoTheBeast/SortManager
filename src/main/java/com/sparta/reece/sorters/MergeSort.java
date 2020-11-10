package com.sparta.reece.sorters;


import com.sparta.reece.utilities.Merger;
import com.sparta.reece.exceptions.MergingException;
import com.sparta.reece.exceptions.SortingException;

import java.util.Arrays;

/**
 * @author Reece Louch
 */

public class MergeSort implements Sorter {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) throws SortingException {
        if (array == null) {
            throw new SortingException("Please supply a valid array.");
        } else if (array.length == 1) {
            throw new SortingException("Cannot sort an array of length 1");
        } else {
            int middle = array.length / 2;
            T[] lowerArray = Arrays.copyOfRange(array, 0, middle);
            T[] upperArray = Arrays.copyOfRange(array, middle, array.length);
            return sort(lowerArray, upperArray);
        }
    }

    private <T extends Comparable<T>> T[] sort(T[] lowerArray, T[] upperArray) throws SortingException, MergingException {
        if (lowerArray.length == 1 || upperArray.length == 1) {
            if (lowerArray.length > 1) {
                int lowerArrayMidPoint = lowerArray.length/2;
                T[] lowerLowerArray = Arrays.copyOfRange(lowerArray, 0, lowerArrayMidPoint);
                T[] upperLowerArray = Arrays.copyOfRange(lowerArray, lowerArrayMidPoint, lowerArray.length);
                T[] sortedLower = sort(lowerLowerArray, upperLowerArray);
                return Merger.merge(sortedLower, upperArray);
            } else if (upperArray.length > 1) {
                int upperArrayMidPoint = upperArray.length/2;
                T[] lowerUpperArray = Arrays.copyOfRange(upperArray, 0, upperArrayMidPoint);
                T[] upperUpperArray = Arrays.copyOfRange(upperArray, upperArrayMidPoint, upperArray.length);
                T[] sortedUpper = sort(lowerUpperArray, upperUpperArray);
                return Merger.merge(lowerArray, sortedUpper);
            } else {
                return Merger.merge(lowerArray, upperArray);
            }
        } else {
            int lowerArrayMidPoint = lowerArray.length/2;
            int upperArrayMidPoint = upperArray.length/2;
            T[] lowerLowerArray = Arrays.copyOfRange(lowerArray, 0, lowerArrayMidPoint);
            T[] upperLowerArray = Arrays.copyOfRange(lowerArray, lowerArrayMidPoint, lowerArray.length);
            T[] lowerUpperArray = Arrays.copyOfRange(upperArray, 0, upperArrayMidPoint);
            T[] upperUpperArray = Arrays.copyOfRange(upperArray, upperArrayMidPoint, upperArray.length);
            T[] sortedLower = sort(lowerLowerArray, upperLowerArray);
            T[] sortedUpper = sort(lowerUpperArray, upperUpperArray);
            return Merger.merge(sortedLower, sortedUpper);
        }
    }
}
