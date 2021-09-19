package com.algorithms.arrayproblems;

public class BinarySearch {

    public static void main(String[] args) {
        int []  arr = {2,3,4,5,6,7,8};
        System.out.println(searchElement(arr,2,0,arr.length-1));
        binarySearch(arr,7);

    }



    public static void binarySearch(int [] arr, int element) {

        int i = 0;
        int j = arr.length;

        while(i < j && i < arr.length - 1  && j > 0) {
            int mid = (i + j)/2;
            if(element < arr[mid]) {
                j = mid;
            } else if(element > arr[mid]) {
                i = mid;
            } else if(arr[mid] == element) {
                System.out.println("Element found at index " + mid);
                return;
            }
            System.out.println(i + " :: " + j + " ::" + mid);
        }

        System.out.println("Element Not found  >> " + element);

    }


    public static boolean searchElement(int [] arr, int val, int front, int mid) {
        boolean bool = false;
        if(arr == null || front == -1 || mid == -1 || front > mid ) {
            return false;
        }
        mid = (front+mid)/2;
        if(val < arr[mid]) {
            bool = searchElement(arr,val,front,mid-1);
        } else if(val > arr[mid]) {
           bool = searchElement(arr,val,mid+1,arr.length);
        } else if(val == arr[mid]) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    public static int bs(int [] arr, int target, int i , int j) {

        if(j == i) {
            return -1;
        }

        int mid = (i + j) /2;

        if(arr[mid] == target) {
            return mid;
        } else if(target < arr[mid]) {
            mid = bs(arr,target,i,mid);
        } else if(target > arr[mid]) {
            mid = bs(arr,target,mid+1,j);
        }
        return mid;
    }
}
