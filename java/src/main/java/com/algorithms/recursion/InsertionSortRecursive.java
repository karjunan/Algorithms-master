package com.algorithms.recursion;

import java.util.Arrays;

public class InsertionSortRecursive {

    public static void main(String [] args) {

        int [] arr = {4,3,2,10,12,1,5,6};

        System.out.println(Arrays.toString(arr));
        insertionSortRecursive(arr,1);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertionSortRecursive(int [] arr, int n) {

        if(n == arr.length) {
            return;
        }

        int i = n;
        while( i > 0) {

            if(arr[i] < arr[i-1] ) {
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] =  temp;
            } else {
                break;
            }
            i--;
        }
        System.out.println(Arrays.toString(arr));
        insertionSortRecursive(arr,n+1);

    }

}
