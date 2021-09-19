package com.dynamicProgramming;

public class CountAllPathMatrix {

    public static void main(String [] args) {

        int [][] arr = { {1,2,3},
                {4,-1,6},
                {7,8,9}};

        int val = countAllPaths(arr,0,0);
        System.out.println("Result is  : " + val);

    }

    public static int countAllPaths(int [][] arr,int row, int col) {

        if((row == arr.length -1  && col == arr.length -1)) {
            return 1;
        }



        // System.out.println("Completing row " + arr[row][col]);
        int r = 0;
        int d = 0;
        if(row < arr.length && col < arr[0].length && arr[row][col] != -1)
            r = countAllPaths(arr,row+1,col);
        if(row < arr.length && col < arr[0].length && arr[row][col] != -1 )
            d = countAllPaths(arr,row,col+1);

        return r+d;
    }

}
