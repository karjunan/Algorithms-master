package com.datastructures;


import java.util.Arrays;

class Heap {

    static int [] a = { 19,1,23,45,78,3,2,90,20};
    static int [] a1 = new int [a.length];
    static int size = 0;

    public static void main(String[] args) {

        initilizeArray(a1);

        System.out.println(Arrays.toString(a));


        for( int i = 0 ; i < a.length; i++) {
            insert(a[i]);
        }

        System.out.println("Max element is : " +deleteMax());
        System.out.println(Arrays.toString(a1));
        System.out.println("Max element is : " +deleteMax());
        System.out.println(Arrays.toString(a1));
        System.out.println("Max element is : " +deleteMax());
        System.out.println(Arrays.toString(a1));
        System.out.println("Max element is : " +deleteMax());
        System.out.println(Arrays.toString(a1));

    }

    public static int findMax(int val, int [] arr) {
        int result = -1;
        for( int i = 0 ; i < val; i++) {
            result = removeMax(arr);
        }
        return result;
    }

    public static void insert(int element) {
        insert(element,a1);
    }

    public static int  deleteMax() {
        return deleteMax(a1);
    }

    public static void insert(int element, int[] arr) {

        if(size == 0) {
            arr[size] = element;
            size++;
            return;
        }

        arr[size] = element;
        int parent = size/2;
        // System.out.println("parent >>>" + parent + " : size>>" + size);
        if(arr[size] > arr[parent]) {
            heapifyUp(arr);
        }
        size++;

    }

    public static int deleteMax(int [] A) {
        int result = A[0];
        A[0] = A[size-1];
        A[--size] = -1;
        heapifyDown(A);
        return result;
    }


    public static void heapifyUp( int [] A) {
        int parent = size/2;
        int current = size;

        while(A[parent] < A[current]) {
            swap(parent,current,A);
            current = parent;
            parent =  parent/2;
            System.out.println(Arrays.toString(A));
        }
    }

    public static void heapifyDown( int [] A) {
        int i = 0;
        int leftIndex = (2 * i) + 1;
        int rightIndex = (2 * i) + 2;

        while(leftIndex <= size || rightIndex <= size) {

            int index = leftIndex;
            if(A[leftIndex] < A[rightIndex]) {
                index = rightIndex;
            }

            if(A[i] < A[index]) {
                swap(i,index,A);
                i = index;
                leftIndex = ( 2 * i ) + 1;
                rightIndex = ( 2 * i ) + 2;
            } else {
                break;
            }
        }


    }

    public static int getMax(int [] arr) {
        int result = arr[0];
        return result;
    }

    public static int removeMax(int [] arr) {
        int result = arr[0];
        arr[0] = -1;
        // heapifyDown(arr,arr.length-1);
        return result;
    }

    public static void swap(int a , int b, int [] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void initilizeArray(int [] A) {
        for( int i = 0 ; i < a.length; i++) {
            A[i] = -1;
        }
    }

}
