package com.algorithms.algoExpert;

import java.util.Arrays;

public class ThreeLargestSum {


    static int [] arr = {1,2,3};
    public static void main(String args [] ) {

        int [] result = findThreeLargest(arr);
        System.out.println(Arrays.toString(result));
    }



    public static int [] findThreeLargest(int [] arr) {

        int[] result = new int[3];
        for( int i = 0 ; i < result.length;i++) {
            result[i] = Integer.MIN_VALUE;
        }
        for( int i = 0 ; i < arr.length; i++) {
            int j = 0;
            if(arr[i] >= result[j]) {
                int small = arr[i];
                update(j,result,small);
            } else {
                int small = arr[i];
                while(j < result.length && small < result[j] ) {
                    j++;
                }
                update(j,result,small);
            }

        }
        Arrays.sort(result);
        return result;
    }

    public static void update(int j, int[] result, int small) {
        while(j < result.length && small >= result[j] ) {
            int temp = result[j];
            result[j] = small;
            small = temp;
            j++;
        }
    }

}
