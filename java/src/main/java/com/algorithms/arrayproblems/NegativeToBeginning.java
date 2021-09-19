package com.algorithms.arrayproblems;

import java.util.Arrays;

public class NegativeToBeginning {
    static int [] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

    public static void main(String [] args) {
        rearrange1(arr);
//        rearrange(arr);
    }


    public static void rearrange1(int [] arr) {

        int temp = 0;
        int j = 0;

        for( int i = 0 ; i < arr.length; i++) {
            if(arr[i] < 0) {
                if(i != j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
            System.out.println(Arrays.toString(arr));
        }

    }


    public static void rearrange(int [] arr) {

        int pivot = 0;
        int i = 0;
        int j = arr.length - 1;

        while(i < j) {

            while(i < j && arr[i] < pivot) {
                i++;
            }

            while(j > i && arr[j] > pivot) {
                j--;
            }

            if(arr[i] > pivot && arr[j] < pivot) {
                swap(i,j,arr);
                i++;
                j--;

            }
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void swap(int i, int j, int []arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
