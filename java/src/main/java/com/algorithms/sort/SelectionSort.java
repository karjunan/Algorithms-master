package com.algorithms.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionSort {

    public static void main(String[] args) {
        int []  arr = {2,1,4,3,7};
        print(arr);
//        sort(arr);
        sSort(arr);
    }

    public static void sort(int [] arr) {


        for(int i = 0 ; i < arr.length; i++ ) {
            int pos = i+1;
            int min = arr[i];
            int index = pos;
            boolean bool = false;
            while(pos < arr.length) {
                if(arr[pos] < arr[i]) {
                    if(min > arr[pos]) {
                        min = arr[pos];
                        index = pos;
                        bool = true;
                    }
                }
                pos++;
            }
            if(bool) {
                swap(arr,i,index);
            }

            print(arr);
        }
    }

    public static void sSort(int [] arr) {
        int i = 0 ;
        int j = 0;

        while(i < arr.length) {

            int index = i;
            int min = arr[i];
            j = i + 1;
            while( j < arr.length) {
                if(arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
                j++;
            }
            if(i < arr.length && arr[i] > min) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }

            i++;

        }

    }


    private static void swap(int [] arr, int left, int right) {

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static  void print(int [] arr) {
        Arrays.stream(arr).forEach(v -> System.out.print("["+v+"]"));
        System.out.println("");

        List<Integer> list = Arrays.stream(arr).sorted().mapToObj(v -> v).collect(Collectors.toList());
        System.out.println(list);
    }
}
