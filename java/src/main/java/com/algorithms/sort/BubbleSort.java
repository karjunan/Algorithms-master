package com.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int [] arr = {3,21,4,6,2,7};
        // 1,3,5,7,9,11
        // print(arr);
        bubbleSort(arr);
        System.out.println("Recursive Logic ------>>");
        int [] arr1 = {3,21,4,6,2,7};

        bubbleSortRec(arr1,arr.length-1);
    }


    public static void bubbleSortRec(int [] arr, int i) {

        if(i == 0) {
            return;
        }

        for( int j = 0 ; j < i ; j++) {
            if(arr[j] > arr[j+1]) {
                swap(arr,j,j+1);
            }
        }
        print(arr);
        bubbleSortRec(arr,i-1);

    }

    public static void bubbleSort(int [] arr){
        for( int i = 0 ; i < arr.length; i++) {
            for( int j = 0 ; j < arr.length-1; j++) {
                if(arr[j] > arr[j+1])
                    swap(arr,j,j+1);
            }
            print(arr);
        }

    }

    public static void print(int [] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int [] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
