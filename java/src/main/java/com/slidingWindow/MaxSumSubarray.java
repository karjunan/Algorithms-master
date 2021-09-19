package com.slidingWindow;

public class MaxSumSubarray {

    public static void main(String[] args) {
        int [] arr = new int [] {4,2,1,7,8,1,2,8,1,0};
        int k = 3;
        System.out.println("Max arry is => " + maxSubSubarray(arr,k));
    }

    public static int maxSubSubarray(int [] arr, int k ) {
        int currentSum = 0;
        int max = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowEnd;
        for(windowEnd = 0 ; windowEnd < k; windowEnd++) {
            currentSum = currentSum + arr[windowEnd];
        }
        max = Math.max(currentSum,max);
        for(; windowEnd < arr.length; windowEnd++) {
            currentSum = currentSum + arr[windowEnd];
            currentSum = currentSum - arr[windowStart++];
            System.out.println(currentSum + " :::  " + max);
            max = Math.max(currentSum,max);
        }

        return max;
    }
}
