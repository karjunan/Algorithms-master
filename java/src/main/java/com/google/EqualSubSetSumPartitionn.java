package com.google;

import java.util.List;

public class EqualSubSetSumPartitionn {

    public static void main(String[] args) {

        int [] arr  = new int[] {1,1,9,4,3};
    }

    public static void equalSubSetSumPartition(int [] arr)  {

    }

    public static void helper(int [] arr, int mid, int current
            ,int pos, List<List<Integer>> list, List<Integer> include) {

        if(pos == arr.length-1) {
            return;
        }

        if(current < mid) {
            current = current + arr[pos];
            include.add(arr[pos]);
            helper(arr,mid, current,pos++,list,include);
        }

    }
}
