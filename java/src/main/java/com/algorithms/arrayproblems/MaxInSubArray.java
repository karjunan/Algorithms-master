package com.algorithms.arrayproblems;

import com.datastructures.LinkedList;

class MaxInSubArray {
    public static void main(String[] args) {

        int [] nums = { 1, 2, 3, 2, 4, 1, 5, 7,9};;
        int elements = 3;
        subArrayMax(nums,elements);
    }

    public static void subArrayMax(int [] arr, int elements) {

        int i = 0;
        int j = elements ;
        int k = 0;
        int max = 0;
        java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
        while(j <= arr.length) {

            while(k < j) {
                if(max < arr[k]) {
                    max = arr[k];
                }
                k++;
            }

            list.add(max);
            i++;
            j++;
            k = i;
            max = 0;
            System.out.println(list);

        }

    }
}
