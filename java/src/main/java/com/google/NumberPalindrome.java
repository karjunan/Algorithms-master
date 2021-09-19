package com.google;

public class NumberPalindrome {

    public static void main(String[] args) {

        double val = isPalindrome(11231,0);
        System.out.println("Value is " + val);
    }

    public static double isPalindrome(int num1,int remainder) {

        if(num1 == 0) {
            return remainder;
        }

        remainder = (remainder * 10) + (num1 % 10);

        return isPalindrome(num1/10 , remainder);
    }
}
