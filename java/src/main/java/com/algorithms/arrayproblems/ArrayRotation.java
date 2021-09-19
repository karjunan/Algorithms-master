package com.algorithms.arrayproblems;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayRotation {

    public static void main(String[] args) {

        int [] arr = {1,2,3,5,6,7,8} ;
//        print(rotateArray(arr,9));
        print(arr);
        print(leftRotate(arr,3));
        print(rightRotate(arr,3));
        print(rotateArray(arr,3));
        arryPrint();
    }

    public static void print(int [] arr) {

        IntStream.range(0,arr.length)
                .forEach(v -> System.out.print("["+arr[v]+"]"));
        System.out.println("");
    }


    public static  int[] leftRotate(int [] arr, int times) {
        int val = times % arr.length;

        int [] newArr = new int[arr.length];
        for(int i = 0 ; i< arr.length;i++) {
            newArr[i] = arr[(i + val)%arr.length ];
        }
        return newArr;
    }

    public static  int[] rightRotate(int [] arr, int times) {
        int val = times % arr.length;

        int [] newArr = new int[arr.length];
        for(int i = 0 ; i< arr.length;i++) {
            newArr[(i+val)%arr.length] = arr[i];
        }
        return newArr;
    }

    public static int [] rotateArray(int [] arr, int times) {

        int numberOfIterations= 0;
        int val = 0;
        if(times > arr.length) {
            times = (times - arr.length);
        }

        while( val < times ) {
            int last = arr[arr.length -1];
            int current = arr[0];
            int next = arr[1];
            for(int i = 0 ; i < arr.length -1 ; i++ ) {
                next = arr[i+1];
                arr[i+1] = current;
                current = next;
            }
            numberOfIterations++;
            arr[0] = last;
            val++;
        }

        System.out.println("Total number of Iterations :" + numberOfIterations);
        return arr;
    }

    public static void arryPrint() {

        int [] var = new int[10];
        var[0] =23;
        var[9] = 32;
        Arrays.stream(var).forEach(v -> System.out.print("["+v+"]"));
        System.out.println("");
    }


}
