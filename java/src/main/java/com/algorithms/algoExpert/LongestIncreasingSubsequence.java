package com.algorithms.algoExpert;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String [] args) {

        // int [] arr = {8,12,2,3,15,5,7};
        // int [] arr = {1,2,3,4,5};
        int [] arr = {-5,-4,-3,-2,-1};
        ArrayList<ArrayList<Integer>> result = longestIncSubsequence(arr);
        System.out.println("Longest subsequence " + result);

    }

    public static ArrayList<ArrayList<Integer>> longestIncSubsequence(int [] arr) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int [] sum = new int[arr.length];
        int [] seq = new int[arr.length];
        for( int i = 0 ; i < seq.length;i++) {
            seq[i] = Integer.MIN_VALUE;
            sum[i] = Integer.MIN_VALUE;
        }
        sum[0] = arr[0];
        int sums = sum[0];
        int index = 0;
        for( int i = 1 ; i < arr.length; i++) {
            for(int j = i; j >= 0; j--) {
                if(arr[i] > arr[j]) {
                    int max = Math.max(sum[i],arr[i]+sum[j]);
                    System.out.println();
                    if(max == (arr[i]+sum[j])) {
                        seq[i] = j;
                    }
                    sum[i] = max;

                } else {
                    int max = Math.max(arr[i],sum[i]);
                    sum[i] = max;
                }
            }
            if(sum[i] > sums) {
                sums = sum[i];
                index = i;
            }

        }
        System.out.println(Arrays.toString(sum) + " = " + sums + " = "  + index);
        System.out.println(Arrays.toString(seq));

        ArrayList<Integer> sumList = new ArrayList<Integer>();
        sumList.add(sums);
        list.add(sumList);
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(arr[index]);
        int k = index;
        while( k >= 0 & seq[k] != Integer.MIN_VALUE) {
            int val = seq[k];
            lst.add(arr[val]);
            k = val;

        }
        lst.sort((x,y)-> Integer.compare(x,y));
        list.add(lst);
        System.out.println(list);
        return list;
    }
}
