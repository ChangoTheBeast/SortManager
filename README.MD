# Sort Manager

This Sort Manager contains the implementation of 3 sorting algorithms, namely:

 - Merge Sort
 - Bubble Sort
 - Binary Sort

As well as the implementation of a Binary Tree.

## Merge Sort
**Merge Sort** is a sorting algorithm that utilises a ***Divide and Conquer*** approach to sorting a list of elements. It does this by splitting the list in half then Merge Sorts each half individually. It does this recursion until the lists that It is sorting are each 1 element in size. At his point, the elements are compared and merged into a sorted list which is then returned. This means that at every recursion, you will get two sorted lists to merge together then return. Merging two sorted arrays into another sorted array can be done in linear time which gives Merge Sort an overall runtime of O(nlog(n)).

## Bubble Sort
**Bubble Sort** is another sorting algorithm that iteratively sorts a list of elements. It does this through comparing the first two elements in the list, if the left element is larger, swap them else leave them how they were. It then goes on two the 2nd and 3rd elements in the list and so on and so forth. Through doing this, over the process of one iteration, it moves the largest element to the end of the list. This is then performed again, ignoring the final element as that one is already sorted. Since in the worst case **Bubble Sort** needs to go through all n elements n-1 times, it gives **Bubble Sort** a worst case runtime of O(n<sup>2</sup>-n) which simplifies to O(n<sup>2</sup>). This makes it significantly slower than Merge Sort as the number of elements increases.

## Binary Sort
**Binary Sort** utilises Binary Trees to sort a list of elements. The Binary Tree stores the elements in the list such that all elements smaller than the root element go to the left of it, and all elements larger than it go to the right of it. This happens for all elements such that each element has a left and/or right right node unless it is a terminal node. This tree is then returned from the left most elements to the rightmost elements which gives a sorted list. This also has a worst case runtime of O(nlog(n)) since the depth of the tree is at most log(n) elements and every element must be gone through.

## Binary Tree
A Binary Tree consists of a root node which has left and right children nodes. When an element is added to the tree, if it is less than the root node, it goes to the left node else to the right node and checks again and so on until it reaches a node that has no child on the side that it would go to next. It then becomes that nodes right/left child.

## Implementation
In this project, the Binary Tree Interface and Sorter Interface were implemented with generic solutions.This allowed fora binary tree of any comparable type to be instantiated, as well as any comparable array to be sorted. The was done to make the code much more open to future extension.

## Complexity Check
There was also an option for checking the comparitive time taken for each sorting method vs java's ```Arrays.sort()```. This showed that the complexities stated above held true, as well as how efficient java's sorting is compared with these sorting methods.
