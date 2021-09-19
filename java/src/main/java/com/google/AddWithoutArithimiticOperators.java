package com.google;

public class AddWithoutArithimiticOperators {

    public static void main(String[] args) {
        int a = 7;
        int b = 1;

        int c = a << 1;

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(c) + " : " + c );
    }
}
