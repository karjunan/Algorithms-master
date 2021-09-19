package com.slidingWindow;

public class SmallestSubarraySum {

    public static void main(String[] args) {
        int [] arr = new int[] {4,2,2,7,8,1,2,8,1,5};
        int k = 41;
        System.out.println("Smallest subarray size => " + smallestSubarrayWithSumGreaterThanOrEqualToK(arr,k) );
    }

    public static int smallestSubarrayWithSumGreaterThanOrEqualToK(int [] arr, int k) {
        int currentSum = 0;
        int min = Integer.MAX_VALUE;
        int windowStart = 0;
        for( int windowEnd = 0; windowEnd < arr.length; windowEnd++ ) {
            currentSum = currentSum + arr[windowEnd];
            System.out.println(currentSum + " ::: " + min );

            while(currentSum >= k && windowStart <= windowEnd ){
                min = Math.min(min,windowEnd - windowStart+1);
                currentSum = currentSum-arr[windowStart++];
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
