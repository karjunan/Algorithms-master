package com.algorithms.arrayproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindSubarrayGreaterThanGivenValue {

//     static int [] arr = { 1, 4, 45, 6, 0, 19};
//     static int [] arr = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
//     static int [] arr = {1, 10, 5, 2, 7};
//    static int [] arr = {1, 2, 4};
        static int [] arr = {1,3};

    static int x = 2;

    public static void main(String[] args) {
        // Initialize current sum and minimum length

        int n = arr.length;
        int curr_sum = 0, min_len = n + 1;

        // Initialize starting and ending indexes
        int start = 0, end = 0;
        List<LinkedList<Integer>> finalList = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        while (end < n)
        {
            list = new LinkedList<>();
            // Keep adding array elements while current sum
            // is smaller than x
            while (curr_sum <= x && end < n) {
                curr_sum += arr[end++];

            }

            // If current sum becomes greater than x.
            while (curr_sum > x && start < n)
            {
                // Update minimum length if needed
                if (end - start < min_len)
                    min_len = end - start;

                // remove starting elements
                curr_sum -= arr[start++];
            }

            finalList.add(list);
        }
        System.out.println(" size of the array is >> " + min_len);

        System.out.println(finalList);

//        subarray(arr,x);
        nearestSmallestSubarray(arr,x);
    }


    public static int subarray(int [] arr, int sum) {

        int i = 0 ;
        int j = 0;
        int end = arr.length - 1;
        int localSum = 0;
        int min = arr.length + 1;
        while(j < end) {

            while(localSum <= sum && j  < end ) {
                localSum += arr[j++];
            }

            System.out.println("Local sum : "+ localSum);
            while(i < j && localSum > sum ) {

                System.out.println("Index between front:" + i + " : " + (j-1));

                if(j -i < min) {
                    min = j - i;
                }

                localSum -= arr[i++];
                System.out.println("Local sum lowering: "+ localSum);
            }
        }
        return min;
    }

    public static void nearestSmallestSubarray(int [] arr, int sum) {


        int start = 0 , cur_sum = arr[0];
        int providedSum = sum;
        int n = arr.length;
        for(int i = 1; i < n;i++){

            if(cur_sum <= providedSum){
                cur_sum += arr[i];
            }

            while(cur_sum > providedSum && start < i  && (cur_sum - arr[start]) > providedSum){

                cur_sum  = cur_sum - arr[start];
                start++;
            }

            if(cur_sum > providedSum) {

                System.out.println("Given sum:"+sum+". Found nearest sum: "+cur_sum + " . Added elements with indexes: " +    start+" "+i);
                return;

            }else if(i == n-1){
                System.out.println("Provided array sum does't meet the provided sum");
            }

        }
    }
}
