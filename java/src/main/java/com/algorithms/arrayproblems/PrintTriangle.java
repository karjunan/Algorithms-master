package com.algorithms.arrayproblems;

public class PrintTriangle {

    public static void main(String[] args) {

        triangle(10, 10);

    }

    public static void triangle(int row, int col) {

        if(row <= 0 ) {
            return;
        }

        triangle(row-1,col);

        for( int i = 0 ; i < col - row; i++) {
            System.out.print(" ");
        }

        for(int i = 0 ; i < row; i++) {
            System.out.print("* ");
        }

        System.out.println("");

    }


}


