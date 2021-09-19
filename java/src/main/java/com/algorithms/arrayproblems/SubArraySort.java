package com.algorithms.arrayproblems;

import java.util.Arrays;

public class SubArraySort {

    // static int [] arr = {1,2,4,7,10,11,7,12,6,7,16,18,19};
    static int [] arr = {0,1,1,2,3,5,8,13,21,34,55,89};
    public static void main(String [] ar) {

        int [] result = subarraySort(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] subarraySort(int[] arr) {

        int [] temp = new int[2];
        int low = 1 ;
        int high = (arr.length-2);
        boolean [] bool = new boolean[arr.length];
        if(arr.length >= 2 && arr[0] <= arr[1] ) {
            bool[0] = true;
        }else {
            bool[0] = false;
        }
        while(low < arr.length-1)  {
            if(arr[low] <= arr[low+1] && arr[low] >= arr[low-1])  {
                bool[low] = true;
            } else {
                bool[low] = false;
            }
            low++;
        }

        if(arr[arr.length-1] > arr[arr.length-2]) {
            bool[arr.length-1] = true;
        } else {
            bool[arr.length-1] = false;
        }
        System.out.println("Low position :" + low + Arrays.toString(bool));

        boolean t = false;
        for( int i = 0 ; i < arr.length; i++) {
            if(!bool[i]) {
                t = true;
                break;
            }
        }

        if(!t) {
            temp[0] = -1;
            temp[1] = -1;
            return temp;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < bool.length; i++) {
            if(!bool[i] && (arr[i] < min)) {
                min = arr[i];
            }
            if(!bool[i] && (arr[i] > max)) {
                max = arr[i];
            }
        }

        System.out.println("min value : " + min + " -> " +max);

        int minIndex = 0;
        for(int i = 0 ; i < arr.length; i++) {
            if(arr[i] > min)  {
                minIndex = i;
                break;
            }
        }

        int maxIndex = arr.length-1;
        for( int i = arr.length-1; i > 0; i--) {
            if(arr[i] < max) {
                maxIndex= i;
                break;
            }
        }

        System.out.println(" Index value :" + minIndex + " -> " + maxIndex);
        temp[0] = minIndex;
        temp[1] = maxIndex;

        return temp;
    }
}
