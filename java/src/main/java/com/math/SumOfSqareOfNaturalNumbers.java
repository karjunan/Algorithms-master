package com.math;

import java.util.HashMap;
import java.util.Map;

public class SumOfSqareOfNaturalNumbers<T> {

    public static void main(String[] args) {

        System.out.println(sumOfSquareOfNNaturalNumbers(100));
    }


    public static long sumOfSquareOfNNaturalNumbers(int val) {
        long naturalSum = 0;
        long wholeSquared = 0;
        for (long i = 1; i <= val; i++) {
                naturalSum = naturalSum+Math.multiplyExact(i,i);
                wholeSquared = wholeSquared + i;
        }
        long result = Math.multiplyExact(wholeSquared,wholeSquared);
        return result - naturalSum;
    }
}
