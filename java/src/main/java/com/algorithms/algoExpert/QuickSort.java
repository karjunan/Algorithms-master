package com.algorithms.algoExpert;

import java.util.Arrays;
import java.util.stream.StreamSupport;

public class QuickSort {

    public static void main(String[] args) {
//        int arr [] = {7,8,5,6,21,1,3,2,54};
//        int arr [] = {9,8,7,6,5};
//        int arr [] = {1,2,3,4,5};
        int arr [] = {21,23,1,45,2,25,76,0};

        print(arr);
//        quickSort(arr,0,arr.length-1);
//        Arrays.sort();
        quickSort1(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort1(int [] arr,int i, int j) {
        if(j > i)  {
            int mid = partiton(arr,i,j);
            quickSort1(arr,i,mid-1);
            quickSort1(arr,mid+1,j);

        }

    }

    public static int partiton(int [] arr, int i, int j) {
        int pivot = i;
        i = i + 1;
        while(i < j) {
            while ( i < arr.length && arr[i] < arr[pivot] ) {
                i++;
            }
            while (j >= 0 && arr[j] > arr[pivot] ) {
                j--;
            }

            if( i < j && arr[i] > arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            System.out.println(Arrays.toString(arr));

        }

        if(arr[j] < arr[pivot]) {
            int temp = arr[j];
            arr[j] = arr[pivot];
            arr[pivot] = temp;
        }
//        System.out.println(Arrays.toString(arr));
        return j;
    }

    private static void quickSort(int[] arr,int left,int right) {

        if(left == right) {
            return;
        }

        int mid = partition(arr,left,right);
        print(arr);
        System.out.println(mid);
        quickSort(arr,left,mid);
        print(arr);
        System.out.println("After left completion Mid value :: "+ mid );
        System.out.println("After left completion right value :: "+ right );
        quickSort(arr,(mid+1),right);
    }

    private static int partition(int [] arr, int leftMark, int rightMark) {
        int mid = (leftMark + rightMark)/2;
//        if(mid == 0 ) {
//            return mid;
//        }
        int pivot = arr[mid];


        while(true) {


            while (arr[leftMark] < pivot) {
                leftMark++;
            }

            while (arr[rightMark] > pivot) {
                rightMark--;
            }

            if (arr[leftMark] >= pivot && arr[rightMark] <= pivot) {
                swap(arr, leftMark, rightMark);
                if(leftMark == rightMark) {
                    leftMark++;
                }
            }

            if (arr[rightMark] < arr[leftMark]) {
                mid = rightMark;
                break;
            }

        }
        return mid;
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        System.out.println("------Swapped Start-------------");
        print(arr);
        System.out.println("------Swapped End-------------");
    }

    private static void print(int [] arr) {
        StreamSupport.intStream(Arrays.spliterator(arr),false)
                .forEach(v -> System.out.print("["+v+"]"));
        System.out.println("");
    }

}
