package com.bit;

public class ReverseBits {

    public static void main(String[] args) {

        int val = 5;
        System.out.println("Val 1   => " + Integer.toBinaryString(val));
        int and = 1;
        int result = (val & and);

        System.out.println("And operation => " + Integer.toBinaryString(result));

        val = val >> 1;
        System.out.println("Val 2 shifted => " + Integer.toBinaryString(val));
        result = (val & and);

        System.out.println("And operation => " + Integer.toBinaryString(result));

    }
}
