package com.math;

public class PrimeNumbers {

    public static void main(String[] args) {

        System.out.println("Number is prime : " + prime(1112l));
    }

    public static Boolean prime(Long l) {

        for(long i = 2 ; i < l; i++ ) {
            if((l % i) != 0) {
                continue;
            }

            if(l % i == 0) {
                return false;
            }
        }
        return true;
    }
}
