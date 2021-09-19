package com.algorithms.arrayproblems;

import java.util.Arrays;

public class SortInOneSwap {
    // static int arr[] = {10, 20, 60, 40, 50, 30} ;
    // static int arr[] ={10, 20, 40, 30, 50, 60};
    static int arr[] = {1,5,3};
    public static void main(String[] args) {

        sort(arr);

    }

    public static void sort(int [] arr) {
        int i = 0;
        int j = 0;
        int max = 0;
        int min = 10000;
        while( i < arr.length) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < max) {
                i--;
                break;
            }
            i++;
        }

        System.out.println("Index " + i + " has max value >> " + arr[i]);
        j = i+1;
        int index = j+1;
        while(j < arr.length) {
            if(arr[j] < min) {
                index = j;
                min = arr[j];
            }
            j++;
        }
        System.out.println("Index " + index + " has min value >> " + arr[index]);

        System.out.println(Arrays.toString(arr));
        swap(i,index,arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int i , int j, int [] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
