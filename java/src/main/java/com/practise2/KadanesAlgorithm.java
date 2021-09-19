package com.practise2;

public class KadanesAlgorithm {

    public static void main(String[] args) {

        int [] arr = new int [] {-2, -3, 4, -1, -2, 1, 5, -3};
        int sum = arr[0];
        int currentSum = arr[0];
        for(int i = 1 ; i < arr.length; i++) {
            currentSum = Math.max(arr[i], arr[i] + currentSum);
            sum = Math.max(currentSum,sum);
            System.out.println(currentSum);
        }

        System.out.println("Max Sum is => " + sum);
    }
}
/*
    -2 3           = 1
    -2 3 4         = 5
    -2 3 4 -1      = 4
    -2 3 4 -1 -2   = 2
    -2 3 4 -1 -2 1 = 3
    -2 3 4 -1 -2 1 5 = 8
    -2 3 4 -1 -2 1 5 -3= 5

    -3 4 = 1
    -3 4 -1 = 0
    -3 4 -1 -2 = -2
    -3 4 -1 -2 1 = -1
    -3 4 -1 -2 1 5 = 4
    -3 4 -1 -2 1 5 -3 = 1

     4 -1 = 3
     4 -1 -2 = 1
     4 -1 -2 1 = 2
     4 -1 -2 1 5 = 7
     4 -1 -2 1 5 -3 = 4

     -1 -2 = -3
     -1 -2 1 = -2
     -1 -2 1 5 = 3
     -1 -2 1 5 -3 = 0

     -2 1 = -1
     -2 1 5 = 4
     -2 1 5 -3 = 1

      1 5 = 6
      1 5 -3 = 3

      5 -3 = 2

      -3 = -3



 */
