package com.algorithms.arrayproblems;

public class SecondMinimum {

    public static void main(String[] args) {
        int [] arr = {66,90,65,4,5,30 };

        System.out.println(secondLargest(arr));
        secondMinimum(arr);
    }

    public static void secondMinimum(int [] arr) {
        int temp = Integer.MAX_VALUE;
        int second = 0;
        for( int i = 0 ; i < arr.length; i++) {
            if(arr[i] < temp) {
                second = temp;
                temp = arr[i];
            } else if (second > temp && arr[i] < second) {
                second = arr[i];
            }
        }
        System.out.println("Second  Min : " + second);
    }

    public static int secondLargest(int [] arr) {

        int first =  0 ;
        int second = 0;

        for(int i = 0 ; i < arr.length;i++) {

            if(arr[i] > first) {
                second = first;
                first = arr[i];
            } else if(second < arr[i]) {
                second = arr[i];
            }
       }
        return second;
    }
}
