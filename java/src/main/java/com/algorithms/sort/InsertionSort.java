package com.algorithms.sort;

import java.util.Arrays;

public class InsertionSort {

    static int [] arr = {6,8,2,4,5,3,7,1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int [] arr) {

        int counter = 0;
        int i = 0;
        while(i < arr.length) {
            int j = i + 1;

            while(j < arr.length && j > 0 && arr[j] < arr[j-1] ) {
                counter++;
                System.out.println(Arrays.toString(arr)  + "  >> Counter " + counter   + " >>> " + arr[j]);
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
            i++;
        }

    }


}
