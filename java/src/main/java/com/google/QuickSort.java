package com.google;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class QuickSort {
    public static void main(String[] args) {

        // int [] arr = new int[] { 32,12,31,5,22,1};
        int [] arr = new int[] { 22,1,32,3,45,4,41};
        // int [] arr = new int[] { 1,2,3,4,5,6,7};
        // int [] arr = new int[] { 7,6,5,4,3,2,1};
        // int [] arr = new int[] { 1,12,4,23,32};

        helper(arr);

    }

    public static void helper(int [] arr) {
        int left = 0;
        int right = arr.length-1;
        quickSort(arr,left,right);
        System.out.println("Completed Quick sort " + Arrays.toString(arr));
    }

    public static void quickSort(int [] arr, int left , int right) {
        if(left > right) {
            return;
        }
        int mid = partition(arr,left,right);
        System.out.println("Mid element => " + mid);
        quickSort(arr,left,mid-1);
        quickSort(arr,mid+1,right);
        // System.out.println(Arrays.toString(arr));

    }

    public static int partition(int [] arr, int left, int right) {

        int pIndex = left;
        int pivot = arr[right];

        for(int i = pIndex; i < right; i++) {
            if(arr[i] <= pivot) {
                swap(arr,pIndex,i);
                pIndex++;
            }

        }

        swap(arr,right,pIndex);
        System.out.println(Arrays.toString(arr));
        return pIndex;

    }

    public static void swap(int [] arr, int i, int j) {
        // System.out.println("i  : :: j " + i + " : " + j );
        System.out.println("Swapped elements ==>  " + Arrays.toString(arr));
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
