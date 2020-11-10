package com.sparta.reece.sorters;

import com.sparta.reece.binarytrees.BinaryTree;
import com.sparta.reece.binarytrees.BinaryTreeImpl;
import com.sparta.reece.exceptions.SortingException;

/**
 * @author Reece Louch
 */


public class BinarySort implements Sorter {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) throws SortingException {
        BinaryTree<T> binaryTree = new BinaryTreeImpl<>(array);
        return binaryTree.getSortedTreeAsc();
    }
}