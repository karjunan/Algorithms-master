package com.google;

import java.util.Arrays;

public class MatrixRandomValues {


    public static void main(String[] args) {
        runRandomMatrix();
    }

    public static void runRandomMatrix() {

        int [][] arr = new int[5][5];
        int j = 0;
        int start = 1;
        int end = 15;
        for(; j < arr[0].length; j++ ) {
            int k = 0;
            int i = 0;
            while( k < arr.length) {
                arr[i][j] =  (int)Math.random()* (start-end);
                k++;
                i++;
            }
            start = start + 15;
            end = end + 15;
            System.out.println(Arrays.deepToString(arr));

        }



    }
}
