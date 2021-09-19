package com.afterlongpractise;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int [] arr = new int[] {5,6,4,3,7,8,2,9,1};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int [] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,mid,left,right);
            System.out.println( "Result Array => " + Arrays.toString(arr));
        }
    }

    public static void merge(int [] arr, int mid , int left, int right) {

        int [] leftArr = new int[(mid - left)+1];
        int [] rightArr = new int[(right - mid)];
        for(int i = 0 ; i < leftArr.length; i++) {
            leftArr[i] = arr[left+i];
        }
        for(int i = 0 ; i < rightArr.length; i++) {
            rightArr[i] = arr[mid+1+i];
        }

        System.out.println(Arrays.toString(leftArr));
        System.out.println(Arrays.toString(rightArr));

        int i = 0;
        int j = 0;
        int k = left;

        while(i < leftArr.length && j < rightArr.length) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
                k++;
            } else {
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }

        while(i < leftArr.length) {
            arr[k] = leftArr[i];
            k++;
            i++;
        }
        while(j < rightArr.length) {
            arr[k] = rightArr[j];
            k++;
            j++;
        }
    }
}
