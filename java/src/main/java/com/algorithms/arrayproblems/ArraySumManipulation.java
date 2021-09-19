package com.algorithms.arrayproblems;

public class ArraySumManipulation {


    public static void main(String[] args) {

        int m = 5;
        int arr[] = {1, 3, 2, 5, 8};
        boolean bool = sumAndArrayManipulation(arr,m);
        System.out.println("Is Possible >> " + bool);


    }


    public static boolean sumAndArrayManipulation(int [] arr, int k) {
        int size = arr.length;
        System.out.println(size);
        for(int i = 0 ; i< arr.length; i++) {
            if((arr[i] * size) == k ) {
                return true;
            }
        }

        return false;
    }

}
