package com.algorithms.algoExpert;

import java.util.Arrays;

public class CoinChangeProblem {


    static int [] denoms = {1,5,10,25};
    static int result = 10;

    public static void main(String args [] ) {
        int res = numberOfWaysToMakeChange(result,denoms);
        System.out.println("Result is -> " + res);

    }


    public static int numberOfWaysToMakeChange(int n, int[] denoms) {

        int [] max = new int[n+1];
        max[0] = 1;
        for( int i = 0; i < denoms.length; i++) {
            for( int j = 0; j < max.length; j++) {
                if(denoms[i] <= j){
                    int val = (j - denoms[i]);
                    // System.out.println(val + " - " + j + " - " + denoms[i]);
                    max[j] = max[j] + max[val];
                }
            }
            System.out.println(Arrays.toString(max));

        }
        return max[n];
    }
}
