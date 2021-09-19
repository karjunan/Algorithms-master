package com.search;

public class SearchMinElementInPartialySortedArray {
    
    public static void main(String[] args) {

        int [] arr = {9,12,15,17,25,28,32,37,3,5,7,8};
        // int [] arr = {8,9,10,11,12,13,14,15,2};
        int result = bs(arr);
        System.out.println("Result is => " + result);
    }

    public static int bs(int [] arr) {

        int low = 0;
        int high = arr.length-1;
        if(arr[low] < arr[high]) {
            return arr[low];
        }
        while(low <= high) {
            int mid = low + ((high - low)/2);
            if(mid > 0 && arr[mid] < arr[mid-1]) {
                return arr[mid];
            } else if(arr[mid] >= arr[low] && arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }


}
