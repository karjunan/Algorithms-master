package com.custom;

import java.math.BigInteger;

public class BigInt {

//
//    private String first;
//    private String second;
//
//    public BigInt(String first , String second) {
//        this.first = first;
//        this.second = second;
//    }

    public String add(String first, String second) {
        char sign = first.charAt(0);
        char sign1 = second.charAt(0);
        int val = first.length();
        int val1 = second.length();
        int result = val - val1;
        StringBuffer resultBuffer = new StringBuffer();

        int firstPointer = first.length() - 1;
        int secondPointer = second.length() -1;


        StringBuffer finalOutput = new StringBuffer();
        if(( sign == '-' && sign1 == '-') || (sign > 48 && sign < 57 )
                || ( sign == '+' && sign1 == '+'))  {
            int remainder = 0;
//            int result = 0;
            while( firstPointer >= 0 && secondPointer >= 0 ) {
                result = Character.getNumericValue(first.charAt(firstPointer)) +
                                Character.getNumericValue(second.charAt(secondPointer)) + remainder;
                System.out.println("Result of Addition => " + result);
                var modValue = result % 10;
                finalOutput.append(modValue);
                remainder = result/10;
                System.out.println("Appended String => " + finalOutput);
                firstPointer--;
                secondPointer--;
            }


            /*
                99
                 9
                 0


             */

            while(firstPointer >= 0 ) {
                result = result + Character.getNumericValue(first.charAt(firstPointer)) + remainder;


            }

        }

        System.out.println((int)sign + " , " + (int) sign1);
        BigInteger bi;
        return finalOutput.reverse().toString();
    }

    public String substract( String first, String second)  {

        return null;
    }

}
