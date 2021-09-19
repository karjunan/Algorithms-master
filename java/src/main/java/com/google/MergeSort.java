package com.google;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int [] arr = new int[]{43,21,55,3,5,31};
//        int [] arr = new int[]{1,9,8,7,6,5,4,3,2,10};
        mergeSort(arr,arr.length);
        System.out.println("Completed => " + Arrays.toString(arr));
    }

    public static void mergeSort(int [] arr, int n) {
        System.out.println(Arrays.toString(arr));

        if(n < 2 ) {
            return;
        }

        int mid = n /2;

        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }

        mergeSort(l,mid);
        mergeSort(r,n-mid);

        merge(arr,l,r,mid,n-mid);

    }


    public static void merge(int [] arr,
                             int [] leftArr,
                             int [] rightArr,
                             int left,int right) {

        int i=0 , k=0 , j = 0;

        while(i < left && j < right) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < left) {
            arr[k++] = leftArr[i++];
        }
        while (j < right) {
            arr[k++] = rightArr[j++];
        }

    }
}
