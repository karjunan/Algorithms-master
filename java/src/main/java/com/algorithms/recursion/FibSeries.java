package com.algorithms.recursion;

import java.util.Arrays;

public class FibSeries {
    public static void main(String [] args) {

        int n = 15;
        int result = fibRecursion(n);
        System.out.println("fib is -> "+ result);

        int [] arr = new int[n+2];
        result = fibRecursion(n,arr);
        System.out.println(" fib rec  -> "+ result);

    }


    public static int fib(int n) {

        int [] arr = new int[n+2];

        arr[0] = 0;
        arr[1] = 1;

        if(n == 0) {
            return arr[0];
        } else if(n == 1) {
            return arr[1];
        }

        for( int i = 2 ; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            // System.out.println(Arrays.toString(arr));
        }

        return arr[n-1];
    }


    public static int fibOptimized(int n) {

        int first = 0;
        int second = 1;
        int val = 0;
        for( int i = 2 ; i < n; i++)  {
            val = first + second;
            first = second;
            second = val;
        }

        return val;

    }

    public static int fibRecursion(int n) {

        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }

        return fibRecursion(n-1)+fibRecursion(n-2);
    }

    public static int fibRecursion(int n, int [] arr) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }

        if(arr[n] != 0) {
            return arr[n];
        }

        int val = fibRecursion(n-1, arr);
        int val1 = fibRecursion(n-2, arr);
        System.out.println(Arrays.toString(arr));
        arr[n] = val + val1;

        return  arr[n];

    }
}
