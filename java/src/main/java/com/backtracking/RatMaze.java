package com.backtracking;

public class RatMaze {

    public static void main(String [] args ) {

        int [][] arr =  {{1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 1}};
        int [][] sol = new int[arr.length][arr.length];

        print(arr);
        maze(arr,sol);
        System.out.println("Solution Matrix ");
        print(sol);

    }

    public static void maze(int [][] arr,int [][] sol) {
        helper(arr,0,0,sol);
    }

    public static void  helper(int [][] arr, int row, int col,
                               int [][] sol) {
        // System.out.println(" Outside  Row :"+ row + " Col : " + col );

        if(row == arr.length  || col == arr.length ) {
            return;
        }

        if(isValid(arr,row,col)) {
            sol[row][col] = 1;
            helper(arr,row+1,col,sol);
            helper(arr,row,col+1,sol);
        } else {
            sol[row][col] = 0;
            return;
        }

    }

    public static boolean isValid(int [][] arr, int row, int col) {
        boolean bool = false;
        if(arr[row][col] == 1 ) {
            bool = true;
        }

        return bool;
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
