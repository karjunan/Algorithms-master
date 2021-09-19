package com.search;

public class FindElementGreaterThanTarget {

    public static void main(String [] args) {
        int [] arr = {2,3,5,6,8,10,12};
        int x = 11;
        int result = bs(arr,x);
        System.out.println("Result is => " + result);
    }

    public static int bs(int [] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = Integer.MIN_VALUE;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid]  >= target) {
                ans = arr[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            System.out.println("Whats the mid now => " + arr[mid]);
        }

        return ans;
    }
    
}
