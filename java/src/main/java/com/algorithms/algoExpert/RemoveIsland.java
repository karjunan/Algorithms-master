package com.algorithms.algoExpert;

import java.util.Stack;

public class RemoveIsland {

    public static void main(String[] args) {

        int [][] arr = { {1,0,0,0,0,0},
                         {0,1,0,1,1,1},
                         {0,0,0,0,1,0},
                         {1,1,0,0,1,0},
                         {1,0,1,1,0,0},
                         {1,0,0,0,0,1}
                        };
        print(arr);
        validateEdges(arr);
        setMatrix(arr);
        print(arr);
    }

    public static void setMatrix(int[][] arr) {
          for(int i = 0 ; i < arr.length; i++) {
              for(int j = 0 ; j < arr[i].length; j++) {
                  if(arr[i][j] == -1) {
                      arr[i][j] = 1;
                  } else if(arr[i][j] == 1) {
                      arr[i][j] = 0;
                  }
              }
          }
    }

    public static void validateEdges(int [][] arr) {

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
               boolean rowBorder = i == 0 || i == arr.length-1;
               boolean colBorder = j == 0 || j == arr[i].length-1;
               boolean isBorder = rowBorder || colBorder;
               if(!isBorder) {
                   continue;
               }

               if(arr[i][j] == 1) {
                   findIslands(arr, i, j);
               }
            }
        }

    }

    public static void findIslands(int[][] arr, int row, int col) {
        Stack<Integer[]> stack = new Stack();
        Integer[] in1 = new Integer[2];
        in1[0] = row;
        in1[1] = col;
        arr[row][col] = -1;
        stack.push(in1);
        while(!stack.isEmpty()) {
            Integer[] val = stack.pop();
            row = val[0];
            col = val[1];
            System.out.println("["+row+"]"+"["+col+"]" + " and the value is =>>  " + arr[row][col]);
            if(col > 0 && arr[row][col-1] > 0) {
                Integer[] in = new Integer[2];
                in[0] = row;
                in[1] = col-1;
                arr[row][col-1] = -1;
                stack.push(in);
            }
            if(row > 0 && arr[row-1][col] > 0) {
                Integer[] in = new Integer[2];
                in[0] = row-1;
                in[1] = col;
                arr[row-1][col] = -1;
                stack.push(in);
            }
            if(row < arr.length-1 && arr[row+1][col] > 0) {
                Integer[] in = new Integer[2];
                in[0] = row+1;
                in[1] = col;
                arr[row+1][col] = -1;
                stack.push(in);
            }
            if(col < arr[0].length-1 && arr[row][col+1] > 0) {
                Integer[] in = new Integer[2];
                in[0] = row;
                in[1] = col+1;
                arr[row][col+1] = -1;
                stack.push(in);
            }
            print(arr);
//           stack.stream().forEach(v -> System.out.println(v[0] + " :: " + v[1]));
        }




    }

    public static void print(int [][] arr) {
        for(int i = 0 ; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                 System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }


}
