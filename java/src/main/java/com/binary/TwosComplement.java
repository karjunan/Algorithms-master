package com.binary;

public class TwosComplement {

    public static void main(String[] args) {


        // 8 bit
        // -128 to 127 - Signed
        // 1 1 1 1 1 1 1 1  - 256 unisigned
        // 1 0 0 0 0 0 0 0   = -1

        int num = -2147483648;
        int num1 = -1;

        byte b1 = 127;
        byte b2 = 1;

        int c = b1/b2;

        int ans = num/num1;

//        System.out.println(Integer.MAX_VALUE);
        System.out.println(ans);
    }
}
