package com.math;

public class ConvertNumberToString {


    public static void main(String[] args) {

        int number = 1234;

        while(number / 10 != 0) {
            number = number/10;
            int val = number%10;
            System.out.println("["+number+"]" + val);
            char ch = (char)val;
            System.out.println(ch-0);
        }

    }

}
