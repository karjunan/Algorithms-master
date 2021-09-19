package com.algorithms.arrayproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

public class OddEvenArrayArrangement {

    static int [] arr = {3,7,9,1,2,4,6,8,15,21,23};

    public static void main(String[] args) {

        System.out.println(Arrays.toString(arr));
        int left = 0;
        int right = arr.length-1;

        while(true) {

            while(arr[left] % 2 == 0 ) {
                left++;
            }

            while(arr[right] % 2 !=0 ) {
                right--;
            }

            if(left > right) {
                break;
            } else {
                swap(arr,left,right);
            }

        }

        arrange(arr);

    }

    public static void arrange(int [] arr) {

        int i = 0;
        int j = 1;

        while(true) {
            if(arr[i] % 2 != 0) break;
            i++;
        }

        while(i < arr.length && j % 2 != 0 && arr[j] % 2 == 0 ) {
            swap(arr,j,i);
            i++;
            j = j + 2;
        }

        System.out.println("i >> " + i);
        System.out.println(Arrays.toString(arr));

    }


    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        print(arr);
    }

    private static void print(int [] arr) {
        StreamSupport.intStream(Arrays.spliterator(arr),false)
                .forEach(v -> System.out.print("["+v+"]"));
        System.out.println("");
        Map<String,String> map = new HashMap<>();
    }

}
