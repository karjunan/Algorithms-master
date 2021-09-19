package com.algorithms.recursion;

public class DecimalToBinaryRecursive {

    public static void main(String [] ar) {

        int val = 5;
        binary(val);
    }

    public static void binary(int val) {

        if(val == 0 ){
            return;
        }

        binary(val/2);
        System.out.print(val%2);
    }

}
