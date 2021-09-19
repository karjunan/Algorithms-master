package com.algorithms.arrayproblems;

import java.text.DecimalFormat;

public class FloatPointingNumber {

    public static void main(String[] args) {
        DecimalFormat df2 = new DecimalFormat(".######################################### ");
        double d  = 1.4;
        double e  = 1.5;
        System.out.println(df2.format(d));
        System.out.println(df2.format(e));

    }
}
