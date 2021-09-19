package com.backtracking;

public class NQueens1 {

    public static void main(String [] args ) {

        nQueens(8);

    }

    public static void nQueens(int val) {

        int [][] arr = new int[val][val];
        // print(arr);
        nQueens(arr,0);
        // print(arr);
        System.out.println("Completed ----->>");
    }

    public static void nQueens(int [][] arr, int row) {

        if(row >= arr.length ) {
            print(arr);
            return;
        }

        for(int i = 0 ; i < arr.length; i++) {
            if(isValid(arr,row,i)) {
                arr[row][i] = 1;
                nQueens(arr,row+1);
                arr[row][i] = 0;
            }

        }

    }

    public static boolean isValid(int [][] arr , int row, int col) {

        // Column check if any value is present
        for( int i = 0 ; i < arr.length; i++ ) {
            if( arr[row][i] != 0 ) {
                return false;
            }
        }


        // Column check if any queens attack
        for( int i = 0 ; i < arr.length; i++ ) {
            if( arr[i][col] != 0 ) {
                return false;
            }
        }


        // lower diagonal check for queen attack
        for( int i = row-1, j = col-1 ; i >=0  && j >= 0; i--,j-- ) {
            if( arr[i][j] != 0 ) {
                // System.out.println("Lower diag>> "+row + " : >> " + col);
                return false;
            }
        }

        // Upper right diagonal check for queen attack
        for( int i = row-1, j = col+1 ; i >= 0 && j < arr.length; i--,j++ ) {
            if( arr[i][j] != 0 ) {
                // System.out.println("Upper diag>>" +row + " : >> " + col);
                return false;
            }
        }
        return true;

    }



    public static void print(int [][] maze) {
        for( int i = 0 ; i < maze.length;i++) {
            for( int j = 0 ; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("");
    }
}
