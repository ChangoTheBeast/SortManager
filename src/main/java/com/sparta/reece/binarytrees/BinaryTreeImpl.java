package com.sparta.reece.binarytrees;

import com.sparta.reece.logger.Log;
import com.sparta.reece.exceptions.ChildNotFoundException;

import java.util.*;

/**
 * @author Reece Louch
 * @param <T>
 *     The type of the BinaryTree.
 *
 */

public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {

    private Node<T> root;
    int size;
    T[] nodes;

    public BinaryTreeImpl(T[] array) {
        root = null;
        size = array.length;
        nodes = array;
        this.populate(array);
    }

    private void populate(T[] array) {
        for (T element : array) {
            if (root == null) {
                root = new Node<T>(element);
            } else {
                Node<T> child = new Node<T>(element);
                root.addChild(child);
            }
        }
    }

    private static class Node<V extends Comparable<V>> {
        private final V value;
        private Node<V> leftChild;
        private Node<V> rightChild;

        public Node(V value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        public V getValue() {
            return this.value;
        }

        public Node<V> getLeftChild() {
            return leftChild;
        }

        public Node<V> getRightChild() {
            return rightChild;
        }

        public void addChild(Node<V> child) {
            if (this.value.compareTo(child.getValue()) > 0) {
                if (leftChild == null) {
                    this.leftChild = child;
                } else {
                    this.leftChild.addChild(child);
                }
            } else {
                if (rightChild == null) {
                    this.rightChild = child;
                } else {
                    this.rightChild.addChild(child);
                }
            }
        }
    }

    @Override
    public T getRootElement() {
        return this.root.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return size;
    }

    @Override
    public void addElement(T element) {
        if (root == null) {
            root = new Node<T>(element);
        } else {
            Node<T> child = new Node<T>(element);
            root.addChild(child);
        }
        if (size == nodes.length) {
            nodes = Arrays.copyOf(nodes, size*2);
        }
        nodes[size] = element;
        this.size++;
    }

    @Override
    public void addElements(T[] elements) {
        for (T element : elements) {
            this.addElement(element);
        }
    }

    @Override
    public boolean findElement(T value) {
        for (T element : nodes) {
            if (element.compareTo(value) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T getLeftChild(T element) throws ChildNotFoundException {
        if (findElement(element)) {
            return this.getLeftChild(root, element);
        } else {
            throw new ChildNotFoundException("Element not found");
        }
    }

    private T getLeftChild(Node<T> node, T element) throws ChildNotFoundException {
        if (node.getValue() == element) {
            if (node.getLeftChild() == null) {
                throw new ChildNotFoundException("Node: " + element + " has no left child.");
            } else {
                return node.getLeftChild().getValue();
            }
        } else if (element.compareTo(node.getValue()) < 0) {
            return this.getLeftChild(node.getLeftChild(), element);
        } else {
            return this.getLeftChild(node.getRightChild(), element);
        }
    }

    @Override
    public T getRightChild(T element) throws ChildNotFoundException {
        if (findElement(element)) {
            return this.getRightChild(root, element);
        } else {
            throw new ChildNotFoundException("Element not found");
        }
    }

    private T getRightChild(Node<T> node, T element) throws ChildNotFoundException {
        if (node.getValue() == element) {
            if (node.getRightChild() == null) {
                throw new ChildNotFoundException("Node: " + element + " has no right child.");
            } else {
                return node.getRightChild().getValue();
            }
        } else if (element.compareTo(node.getValue()) < 0) {
            return this.getRightChild(node.getLeftChild(), element);
        } else {
            return this.getRightChild(node.getRightChild(), element);
        }
    }

    @Override
    public T[] getSortedTreeAsc() {
        this.resize();
        /*
        - recurse to left most element and return
        - then the right element of each left element.
        - then the root element.
        - then the left most element of the right element.
        - then the right element of each left element.
        - then the right element
        - list should be complete
         */
        Log log = new Log();
        List<T> nodeList = new ArrayList<>(getSortedTreeAsc(root));
        return nodeList.toArray(nodes);
    }

    private void resize() {
        this.nodes = Arrays.copyOf(nodes, size);
    }

    private List<? extends T> getSortedTreeAsc(Node<T> node) {
        List<T> nodeList = new ArrayList<>();
        if (node.getLeftChild() != null) {
            nodeList.addAll(this.getSortedTreeAsc(node.getLeftChild()));
        }
        nodeList.add((T) node.getValue());
        if (node.getRightChild() != null) {
            nodeList.addAll(this.getSortedTreeAsc(node.getRightChild()));
        }
        return nodeList;
    }

    @Override
    public T[] getSortedTreeDesc() {
        this.resize();
        Log log = new Log();
        List<T> nodeList = new ArrayList<>(getSortedTreeDesc(root));
        return nodeList.toArray(nodes);
    }

    private Collection<? extends T> getSortedTreeDesc(Node<T> node) {

        List<T> nodeList = new ArrayList<>();
        if (node.getRightChild() != null) {
            nodeList.addAll(this.getSortedTreeDesc(node.getRightChild()));
        }
        nodeList.add(node.getValue());
        if (node.getLeftChild() != null) {
            nodeList.addAll(this.getSortedTreeDesc(node.getLeftChild()));
        }
        return nodeList;
    }
}
