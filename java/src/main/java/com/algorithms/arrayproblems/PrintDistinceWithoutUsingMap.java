package com.algorithms.arrayproblems;

public class PrintDistinceWithoutUsingMap {

    static int [] arr = {1, 1, 1, 1, 1};

    public static void main(String [] args) {

        printDistinct(arr);
    }

    public static void printDistinct(int [] arr) {

        int max = 0;
        for( int i = 0 ; i < arr.length; i++) {

            if(max < arr[i]) {
                max = arr[i];
            }
        }

        boolean [] bool = new boolean[max+1];

        for( int i = 0 ; i < arr.length; i++) {

            if(!bool[arr[i]]) {
                System.out.print(arr[i] + " ");
                bool[arr[i]] = true;
            }

        }


    }
}
