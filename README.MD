# Sort Manager

This Sort Manager contains the implementation of 3 sorting algorithms, namely:

 - Merge Sort
 - Bubble Sort
 - Binary Sort

As well as the implementation of a Binary Tree.

## Table Of Contents:
1. [Merge Sort](#merge-sort)
2. [Bubble Sort](#bubble-sort)
3. [Binary Sort](#binary-sort)
4. [Binary Tree](#binary-tree)
5. [Implementation](#implementation)
6. [Complexity Check](#complexity-check)

## Merge Sort
**Merge Sort** is a sorting algorithm that utilises a ***Divide and Conquer*** approach to sorting a list of elements. It does this by splitting the list in half then Merge Sorts each half individually. It does this recursion until the lists that It is sorting are each 1 element in size. At his point, the elements are compared and merged into a sorted list which is then returned. This means that at every recursion, you will get two sorted lists to merge together then return. Merging two sorted arrays into another sorted array can be done in linear time which gives Merge Sort an overall runtime of O(nlog(n)).

### Implementation:

```java
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
```

## Bubble Sort
**Bubble Sort** is another sorting algorithm that iteratively sorts a list of elements. It does this through comparing the first two elements in the list, if the left element is larger, swap them else leave them how they were. It then goes on two the 2nd and 3rd elements in the list and so on and so forth. Through doing this, over the process of one iteration, it moves the largest element to the end of the list. This is then performed again, ignoring the final element as that one is already sorted. Since in the worst case **Bubble Sort** needs to go through all n elements n-1 times, it gives **Bubble Sort** a worst case runtime of O(n<sup>2</sup>-n) which simplifies to O(n<sup>2</sup>). This makes it significantly slower than Merge Sort as the number of elements increases.

### Implementation:

This project contains two implementations of bubble sort:
- Iterative:
 ```java
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
 ```
- Recursive:
 ```java
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
 ```

## Binary Sort
**Binary Sort** utilises Binary Trees to sort a list of elements. The Binary Tree stores the elements in the list such that all elements smaller than the root element go to the left of it, and all elements larger than it go to the right of it. This happens for all elements such that each element has a left and/or right right node unless it is a terminal node. This tree is then returned from the left most elements to the rightmost elements which gives a sorted list. This also has a worst case runtime of O(nlog(n)) since the depth of the tree is at most log(n) elements and every element must be gone through.

### Implementation:
```java
public class BinarySort implements Sorter {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) throws SortingException {
        BinaryTree<T> binaryTree = new BinaryTreeImpl<>(array);
        return binaryTree.getSortedTreeAsc();
    }
}
```

## Binary Tree
A Binary Tree consists of a root node which has left and right children nodes. When an element is added to the tree, if it is less than the root node, it goes to the left node else to the right node and checks again and so on until it reaches a node that has no child on the side that it would go to next. It then becomes that nodes right/left child.

### Implementation:
```java
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
```

## Implementation
In this project, the Binary Tree Interface and Sorter Interface were implemented with generic solutions.This allowed fora binary tree of any comparable type to be instantiated, as well as any comparable array to be sorted. The was done to make the code much more open to future extension.

## Complexity Check
There was also an option for checking the comparitive time taken for each sorting method vs java's ```Arrays.sort()```. This showed that the complexities stated above held true, as well as how efficient java's sorting is compared with these sorting methods.
