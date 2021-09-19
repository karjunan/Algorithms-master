package com.backtracking;

public class PrintDecimals {

    public static void main(String [] args) {

        printDecimal(3,"");

    }

    public static void printDecimal(int digits, String prefix) {

        if (digits == 0) {
            System.out.println(digits + " --[" + prefix + "]");
        } else {

//            for (int i = 0; i < 10; i++) {
                printDecimal(digits - 1, prefix + Integer.toString(0));
                printDecimal(digits - 1, prefix + Integer.toString(1));
                printDecimal(digits - 1, prefix + Integer.toString(2));
                printDecimal(digits - 1, prefix + Integer.toString(4));

                //            }
        }
    }
}
