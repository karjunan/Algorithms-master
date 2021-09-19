package com.algorithms.arrayproblems;

public class ArrayValueIntersection {


    static int[] a = { 1, 2, 3, 7, 11,8, 10 };
    static int[] b = { 4, 5, 6, 11, 15, 20 };

    public static void main(String [] args) {

        intersection(a,b);

    }

    public static void intersection(int [] a, int [] b) {

        int i = 0;
        int j = 0;

        while(i < a.length && j < b.length) {

            while(i < a.length && a[i] < b[j]) {
                i++;
            }

            while(j < b.length && b[j] < a[i]) {
                j++;
            }

            if(a[i] == b[j]) {
                System.out.println("Break Point is " + a[i]);
                break;
            }

        }

    }

}
