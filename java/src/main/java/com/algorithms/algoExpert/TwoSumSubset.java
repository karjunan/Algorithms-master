package com.algorithms.algoExpert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSumSubset {


    // static int [] arr = {3,5,-4,8,11,-1,1,6};
    static int [] arr = {-21,301,12,4,65,56,210,356,9,-47};
    static int targetSum = 164;

    public static void main(String [] args) {

        int [] result = twoNumberSum(arr,targetSum);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {

        Set<Integer> set = new HashSet<>();
        for( int i = 0 ; i < array.length; i++ ) {
            set.add(array[i]);
        }

        int [] arr = new int[2];
        for( int i = 0 ; i < array.length; i++ ) {
            int temp = targetSum - array[i];
            if(set.contains(temp) && temp != array[i]) {
                arr[0] = array[i];
                arr[1] = temp;
                Arrays.sort(arr);
                return arr;
            }
        }
        return new int[0];
    }



}
