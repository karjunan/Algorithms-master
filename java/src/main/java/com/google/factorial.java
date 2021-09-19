package com.google;

public class factorial {
    public static void main(String[] args) {
        int n = 14;
        int result = fact(n);
        System.out.println("The factorial is => " + result);
        int finalResult = trailingZeros(result);
        System.out.println("The final result is => " + finalResult);
    }

    public static int fact(int num ) {
        int f = 1;
        for(int i = 1; i <= num; i++) {
            f= f * i;
        }
        return f;
    }

    public static int trailingZeros(int num) {

        int count = 0;
        while(num != 0) {
            int remainder = num % 10;
            if(remainder == 0) {
                count++;
            } else {
                return count;
            }
            num = num / 10;
        }
        return count;
    }
}
