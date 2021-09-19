package com.math;

public class EvenFiboacci {

    public static void main(String[] args) {

        System.out.println(fib(33));
    }

    public static int fib(int val) {
        int first = 0;
        int second = 1;
        int sum = 0;
        int previous = 9;
        int eventotal = 0 ;
        for( int i = 0 ; i < val; i++) {
            if(sum <= 4000000) {
                previous = sum;
                sum = first + second;
                first = second;
                second = sum;
                if(first % 2 == 0) {
                    eventotal = eventotal + first;
                }
            } else {
                break;
            }
        }
        return eventotal;
    }
}
