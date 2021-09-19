package com.google;

public class MinimumWidowSum {

    public static void main(String[] args) {
        int [] arr = new int[] {4,2,2,7,8,1,2,8,1,0};
        int target = 8;

        int currentWindowSum=0;
        int minWindow = Integer.MAX_VALUE;
        int windowStart = 0;
        for(int windowEnd = 0 ; windowEnd < arr.length; windowEnd++) {
            currentWindowSum = currentWindowSum + arr[windowEnd];

            while(currentWindowSum >= target) {
                minWindow = Math.min(minWindow,windowEnd-windowStart+1);
                currentWindowSum = currentWindowSum - arr[windowStart];
                windowStart++;
            }
            if(minWindow == 1) {
                break;
            }
            System.out.println("Min Window at present is => " + minWindow);
        }
        System.out.println("Final Result is  => " + minWindow);
    }


}
