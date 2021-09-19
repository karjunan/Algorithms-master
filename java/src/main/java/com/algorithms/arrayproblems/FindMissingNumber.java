package com.algorithms.arrayproblems;

public class FindMissingNumber {


    public static void main(String[] args) throws Exception {
        // Integer [] arr  = {1, 4, 45, 6, 0, 19};
        Integer [] arr  = {1, 2, 3, 4, 5, 6, 7, 8,9,11};
        int min = findMissingNumber(arr);
        System.out.println(min);
    }


    public static int findMissingNumber(Integer [] arr) {
        int val = 1;
        for(int i = 0 ; i < arr.length;i++) {
            if(arr[i] != i) {
                val = i+1;
            }
        }

        return val;
    }
}
