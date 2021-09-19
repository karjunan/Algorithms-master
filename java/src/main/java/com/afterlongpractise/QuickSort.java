package com.afterlongpractise;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        int [] arr = new int[] {4,3,6,7,2,9,1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int [] arr, int left, int right) {
        if(left > right) {
            return;
        }
        int mid = partition(arr,left,right);
        quickSort(arr,left, mid-1);
        quickSort(arr,mid+1,right);
    }

    public static int partition(int [] arr, int left, int right) {

        int pindex = left;
        int pivot = arr[right];
        for(int i = pindex; i < right; i++) {
            if(arr[i] <= pivot) {
                swap(i,pindex,arr);
                pindex++;
            }
        }
        swap(right,pindex,arr);
        return pindex;
    }
    public static void swap(int i , int j, int [] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
