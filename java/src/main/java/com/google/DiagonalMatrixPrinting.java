package com.google;

public class DiagonalMatrixPrinting {
    public static void main(String[] args) {
        int [][] arr = new int [][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        print(arr);
        System.out.println("Print Diagonals - Row ");
        printDiagonal(arr);

        System.out.println("\nPrint Diagonals - Column ");

        printDiagonal1(arr);
    }

    public static void printDiagonal(int [][] arr) {
        for( int i = 0 ; i < arr.length; i++) {
            int j = i;
            int k = 0;

            while(j >= 0) {
                System.out.print("["+arr[j][k]+"]");
                j = j - 1;
                k = k+1;

            }
        }
    }

    public static void printDiagonal1(int [][] arr) {
        for( int i = 1 ; i < arr[arr.length-1].length; i++) {
            int j = arr.length-1;
            int k = i;

            while(k <= arr.length) {
                System.out.print("["+arr[j][k]+"]");
                j = j - 1;
                k = k+1;

            }
        }
    }

    public static void print(int [][]arr) {
        for(int i = 0 ; i < arr.length; i++) {
            for(int j = 0 ; j < arr[i].length; j++) {
                System.out.print("["+arr[i][j]+"]");
            }
            System.out.println("");
        }
    }
}
