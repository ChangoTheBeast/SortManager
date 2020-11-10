package com.sparta.reece.binarytrees;

import com.sparta.reece.exceptions.ChildNotFoundException;

/**
 * Created by keith.dauris on 26/06/2017.
 * @author Reece Louch
 */
public interface BinaryTree<T extends Comparable<T>> {
    T getRootElement();

    int getNumberOfElements();

    void addElement(T element);

    void addElements(T[] elements);

    boolean findElement(T value);

    T getLeftChild(T element) throws ChildNotFoundException;

    T getRightChild(T element) throws ChildNotFoundException;

    T[] getSortedTreeAsc();

    T[] getSortedTreeDesc();
}
