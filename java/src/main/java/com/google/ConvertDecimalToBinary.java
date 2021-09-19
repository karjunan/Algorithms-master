package com.google;

public class ConvertDecimalToBinary {

    public static void main(String[] args) {

        String binary = "111";
        int val = convertBinaryToDecimal(binary);
        System.out.println("Val is => "+ val );
    }

    public static int convertBinaryToDecimal(String s) {

        int val = 0;
        int digit=0;
        for(int i = s.length()-1 ; i >=0; i--) {
            val = val + (Character.digit(s.charAt(i),10) * (int)Math.pow(2,digit));
            digit++;
        }
        return val;

    }
}
