package com.google;

import java.util.Arrays;

public class MaximumSubSetSumNonAdjacency {

    public static void main(String[] args) {

        int [] arr = new int [] {4,1,1,4,2,1};
//        int [] arr = new int [] {7,10,12,7,9,14};

        int sum = maxSubSetSum(arr);
        System.out.println("Max sum is => " + sum);
    }

    public static int maxSubSetSum(int [] arr) {
        int [] solArr = new int[arr.length];
        if (arr.length < 2) {
            return Integer.max(arr[0],arr[1]);
        }
        solArr[0] = arr[0];
        solArr[1] = Integer.max(solArr[0],arr[1]);

        int start = 2 ;
        while(start < arr.length) {
            solArr[start] = Integer.max(solArr[start-1],(solArr[start-2]+arr[start]));
            start++;
        }
        System.out.println(Arrays.toString(solArr));
        return solArr[arr.length-1];
    }
}
