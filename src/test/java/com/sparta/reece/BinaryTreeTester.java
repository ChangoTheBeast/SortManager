package com.sparta.reece;

import com.sparta.reece.binarytrees.BinaryTree;
import com.sparta.reece.binarytrees.BinaryTreeImpl;
import com.sparta.reece.exceptions.ChildNotFoundException;
import com.sparta.reece.logger.Log;
import org.junit.jupiter.api.*;

public class BinaryTreeTester {
    private BinaryTree<Integer> binaryTree;
    @BeforeEach
    public void createTree() {
        Integer[] array = {2,1,3};
        binaryTree = new BinaryTreeImpl<>(array);
    }

    @Test
    @DisplayName("Get Root Element Test")
    public void getElementTest() {
        Assertions.assertEquals(2, binaryTree.getRootElement());
    }
    @Test
    @DisplayName("Get Left Child Test")
    public void getLeftChildTest() {
        try {
            Assertions.assertEquals(1, binaryTree.getLeftChild(2));
        } catch (ChildNotFoundException e) {
            Log log = new Log();
            log.logException(e);
        }
    }
    @Test
    @DisplayName("Get Right Child Test")
    public void getRightChildTest() {
        try {
            Assertions.assertEquals(3, binaryTree.getRightChild(2));
        } catch (ChildNotFoundException e) {
            Log log = new Log();
            log.logException(e);
        }
    }
    @Test
    @DisplayName("Get Sorted Tree Ascending Test")
    public void getSortedTreeAsc() {
        Assertions.assertArrayEquals(new Integer[] {1,2,3}, binaryTree.getSortedTreeAsc());
    }

    @Test
    @DisplayName("Get Sorted Tree Descending Test")
    public void getSortedTreeDesc() {
        Assertions.assertArrayEquals(new Integer[] {3,2,1}, binaryTree.getSortedTreeDesc());
    }
    @Test
    @DisplayName("Add Element Test")
    public void addElementTest() {
        binaryTree.addElement(4);
        Assertions.assertArrayEquals(new Integer[] {1,2,3,4}, binaryTree.getSortedTreeAsc());
    }

    @Test
    @DisplayName("Get Tree Size Test")
    public void getNumberOfElementsTest() {
        Assertions.assertEquals(3, binaryTree.getNumberOfElements());
    }

    @Test
    @DisplayName("Add Elements Test")
    public void addElements() {
        binaryTree.addElements(new Integer[] {4,5,6});
        Assertions.assertArrayEquals(new Integer[] {1,2,3,4,5,6}, binaryTree.getSortedTreeAsc());
    }
}
