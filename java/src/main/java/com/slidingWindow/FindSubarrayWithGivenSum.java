package com.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindSubarrayWithGivenSum {

    public static void main(String[] args) {
        int [] arr = new int[] {2,3,2,4,5,1,7,6,3,7};
        int sum = 10;
        System.out.println("Position is => " + findSubarray(arr,sum));
    }

    public static List<Integer> findSubarray(int [] arr, int sum) {
        List<Integer> list = new ArrayList<>();
        int windowStart = 0;
        int currentSum = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentSum = currentSum + arr[windowEnd];

            while(currentSum >= sum) {
                if(currentSum == sum) {
                    list.add(windowStart);
                    list.add(windowEnd);
                    System.out.println(list);
                    return list;
                }
                currentSum = currentSum - arr[windowStart++];
            }
            System.out.println(currentSum);
        }
        return list;
    }
}
