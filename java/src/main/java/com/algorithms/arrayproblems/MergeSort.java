package com.algorithms.arrayproblems;

import java.util.Arrays;
import java.util.stream.StreamSupport;

public class MergeSort {
    static int [] arr = {0,99,12,-23,-1,1,23,41,2,4};

    public static void main(String[] args) {
        int [] arr = {0,99,12,-23,-1,1,23,41,2,4};
        print(arr);
        System.out.println("After sorting");
        System.out.println("");
//        int [] finalArry = mergeSort(arr,0,(arr.length/2));
//        print(finalArry);
        sort(arr);
//        print(arr);

    }

    private static int [] mergeSort(int[] arr,float start, float mid) {
        if(arr.length == 1 ) {
            return arr;
        }

        mid = (start+arr.length)/2;
        int mida = Math.round(mid);
        int [] left = processLeftElements(arr, Float.floatToIntBits(start),mida);
        int [] right = processRightElements(arr,mida,arr.length);
        left = mergeSort(left,start,mid);
        right = mergeSort(right,start,mid);
//        print(left);
//        print(right);
        int [] sorted = sort(left, right);
        return sorted;

    }

    private static int [] sort(int[] left, int[] right) {
        int [] sortedArray = new int[left.length+right.length];
        int counter = 0;
        int rightLow = 0;
        int leftLow = 0;
        for (int i = 0; i < left.length; i++) {
            for(int j = rightLow; j < right.length; j++) {
                if(left[i] < right[j]) {
                    sortedArray[counter] = left[i];
                    counter++;
                    leftLow++;
                    break;
                } else if(left[i] > right[j]) {
                    sortedArray[counter] = right[j];
                    counter++;
                    rightLow++;
                    continue;
                }
            }
        }
        if( leftLow < left.length )  {
            for( int i = leftLow ;i< left.length; i++ ) {
                sortedArray[counter] = left[i];
                counter++;
            }
        }

        if( rightLow < right.length )  {
            for( int i = rightLow ;i< right.length; i++ ) {
                sortedArray[counter] = right[i];
                counter++;
            }
        }
//        System.out.println("Printing Sorted Array");
//        print(sortedArray);

        return sortedArray;
    }

    private static void print(int[] leftarr) {
        StreamSupport.intStream(Arrays.spliterator(leftarr),false)
                .forEach(v-> System.out.print("["+v+"]"));
        System.out.println("");
    }


    private static int[] processLeftElements(int[] arr,int start, int end) {
        int [] target = new int[end];
        int counter = 0;
        for (int i = start ; i < target.length; i++ ) {
            target[counter] = arr[i];
            counter++;
        }
        return target;
    }

    private static int[] processRightElements(int[] arr,int start, int end) {
        int [] target = new int[end-start];
        int counter = 0;
        for (int i = start ; i < end; i++ ) {
            target[counter] = arr[start];
            counter++;
            start++;
        }
        return target;
    }

    public static int [] sort(int [] arr) {
        // System.out.println("Top >>" + Arrays.toString(arr));
        // System.out.println("Right >> " +Arrays.toString(right));

        if(arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int [] left = Arrays.copyOfRange(arr,0,mid);
        int [] right = Arrays.copyOfRange(arr,mid,arr.length);

        left =  sort(left);
        right = sort(right);
        return merge(arr,left,right);
    }

    public static int [] merge(int arr [] , int [] left , int [] right ) {

        int i = 0;
        int j = 0;
        arr = new int[left.length + right.length];
        int k = 0;
        while(k < arr.length && i < left.length && j < right.length) {
            if(i < left.length && left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else if(j < right.length && right[j] < left[i]) {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while( i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }

        System.out.println("Merge >> " +Arrays.toString(arr));

        return arr;

    }

}

