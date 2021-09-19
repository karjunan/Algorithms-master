package com.algorithms.arrayproblems;

import java.util.Arrays;

public class MinRewards {


    public static void main(String [] args) {

        int [] arr = {8,4,2,1,3,6,7,9,5};
        int result = minRewards(arr);
        System.out.println("Result is : "+ result);
    }

    public static int minRewards(int [] arr) {
        int [] temp = new int[arr.length];
        for( int i = 0 ; i < temp.length ;i++) {
            temp[i] = 1;
        }

        for( int i = 1 ; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) {
                continue;
            } else {
                temp[i] = Math.max(temp[i], temp[i-1] + 1);
            }
        }

        for( int i = arr.length-2; i >= 0; i--) {
            if(arr[i] < arr[i+1]) {
                continue;
            } else {
                temp[i] = Math.max(temp[i],temp[i+1]+1);
            }

        }

        System.out.println(Arrays.toString(temp));
        return Arrays.stream(temp).sum();

    }

}
