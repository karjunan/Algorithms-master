package com.slidingWindow;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        int s = 7;
        int [] nums = new int[] {2,3,1,2,4,3};
        int result = minSubArrayLen(s,nums);
        System.out.println("Result is => " + result);
    }

    public static int minSubArrayLen(int s, int[] nums) {

        int min = Integer.MAX_VALUE;
        int sum = 0;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {

           if(sum < s) {
               sum = sum + nums[windowEnd];
           }
           while(sum >= s) {
                    min = Math.min(min,windowEnd - windowStart + 1);
                    sum = sum - nums[windowStart++];
            }
            System.out.println("Min value is => " + min);
        }

        return min;
    }
}
