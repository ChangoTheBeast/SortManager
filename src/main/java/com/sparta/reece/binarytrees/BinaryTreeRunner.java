package com.sparta.reece.binarytrees;

import com.sparta.reece.controller.UserInput;
import com.sparta.reece.exceptions.ChildNotFoundException;
import com.sparta.reece.exceptions.InvalidOptionException;
import com.sparta.reece.exceptions.ObjectConversionException;
import com.sparta.reece.exceptions.PrimitiveConversionException;
import com.sparta.reece.logger.Log;
import com.sparta.reece.utilities.Converter;
import com.sparta.reece.view.Display;
import com.sparta.reece.view.Printer;

public class BinaryTreeRunner {
    public static void startBinaryTrees() {
        Log log = new Log();
        int[] array = UserInput.getIntArray();
        BinaryTree<Integer> binaryTree = null;
        Integer[] integers;
        try {
            binaryTree = new BinaryTreeImpl<>(Converter.toObject(array));
        } catch (PrimitiveConversionException e) {
            log.logException(e);
            Printer.printError(e);
        }
        boolean binaryActive = true;
        while (binaryActive) {
            try {
                int choice = UserInput.getBinaryTreesChoice();
                switch (choice) {
                    case 1:
                        Display.displayArray(array);
                        Display.displayBinaryTrees(choice);
                        integers = binaryTree.getSortedTreeAsc();
                        Display.displayArray(Converter.toPrimitive(integers));
                        break;
                    case 2:
                        Display.displayArray(array);
                        Display.displayBinaryTrees(choice);
                        integers = binaryTree.getSortedTreeDesc();
                        Display.displayArray(Converter.toPrimitive(integers));
                        break;
                    case 3:
                        Display.displayArray(Converter.toPrimitive(binaryTree.getSortedTreeAsc()));
                        binaryTree.addElement(UserInput.getInt());
                        Display.displayBinaryTrees(choice);
                        Display.displayArray(Converter.toPrimitive(binaryTree.getSortedTreeAsc()));
                        break;
                    case 4:
                        Display.displayBinaryTrees(choice);
                        Printer.printInt(binaryTree.getLeftChild(UserInput.getInt()));
                        break;
                    case 5:
                        Display.displayBinaryTrees(choice);
                        Printer.printInt(binaryTree.getRightChild(UserInput.getInt()));
                        break;
                    case 6:
                        binaryActive = false;
                }
            } catch (ObjectConversionException | ChildNotFoundException e) {
                log.logException(e);
                Printer.printError(e);
            }
        }
    }
}
