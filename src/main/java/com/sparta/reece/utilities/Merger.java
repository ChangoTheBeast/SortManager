package com.sparta.reece.utilities;

import com.sparta.reece.exceptions.MergingException;

import java.util.Arrays;

/**
 * @author Reece Louch
 */

public class Merger {
    public static <T extends Comparable<T>> T[] merge(T[] array1, T[] array2) throws MergingException {
        if (array1 == null || array2 == null) {
            throw new MergingException("Cannot merge with null array");
        }
        T[] merged = Arrays.copyOf(array1, array1.length+array2.length);
        int length = merged.length;
        int pos = 0;
        int i = 0;
        int j = 0;
        while (pos < merged.length) {
            if ((j == array2.length && i < array1.length) || (i < array1.length && array1[i].compareTo(array2[j]) <= 0 )) {
                do {
                    merged[pos] = array1[i];
                    pos++;
                    i++;
                } while ((j == array2.length && i < array1.length)  || (i < array1.length && array1[i].compareTo(array2[j]) <= 0));
            } else if (j < array2.length) {
                do {
                    merged[pos] = array2[j];
                    pos++;
                    j++;
                } while ((i == array1.length && j < array2.length ) || (j < array2.length && array1[i].compareTo(array2[j]) > 0));
            }
        }
        return merged;
    }
}
