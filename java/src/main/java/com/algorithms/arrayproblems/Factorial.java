package com.algorithms.arrayproblems;

class  Factorial {

    public static void main(String [] args) {
        int val = 3;
        System.out.println(fact(val));

    }

    public static int fact(int n ) {
        if ( n == 1) {
            return 1;
        } else  {
            return n * fact(n -1);
        }
    }

}