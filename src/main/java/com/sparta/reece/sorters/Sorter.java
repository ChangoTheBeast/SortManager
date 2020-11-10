package com.sparta.reece.sorters;

import com.sparta.reece.utilities.Converter;
import com.sparta.reece.logger.Log;
import com.sparta.reece.view.Printer;
import com.sparta.reece.exceptions.MergingException;
import com.sparta.reece.exceptions.ObjectConversionException;
import com.sparta.reece.exceptions.PrimitiveConversionException;
import com.sparta.reece.exceptions.SortingException;

/**
 * @author Reece Louch
 */

public interface Sorter {
    public default int[] sort(int[] array) {
        Log log = new Log();
        try {
            Integer[] integerArray = Converter.toObject(array);
            Integer[] sortedArray = this.sort(integerArray);
            return Converter.toPrimitive(sortedArray);
        } catch (ObjectConversionException | PrimitiveConversionException | SortingException | MergingException e) {
            log.logException(e);
            Printer.printError(e);
        }
        return null;
    }
    public default float[] sort(float[] array) {
        Log log = new Log();
        try {
            Double[] doubleArray = Converter.toObject(array);
            Double[] sortedArray = this.sort(doubleArray);
            Float[] floats = Converter.toFloat(sortedArray);
            return Converter.toPrimitive(floats);
        } catch (PrimitiveConversionException | ObjectConversionException | SortingException | MergingException e) {
            log.logException(e);
            Printer.printError(e);
        }
        return null;
    }
    public default double[] sort(double[] array) {
        Log log = new Log();
        try {
            Double[] doubleArray = Converter.toObject(array);
            Double[] sortedArray = this.sort(doubleArray);
            return Converter.toPrimitive(sortedArray);
        } catch (ObjectConversionException | PrimitiveConversionException | SortingException | MergingException e) {
            log.logException(e);
            Printer.printError(e);
        }
        return null;
    }
    public default long[] sort(long[] array) {
        Log log = new Log();
        try {
            Long[] longArray = Converter.toObject(array);
            Long[] sortedArray = this.sort(longArray);
            return Converter.toPrimitive(sortedArray);
        } catch (ObjectConversionException | PrimitiveConversionException e) {
            log.logException(e);
            Printer.printError(e);
        }
        return null;
    }
    public abstract <T extends Comparable<T>> T[] sort(T[] array) throws SortingException;
}
