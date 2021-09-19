package com.google;

public class MaximumSumSubarray {

    public static void main(String[] args) {

        int [] arr = new int[] {4,2,1,7,8,1,2,8,1,0};
//        int [] arr = new int[] {4,2,2,9,4};
        int length = 3;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int j = 0;
        while(j < length) {
            currentSum = currentSum + arr[j];
            j++;
        }
        System.out.println(currentSum + " ===>>  " + maxSum);
        maxSum = Math.max(maxSum, currentSum);

        for( int i = 2 ; i < arr.length-1; ) {
            currentSum = currentSum - arr[i - (length-1)];
            currentSum = currentSum + arr[++i];
            maxSum = Math.max(maxSum, currentSum);
            System.out.println(currentSum + " ===>>  " + maxSum+ " :: " +i);

        }
        System.out.println("Max element is =>> " + maxSum);

    }



}
