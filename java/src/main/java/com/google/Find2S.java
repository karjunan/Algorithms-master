package com.google;

public class Find2S {

    public static void main(String[] args) {

        System.out.println(findTwo(25));
    }

    public static int findTwo(int nums) {

        int counter = 0;

        for(int i = 2 ; i <= nums; i++) {

            int val = i;

            while(val != 0) {
                int divisor = val%10;
                val = val / 10;
                if(divisor == 2) {
                    counter++;
                }

            }

        }

        return counter;

    }

}
