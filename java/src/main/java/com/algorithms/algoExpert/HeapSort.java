package com.algorithms.algoExpert;

import java.util.Arrays;

public class HeapSort {

    public static void main(String [] ar) {

        int [] arr = {1,2,3};

        int [] result = heapSort(arr);
        System.out.println(Arrays.toString(result));

    }

    public static int[] heapSort(int[] arr) {

        buildHeap(arr);
        int i = 0;
        int j = arr.length-1;
        System.out.println(Arrays.toString(arr));

        while(j >= i) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
            shiftDown(arr,i,j);
        }
        return arr;
    }

    public static void buildHeap(int [] arr) {
        int parent = (arr.length-1)/2;
        int i = parent;
        while( i >= 0) {
            shiftDown(arr,i,arr.length-1);
            i--;
        }


    }

    public static void shiftDown(int [] arr,int currentIdx, int endIdx) {

        while(true) {
            int left = (2*currentIdx) + 1;
            int right = (2*currentIdx) + 2;

            if(left <= endIdx && right > endIdx) {
                if(arr[currentIdx] <= arr[left]) {
                    int temp = arr[currentIdx];
                    arr[currentIdx] = arr[left];
                    arr[left] = temp;
                } else {
                    break;
                }
                currentIdx = left;
            } else if(left <= endIdx && right <= endIdx) {
                int pos = -1;
                if(arr[left] > arr[right]) {
                    pos = left;
                } else {
                    pos = right;
                }

                if(arr[pos] > arr[currentIdx]) {
                    int temp = arr[pos];
                    arr[pos] = arr[currentIdx];
                    arr[currentIdx] = temp;
                }
                currentIdx = pos;
            } else {
                break;
            }
        }
    }
}
