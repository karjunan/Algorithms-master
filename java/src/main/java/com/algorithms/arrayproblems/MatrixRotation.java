package com.algorithms.arrayproblems;

public class MatrixRotation {

    public static void main(String[] args) {

        int[][] arr = { {1,2,3},{4,0,6},{7,1,9}};

        matrixRotation(arr);
    }

    public static void matrixRotation(int [][] arr) {

        for(int i = 0 ; i< arr.length;i++) {
            for(int j = 0; j < arr[i].length;j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println("");
        }

    }
}
