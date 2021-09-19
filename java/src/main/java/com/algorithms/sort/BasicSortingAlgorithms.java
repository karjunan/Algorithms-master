package com.algorithms.sort;

import java.util.Arrays;

public class BasicSortingAlgorithms {

    static int [] arr = {8,5,2,9,5,6,3};
    static int [] arr1 = {8,5,2,9,5,6,3};
    public static void main(String args [] ) {

        int [] result = selectionSort(arr);
        System.out.println(Arrays.toString(result));

        System.out.println(" -------");
        int [] result1 = insertionSort(arr1);
        System.out.println(Arrays.toString(result1));
    }


    public static int [] selectionSort(int [] arr) {

        for( int i = 0 ; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int j = i;
            int index = i;
            while( j < arr.length ) {
                if( arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
                j++;
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            System.out.println(Arrays.toString(arr));
        }

        return arr;
    }

    public static int[] insertionSort(int [] arr ) {

        for( int i = 0 ; i < arr.length; i++) {
            int j = i + 1;
            while( j >  0  && j < arr.length && arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                System.out.println(Arrays.toString(arr));
                j--;
            }
        }
        return arr;
    }


}
