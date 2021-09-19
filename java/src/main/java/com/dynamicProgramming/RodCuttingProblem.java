package com.dynamicProgramming;

import java.util.Arrays;

public class RodCuttingProblem {

    static int[] value = { 2, 3, 7, 8, 9 };
    static int length = 5;
    public static void main(String[] args) {

        int result = profit(value,length);
        int result1 = profitDP(value,length);

        System.out.println( "Non DP >> " + result);
        System.out.println(result1);

    }


    public static int profitDP(int [] value, int length) {

        int [] solution = new int[length + 1];
        solution[0] = 0;

        for( int i = 1 ; i <= length ; i++) {
            int min = -1;
            for( int j = 0; j < i; j++) {
                min = Math.max(min, value[j] + solution[i - (j+1)]);
                solution[i] = min;
                System.out.println("i :" + i + "  >>  " +                 Arrays.toString(solution));
            }

        }
        return solution[length];

    }


    public static int profit(int [] value, int length) {
        if(length <= 0) {
            return 0;
        }

        int min = -1;
        for( int i = 0 ; i < length; i++ ) {
            min = Math.max(min, value[i] + profit(value, length - (i + 1)));
        }

        return min;
    }

    public static int rodCuttingIterative(int val , int [] arr) {

        int [] temp = new int[arr.length];

        for( int i = 1; i <= val; i++) {

            int t = Integer.MIN_VALUE;

            for( int j = 1 ; j <= i; j++) {

                t = Math.max(t, arr[j] + temp[i-j]);
            }
            temp[i] = t;
        }

        return temp[arr.length-1];

    }



    public static int rodCutting(int val, int [] arr) {

        if( val == 0 ) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        for( int i = 1; i <= val; i++ ) {
            int v = rodCutting(val-i,arr);
            result = Math.max(result, arr[i] + v );

        }

        return result;
    }

}
