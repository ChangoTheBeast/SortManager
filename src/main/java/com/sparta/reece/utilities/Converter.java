package com.sparta.reece.utilities;


import com.sparta.reece.exceptions.ObjectConversionException;
import com.sparta.reece.exceptions.PrimitiveConversionException;
import java.util.Arrays;

/**
 * @author Reece Louch
 */

public class Converter {
    public static Integer[] toObject(int[] array) throws PrimitiveConversionException {
        if (array == null) {
            throw new PrimitiveConversionException("Cannot convert null into Integer array");
        }
        return Arrays.stream(array).boxed().toArray(Integer[]::new);
    }
    public static int[] toPrimitive(Integer[] array) throws ObjectConversionException {
        if (array == null) {
            throw new ObjectConversionException("Cannot convert null into int array");
        }
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }
    public static Double[] toObject(float[] array) throws PrimitiveConversionException {
        if (array == null) {
            throw new PrimitiveConversionException("Cannot convert null into Double array");
        }
        double[] doubles = toDouble(array);
        return Arrays.stream(doubles).boxed().toArray(Double[]::new);
    }
    public static double[] toDouble(float[] array) throws PrimitiveConversionException {
        if (array == null) {
            throw new PrimitiveConversionException("Cannot convert null into double array");
        }
        double[] doubles = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            doubles[i] = (double) array[i];
        }
        return doubles;
    }
    public static Float[] toFloat(Double[] array) throws ObjectConversionException {
        if (array == null) {
            throw new ObjectConversionException("Cannot convert null into Float array");
        }
        Float[] floats = new Float[array.length];
        for (int i = 0; i < array.length; i++) {
            floats[i] = array[i].floatValue();
        }
        return floats;
    }

    public static float[] toPrimitive(Float[] array) throws ObjectConversionException, PrimitiveConversionException {
        if (array == null) {
            throw new ObjectConversionException("Cannot convert null into Float array");
        }
        double[] doubles = Arrays.stream(array).mapToDouble(Float::floatValue).toArray();
        return toFloat(doubles);
    }

    private static float[] toFloat(double[] doubles) throws PrimitiveConversionException {
        if (doubles == null) {
            throw new PrimitiveConversionException("Cannot convert null into float array");
        }
        float[] floats = new float[doubles.length];
        for (int i = 0; i < doubles.length; i++) {
            floats[i] = (float) doubles[i];
        }
        return floats;
    }

    public static Double[] toObject(double[] array) throws PrimitiveConversionException {
        if (array == null) {
            throw new PrimitiveConversionException("Cannot convert null into Double array");
        }
        return Arrays.stream(array).boxed().toArray(Double[]::new);
    }

    public static double[] toPrimitive(Double[] array) throws ObjectConversionException {
        if (array == null) {
            throw new ObjectConversionException("Cannot convert null into double array");
        }
        return Arrays.stream(array).mapToDouble(Double::doubleValue).toArray();
    }

    public static Long[] toObject(long[] array) throws PrimitiveConversionException {
        if (array == null) {
            throw new PrimitiveConversionException("Cannot convert null into Long array");
        }
        return Arrays.stream(array).boxed().toArray(Long[]::new);
    }

    public static long[] toPrimitive(Long[] array) throws ObjectConversionException {
        if (array == null) {
            throw new ObjectConversionException("Cannot convert null into long array");
        }
        return Arrays.stream(array).mapToLong(Long::longValue).toArray();
    }
}
