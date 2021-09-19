package com.google;

import java.util.Arrays;

public class BinarySearch {

    static int [] arr = new int [] {33,3,1,5,9,6,21,2};

    public static void main(String[] args) {

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int ele = 3;
        System.out.println("Data => " + binarySearchIterative(arr, ele));

        System.out.println("Data Recursive => " + binarySearchRecursive(arr, 0,arr.length,
                                (0+arr.length)/2,ele));
    }



    public static int  binarySearchRecursive(int [] arr,  int i, int j,
                                             int mid, int ele) {

        if(i >= j )  {
            return -1;
        }

        mid = (i+j)/2;

        if(arr[mid] == ele ) {
            return mid;
        } else if(ele < arr[mid]) {
            mid = binarySearchRecursive(arr,i,mid-1,mid,ele);
        } else {
            mid = binarySearchRecursive(arr,mid+1,j,mid,ele);
        }
        return mid;
    }

    public static int binarySearchIterative(int [] arr,  int ele) {

        int i = 0;
        int j = arr.length;

        int mid = (i+j)/2;
        while(i <= j && i < arr.length && j >= 0 ) {
            if(arr[mid] == ele) {
                return mid;
            } else if(ele < arr[mid]) {
                j = (mid - 1);
                mid = (i + j)/2;
            } else if (ele > arr[mid]) {
                i = (mid + 1);
                mid = (i+ j)/2;
            }

        }
        return -1;

    }
}
