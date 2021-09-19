package com.algorithms.sort;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {

        int [] arr = {8,5,2,9,5,6,3};
        System.out.println(Arrays.toString(arr));
        int i = 0;
        int j = arr.length - 1;
        // partition(arr,i,j);
        quickSort(arr,i,j);
        System.out.println("Final Output -> " + Arrays.toString(arr));
    }

    public static void quickSort(int [] arr, int i , int j) {
        // System.out.println( i + " - " + j );
        if( i == j || i == arr.length) {
            return;
        }

        int mid = partition(arr,i,j);
        quickSort(arr,i,mid);
        quickSort(arr,mid+1,j);
    }

    public static int partition(int arr[] , int i, int j) {

        int pivot = i;
        i = i+1;

        while( i <= j && i < arr.length && j >= 0) {

            while( i < arr.length && arr[i] < arr[pivot]) {
                i++;
            }

            while(j >= 0 && arr[j] > arr[pivot]) {
                j--;
            }

            if(i < arr.length && j >= 0 && i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

        }
        if(j >= 0 && j < i) {
            int temp = arr[pivot];
            arr[pivot] = arr[j];
            arr[j] = temp;
        }

        System.out.println("Result = "+  Arrays.toString(arr));

        return j;
    }

}
