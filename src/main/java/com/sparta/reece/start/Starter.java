package com.sparta.reece.start;


import com.sparta.reece.binarytrees.BinaryTree;
import com.sparta.reece.binarytrees.BinaryTreeImpl;
import com.sparta.reece.binarytrees.BinaryTreeRunner;
import com.sparta.reece.controller.ComplexityChecker;
import com.sparta.reece.controller.UserInput;
import com.sparta.reece.exceptions.ChildNotFoundException;
import com.sparta.reece.exceptions.InvalidOptionException;
import com.sparta.reece.exceptions.ObjectConversionException;
import com.sparta.reece.exceptions.PrimitiveConversionException;
import com.sparta.reece.logger.Log;
import com.sparta.reece.model.SortFactory;
import com.sparta.reece.sorters.SortRunner;
import com.sparta.reece.sorters.Sorter;
import com.sparta.reece.utilities.Converter;
import com.sparta.reece.view.Display;
import com.sparta.reece.view.Printer;

import java.lang.Math;
import java.util.Arrays;

/**
 * @author Reece Louch
 */

public class Starter {
    public static void start() {
        Log log = new Log();
        boolean active = true;
        boolean firstRun = true;
        while (active) {
            try {
                int answer = UserInput.getChoice(firstRun);
                switch (answer) {
                    case 1:
                        SortRunner.startSorting();
                        break;
                    case 2:
                        BinaryTreeRunner.startBinaryTrees();
                        break;
                    case 3:
                        ComplexityChecker.startComplexityCheck();
                        break;
                    case 4:
                        active = false;
                }
                firstRun = false;
            } catch (Error error) {
                log.logFatal(error);
                System.exit(-1);
            }
        }

    }
}
