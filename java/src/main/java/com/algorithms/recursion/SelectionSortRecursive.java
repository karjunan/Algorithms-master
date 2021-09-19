package com.algorithms.recursion;

import java.util.Arrays;

public class SelectionSortRecursive {
    public static void main(String [] ar) {

        int [] arr = {0,1,3,2,9};
        selectionSortRecursive(arr,0);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSortRecursive(int [] arr,int val){

        if(val > arr.length-1) {
            return;
        }

        int i = arr.length-1;
        int min = arr[val];
        int index = val;
        while(i > val) {
            if(arr[i] < min) {
                min = arr[i];
                index = i;
            }
            i--;
        }

        int temp = arr[val];
        arr[val] = arr[index];
        arr[index] = temp;

        selectionSortRecursive(arr,++val);

    }


}
