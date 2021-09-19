package com.algorithms.arrayproblems;

public class Fibonacci {


    public static void main(String[] ar) {
        int n = 11;
        int [] arr = new int[n+1];
        System.out.println( " Output is : " + fib(n,arr));
    }

    public static int fib(int n, int[] arr) {

        if (n == 1 || n == 2) {
            return 1;
        }

        if (arr[n] != 0) {
            return arr[n];
        }


        int result = fib(n - 1, arr) + fib(n - 2, arr);
        arr[n] = result;
        return result;

    }
}
