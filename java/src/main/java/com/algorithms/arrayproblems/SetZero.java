package com.algorithms.arrayproblems;

import java.util.ArrayList;
import java.util.List;

public class SetZero {

    public static void main(String[] args) {

        int [][] arr = {{1,1,0,1} , {1,1,1,1},{1,1,1,1}};

        setZero(arr);

    }

    public static void setZero(int [][] arr) {
        print(arr);

        List<Integer> list = new ArrayList<>();

        for( int i = 0 ; i < arr.length; i++) {
            for( int j = 0 ; j < arr[i].length; j++) {
                if(arr[i][j] == 0) {
                    list.add(i);
                    list.add(j);
                }
            }
        }

        System.out.println(list);
        System.out.println("\n");
        int col = list.get(0);
        for(int i = 0 ; i < arr[0].length; i++) {
            arr[col][i] = 0;
        }
        print(arr);
        System.out.println("\n");
        col = list.get(1);
        for(int i = 0 ; i < arr.length; i++) {
            arr[i][col] = 0;
        }
        System.out.println("\n");
        print(arr);
    }

    public static void print(int [][] arr) {
        for( int i = 0 ; i < arr.length; i++ ) {
            for( int j = 0 ; j < arr[i].length; j++ ) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println("");
        }
    }
}
