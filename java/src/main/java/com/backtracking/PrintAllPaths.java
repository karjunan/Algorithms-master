package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintAllPaths {


    public static void main(String [] args ) {
        int [][] arr  = {{1,2,3},
                         {4,5,6},
                         {7,8,9},};
        // {7,8,9}};

        print(arr);

        path(arr);
    }

    public static void allPaths(int [][] arr, int i , int j,
                                int sol[], int k) {

        System.out.println(i + " : " + j );

        if(i == arr.length -1  && j == arr[0].length - 1 ) {
            sol[k] = arr[i][j];
            System.out.println(Arrays.toString(sol));
            sol = new int [arr.length + 1];
            k = 0;
            return;
        }

        if(i >= 0 && i < arr.length && j >= 0 && j < arr[0].length) {
            sol[k] = arr[i][j];
            allPaths(arr,i+1,j,sol, k + 1);
            allPaths(arr,i,j+1,sol ,k + 1);
            sol[k] = 0;
            --k;
        }
    }




    public static void path(int [][] arr) {

        path(arr,new LinkedList<>(), new ArrayList<>(),0,0);
    }


    public static void path(int [][] arr, LinkedList<Integer> list, List<LinkedList<Integer>> fList, int row, int col) {
        System.out.println(list);

        if(row >= arr.length   || col >= arr.length ) {
            return;
        }

        if( row == arr.length -1   && col == arr[row].length -1   ) {
            LinkedList<Integer> ls = new LinkedList<>();
            ls.addAll(list);
            fList.add(ls);
            list = ls;
            System.out.println("Result >> " + fList);
            return;
        }

        list.add(arr[row][col]);
        path(arr,list,fList,row + 1 , col);
        path(arr,list,fList,row,col + 1);
        list.removeLast();
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
