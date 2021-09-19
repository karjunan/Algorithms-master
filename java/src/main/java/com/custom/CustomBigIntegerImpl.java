package com.custom;

public class CustomBigIntegerImpl {

    /*
        String num1 = "3629273938"
        String num2 = "92639393223"

        109
          9
        118

        (- - -) = +
        (+ + + ) = +
        (- + - ) = -
        (- + + ) = -

        i) adding
        ii)subtract
        iii)valueOf
     */

    public static void main(String[] args) {

        BigInt bigInt = new BigInt();
        String f = "9";
        String s = "2";
        String result = bigInt.add(f,s);
        System.out.println("Result is => " + result);
    }

}
