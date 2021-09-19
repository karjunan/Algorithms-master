package com.algorithms.arrayproblems;

import java.util.Arrays;

public class AddPreviousValueArrayRecursion {

    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5,6};
        // 1,3,5,7,9,11
        System.out.println(Arrays.toString(arr));
        add(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static int add(int [] arr,int i) {

        if(i == 0) {
            return arr[i];
        }

        arr[i] = arr[i] + add(arr,i - 1);
        return arr[i];
    }
}
