package com.algorithms.algoExpert;

import java.util.Arrays;

public class MinimumJumps {


    public static void main(String [] args) {

        // int  [] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int [] arr = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};

        int result = minJumps(arr);
        System.out.println("Result is -> " + result);
    }

    public static int minJumps(int [] arr) {

        int [] dp = new int[arr.length];
        for( int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < arr.length;i++) {

            int j = arr[i];
            int k = i;
            while(k <= j + i && k < arr.length) {
                dp[k] = Math.min(dp[k],dp[i]+1 );
                k++;
            }
            System.out.println(Arrays.toString(dp) +" = " + arr[i] );
        }

        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }


}
