package com.sparta.reece.sorters;

import com.sparta.reece.exceptions.SortingException;
import com.sparta.reece.sorters.Sorter;

/**
 * @author Reece Louch
 */

public class BubbleSort implements Sorter {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) throws SortingException {
        if (array.length > 1000) {
            return sortIterative(array, array.length);
        } else {
            return sortRecursive(array, array.length);
        }
    }

    public <T extends Comparable<T>> T[] sortRecursive(T[] array, int size) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (i+1 < array.length) {
                    if (array[i].compareTo(array[i+1]) > 0) {
                        T temp = array[i+1];
                        array[i+1] = array[i];
                        array[i] = temp;
                    }
                }
            }
            return sortRecursive(array, size-1);
        }
        return array;
    }
    public <T extends Comparable<T>> T[] sortIterative(T[] array, int size) {
        if (size > 0) {
            for (int i = size; i >= 0; i--) {
                boolean sorted = true;
                for (int j = 0; j < size; j++) {
                    if (j+1 < i) {
                        if (array[j].compareTo(array[j+1]) > 0) {
                            sorted = false;
                            T temp = array[j+1];
                            array[j+1] = array[j];
                            array[j] = temp;
                        }
                    }
                }
                if (sorted) {
                    return array;
                }
            }
        }
        return array;
    }
}
