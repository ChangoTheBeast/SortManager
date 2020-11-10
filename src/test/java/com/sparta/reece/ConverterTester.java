package com.sparta.reece;

import com.sparta.reece.exceptions.ObjectConversionException;
import com.sparta.reece.exceptions.PrimitiveConversionException;
import com.sparta.reece.utilities.Converter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTester {
    @Test
    @DisplayName("int[] to Integer[] test:")
    public void primitiveIntToWrappedIntegerTest() throws PrimitiveConversionException {
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, Converter.toObject(new int[] {1, 2, 3, 4, 5}));
    }
    @Test
    @DisplayName("Integer[] to int[] test:")
    public void wrappedIntegerToPrimitiveIntTest() throws ObjectConversionException {
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5}, Converter.toPrimitive(new Integer[]{1,2,3,4,5}));
    }
    @Test
    @DisplayName("float[] to Double[] test:")
    public void primitiveFloatToWrappedDoubleTest() throws PrimitiveConversionException {
        Assertions.assertArrayEquals(new Double[]{1.0, 2.0, 3.0, 4.0, 5.0}, Converter.toObject(new float[] {1.0f, 2.0f, 3.0f, 4.0f, 5.0f}));
    }
    @Test
    @DisplayName("float[] to double[] test:")
    public void primitiveFloatToPrimitiveDoubleTest() throws PrimitiveConversionException {
        Assertions.assertArrayEquals(new double[]{1.0,2.0,3.0,4.0,5.0}, Converter.toDouble(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}));
    }
    @Test
    @DisplayName("Double[] to Float[] test:")
    public void wrappedDoubleToWrappedFloatTest() throws ObjectConversionException {
        Assertions.assertArrayEquals(new Float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, Converter.toFloat(new Double[]{1.0, 2.0, 3.0, 4.0, 5.0}));
    }
    @Test
    @DisplayName("Float[] to float[] test:")
    public void wrappedFloatToPrimitiveFloatTest() throws ObjectConversionException, PrimitiveConversionException {
        Assertions.assertArrayEquals(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, Converter.toPrimitive(new Float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}));
    }
    @Test
    @DisplayName("double[] to Double[] test:")
    public void primitiveDoubletWrappedDoubleTest() throws PrimitiveConversionException {
        Assertions.assertArrayEquals(new Double[]{1.0, 2.0, 3.0, 4.0, 5.0}, Converter.toObject(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}));
    }
    @Test
    @DisplayName("Double[] to double[] test:")
    public void wrappedDoubleToPrimitiveDoubleTest() throws ObjectConversionException {
        Assertions.assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, Converter.toPrimitive(new Double[]{1.0, 2.0, 3.0, 4.0, 5.0}));
    }
    @Test
    @DisplayName("long[] to Long[] test:")
    public void primitiveLongToWrappedLongTest() throws PrimitiveConversionException {
        Assertions.assertArrayEquals(new Long[]{1L,2L, 3L,4L,5L}, Converter.toObject(new long[]{1L, 2L, 3L, 4L, 5L}));
    }
    @Test
    @DisplayName("Long[] to long[] test:")
    public void wrappedLongToPrimitiveLong() throws ObjectConversionException {
        Assertions.assertArrayEquals(new long[]{1L,2L, 3L,4L,5L}, Converter.toPrimitive(new Long[]{1L,2L, 3L,4L,5L}));
    }

}
