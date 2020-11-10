package com.sparta.reece.model;

import com.sparta.reece.exceptions.InvalidSorterException;
import com.sparta.reece.sorters.BinarySort;
import com.sparta.reece.sorters.BubbleSort;
import com.sparta.reece.sorters.MergeSort;
import com.sparta.reece.sorters.Sorter;

/**
 * @author Reece Louch
 */

public class SortFactory {
    public Sorter getSorter(String sortType) throws InvalidSorterException {
        sortType = sortType.toLowerCase();
        switch (sortType) {
            case "bubble sort":
            case "1":
                return new BubbleSort();
            case "merge sort":
            case "2":
                return new MergeSort();
            case "binary sort":
            case "3":
                return new BinarySort();
            default:
                throw new InvalidSorterException("Sorting Algorithm '" + sortType + "' could not be found.");
        }
    }
}
