package com.algorithms.algoExpert;

import java.util.Arrays;

public class MinimumCoinsToMakeChange {


    static int [] denoms = {2,4};
    static int result = 7;

    public static void main(String args [] ) {
        int res = numberOfWaysToMakeChange(result,denoms);
        System.out.println("Result is -> " + res);

    }


    public static int numberOfWaysToMakeChange(int n, int[] denoms) {

        int [] arr = new int[n+1];
        for( int i = 0 ; i < arr.length; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        arr[0]= 0;
        for( int i = 0; i < denoms.length; i++ ) {
            for( int j = 1; j < arr.length; j++) {
                if( denoms[i] <= j ) {
                    int val = j - denoms[i];
                    if(arr[val] != Integer.MAX_VALUE) {
                        arr[j] = Math.min(arr[j], (arr[val]+1));
                    }
                    System.out.println(Arrays.toString(arr) +  " -> " +val);
                }
            }

        }

        if(arr[n] == Integer.MAX_VALUE) {
            return -1;
        }
        return arr[n];
    }
}
