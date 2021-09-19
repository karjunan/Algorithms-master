package com.algorithms.arrayproblems;

import java.util.Arrays;

public class ThirdLargestElement {
    static int [] arr = {10, 4, 3, 50, 23, 90};
    static int size = 0;

    public static void main(String [] args) {
        int [] temp = new int[arr.length];
        for( int i = 0 ; i < temp.length; i++) {
            temp[i] = -1;
        }
        for( int i = 0 ; i < arr.length; i++) {
            add(arr[i],arr, temp);
        }

        System.out.println(Arrays.toString(temp));

        System.out.println(deleteMax(temp));
        System.out.println(deleteMax(temp));
        System.out.println(deleteMax(temp));
    }


    public static void add(int element,int [] arr,int [] temp) {


        if(temp[0] == -1) {
            temp[0] = element;
            size++;
            return;
        }
        temp[size++] = element;
        precolateUp(temp);

    }

    public static int deleteMax(int [] temp) {
        int val = temp[0];
        size--;
        precolateDown(temp);
        return val;

    }

    public static void precolateUp(int [] arr) {

        int current = size-1;
        int parent = current/2;

        while(parent >= 0 && arr[parent] < arr[current]) {
            swap(parent,current,arr);
            current = parent;
            parent = parent/2;
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void precolateDown(int [] arr) {

        int start = 0;
        swap(start,size,arr);
        arr[size] = -1;
        int index = 0;
        int leftIndex = (2 * start) + 1;
        int rightIndex = (2 * start) + 2;


        while(leftIndex <= size || rightIndex <= size ) {
            index = leftIndex;
            if(arr[leftIndex] < arr[rightIndex]) {
                index = rightIndex;
            }

            if(arr[start] < arr[index]) {
                swap(start,index,arr);
            }

            start = index;
            leftIndex = (2 * index) + 1;
            rightIndex = (2 * index) + 2;
            System.out.println(Arrays.toString(arr));
        }


    }

    public static void swap(int i, int j, int []arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
