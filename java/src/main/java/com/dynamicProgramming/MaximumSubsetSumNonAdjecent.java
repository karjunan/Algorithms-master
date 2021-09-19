package com.dynamicProgramming;

import java.util.Arrays;

public class MaximumSubsetSumNonAdjecent {

    static int [] arr = {7,10,12,7,9,14};

    public static void main(String [] args) {

        int result = maxSubSetNonAdjacent(arr);

        System.out.println("Result is " + result);
    }

    public static int maxSubSetNonAdjacent(int [] arr) {

        if(arr.length < 2) {
            return arr[0];
        }

        if(arr.length < 3) {
            return Math.max(arr[0],arr[1]);
        }

        int [] result = new int[arr.length];

        result[0] = arr[0];
        result[1] = Math.max(arr[0],arr[1]);

        for( int i = 2 ; i < arr.length; i++) {

            int res = Math.max(result[i-1], result[i-2]+arr[i]);
            result[i] = res;

        }

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(arr));

        return result[result.length-1];
    }


}
