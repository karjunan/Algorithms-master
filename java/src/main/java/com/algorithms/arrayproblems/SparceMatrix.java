package com.algorithms.arrayproblems;

public class SparceMatrix {

    static int [][] arr = {{1,3,2},
            {0,6,9},
            {8,0,0}};

    public static void main(String [] args) {
        int result = findSparceMatrix(arr);
        int total = arr.length + arr[0].length;
        if(result > total/2) {
            System.out.println("This is a sparce Matrix");
        } else {
            System.out.println("Its not a sparce Matrix");
        }
    }

    public static int findSparceMatrix(int [][]arr) {
        int counter = 0;
        for(int i = 0; i < arr.length; i++) {
            for( int j = 0; j < arr[i].length;j++) {
                if(arr[i][j] == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void swap(int i, int j, int []arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
