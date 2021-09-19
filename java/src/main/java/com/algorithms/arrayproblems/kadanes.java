package com.algorithms.arrayproblems;

public class kadanes {

    static int [] arr = {3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4};

    public static void main(String[] args) {
        int result = kadanesAlgorithm(arr);
        System.out.println("Result is : " + result);
    }

    public static int kadanesAlgorithm(int[] array) {
        if(array.length == 1) {
            return array[0];
        }

        int max = array[0];
        int localMax = array[0];
        for( int i = 1 ; i < array.length; i++) {

            localMax = Math.max(array[i] , localMax + array[i]);
            max = Math.max(max,localMax);
        }

        return max;
    }
}
