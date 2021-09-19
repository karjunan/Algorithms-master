package com.algorithms.arrayproblems;

import java.util.Arrays;

public class SmallestDifference {


    static int [] arr = {-1, 5, 10, 20, 3};
    static int [] arr1 = {26, 134, 135, 15, 17};
    // 0,   10,  20,   25,  2000
    //1005, 1006,1014, 1031,1032

    public static void main(String [] args) {

        int [] result = smallestDifference(arr,arr1);
        System.out.println(Arrays.toString(result));
    }


    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int size = 0;
        int [] result = new int[2];
        while( i < arrayOne.length && j < arrayTwo.length) {
            if(arrayOne[i] <= arrayTwo[j]) {
                size = arrayTwo[j] - arrayOne[i];
                if(size < min) {
                    min = size;
                    result[0] = arrayOne[i];
                    result[1] = arrayTwo[j];

                }

                i++;
            } else if(arrayOne[i] >= arrayTwo[j]) {
                size = arrayOne[i] - arrayTwo[j];
                if(size < min) {
                    min = size;
                    result[1] = arrayOne[i];
                    result[0] = arrayTwo[j];

                }

                j++;
            }
        }

        return result;


    }

}
