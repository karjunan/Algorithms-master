package com.search;

public class BinarySearch {
    
    public static void main(String [] args) {
        int [] arr = {2,5,6,8,9,11};
        int result = bs(arr,2);
        System.out.println("Result is " + result);

    }

    public static int bs(int [] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
      
        while(left <= right) {
             int mid = (left + right) / 2;
             if(arr[mid] == target) {
                 System.out.println("Position of the value is => " + mid);
                 return mid;
             } else if(target < arr[mid]) {
                 right = mid  - 1;
             } else if(target > arr[mid]) {
                 left = mid + 1;
             }
        }
        return -1;
    }
}
