package com.algorithms.algoExpert;

public class MinimumDistanceBetweenTwoNumbers {


    static int [] arr =    {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
    static int x = 3;
    static int y = 6;

    public static void main(String [] args) {

        minDistance(arr,x,y);
    }

    public static void minDistance(int [] arr, int x, int y) {
        int [] temp = new int[2];
        temp[0] = -1;
        temp[1] = -1;
        int localMin = 0;
        int min = Integer.MAX_VALUE;
        for( int i = 0; i < arr.length; i++) {
            boolean bool = false;
            if(arr[i] == x) {
                bool = true;
                temp[0] = i;
            }

            if(arr[i] == y) {
                bool = true;
                temp[1] = i;
            }

            if(bool && temp[0] != -1 && temp[1] != -1 ) {
                localMin = Math.abs(temp[0] - temp[1]);
                min = Math.min(localMin,min);
                System.out.println("Local Min : "+ localMin);
            }
            bool = false;

        }

        System.out.println("Final Min : "+ min);


    }
}
