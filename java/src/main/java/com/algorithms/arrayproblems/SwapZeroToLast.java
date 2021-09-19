package com.algorithms.arrayproblems;

import java.util.Arrays;

public class SwapZeroToLast {

    static int arr[] =  {1, 2, 0, 0, 0, 3, 6};

    public static void main(String [] args) {
        System.out.println(Arrays.toString(arr));
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
        rearrange1(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void rearrange1(int [] arr) {

        int count = 0;
        for( int i = 0 ; i < arr.length; i++) {
            if(arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }

        for( int i = count ; i < arr.length;i++) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int [] arr) {

        int pivot = 0;

        int i = 0;
        int j = arr.length - 1 ;

        while(i < j) {

            while(arr[i] > 0 && i < j) {
                i++;
            }

            while(arr[j] == 0 && i < j) {
                j--;
            }

            if(arr[i] == 0 && arr[j] != 0 ) {
                swap(i,j,arr);
                i++;
                j--;
            }
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void swap(int i , int j, int [] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
