package com.algorithms.arrayproblems;

import java.util.Arrays;

public class OddEvenRearrange {


    static int [] arr = { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12, -13, 14 };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        rearrange(arr);

    }

    public static void rearrange(int [] arr) {

        int i = 0;
        int j = arr.length - 1;
        int pivot = 0;
        while(i < j) {

            while(arr[i] < pivot && i  < j )  {
                i++;
            }


            while( arr[j] > pivot &&  i < j) {
                j--;
            }

            System.out.println("i >> " + i + "  j  >> "  + j );
            if((arr[i] > pivot && arr[j] < pivot)) {
                swap(i,j);
                i++;
                j--;
            }

            System.out.println(Arrays.toString(arr));

        }

        i = 1;
        j = 0;

        while( j < arr.length && arr[j] < 0) {
            j++;
        }

        System.out.println(" Value of J is : " + j);

        while( j < arr.length ) {

            if(i % 2 != 0 ) {
                swap(i,j);
                i += 2 ;
                j++;
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    }

}
