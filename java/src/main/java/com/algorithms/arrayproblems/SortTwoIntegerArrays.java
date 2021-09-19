package com.algorithms.arrayproblems;

import java.util.Arrays;
import java.util.stream.StreamSupport;

public class SortTwoIntegerArrays {

    static int a [] ={3,4,5,8};
    static int b [] = {2,6,7};
// 1 , 4, 5, 8
// 3, 6, 7

// 1 , 3, 4, 5
// 8, 6, 7




    public static void main(String[] args) {

       sortList(a,b,a.length);

       print(a);
       print(b);

    }

    private static int sortList(int  [] a, int [] b
                                ,int aLength ) {
        if(aLength == 0) {
            return 0 ;
        }

        int bLength = sortList(a,b,--aLength);
         if(a[aLength] < b[bLength]) {
            return ++bLength;
         } else {
             swap(aLength,bLength);
         }
         if(b[bLength] > a[aLength]) {
             bLength++;
         }
         return bLength;
    }

    private static void swap(int l, int r) {
        int temp = a[l];
        a[l] = b[r];
        b[r] = temp;
        System.out.println("------Swapped Start-------------");
        print(a);
        print(b);
        System.out.println("------Swapped End-------------");
    }

    private static void print(int [] arr) {
        StreamSupport.intStream(Arrays.spliterator(arr),false)
                .forEach(v -> System.out.print("["+v+"]"));
        System.out.println("");
    }
}
