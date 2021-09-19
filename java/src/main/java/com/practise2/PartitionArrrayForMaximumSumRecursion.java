package com.practise2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class PartitionArrrayForMaximumSumRecursion {

    public static void main(String[] args) {
        int [] arr = {1,15,7,9,2,5,10};
        HashMap<Integer,Integer> map=new HashMap<>();
        int result = helper(arr,0,3, map);
        System.out.println("What is the result => " + result);

    }

    public static int helper(int [] arr, int idx, int k, HashMap<Integer,Integer> map) {

        if(idx >= arr.length) {
            return 0;
        }

        if(map.containsKey(idx)) {
            return map.get(idx);
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i = idx; i < arr.length; i++) {

            if(i - idx + 1 > k) {
                break;
            }
            int maxNum=getMaxNum(idx,i,arr);
            int totalSum=maxNum*(i-idx+1);
            int nextPartitionSum=helper(arr,i+1,k, map);
            maxSum=Math.max(maxSum,totalSum+nextPartitionSum); // store the max value

        }
        map.put(idx,maxSum);
        return maxSum;
    }

    public static int getMaxNum(int start,int end,int[] arr) {
        int maxNum=0;


        for(int i=start;i<=end;i++){
            maxNum=Math.max(maxNum,arr[i]);
        }


        return maxNum;
    }
}
