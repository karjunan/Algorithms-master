package com.backtracking;

public class RatMazeComplex1 {

    public static void main(String[] args) {

        // int [][] arr= {{1, 0, 0, 0},
        //                {1, 1, 0, 1},
        //                {0, 1, 0, 0},
        //                {1, 1, 1, 1}};

        int [][] arr = { {2, 1, 0, 0},
                {3, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1}};

        // int [][] arr = {{2, 1, 0, 0},
        //                 {2, 0, 0, 1},
        //                 {0, 1, 0, 1},
        //                 {0, 0, 0, 1}};


        print(arr);
        maze(arr);
    }

    public static void maze(int [][] maze) {

        int [][] sol = new int [maze.length][maze.length];

        maze(maze,sol,0,0);

        print(sol);
    }

    public static boolean maze(int [][] maze, int [][] sol, int i, int j) {

        System.out.println( i + " : " + j);

        print(sol);

        if(i == maze.length - 1  && j == maze.length - 1   ) {
            sol[i][j] = 1;
            return true;
        }


        if(i >= 0 && i <  maze.length  && j >= 0 && j < maze.length
                && maze[i][j] != 0) {

            sol[i][j] = 1;

            for( int k = 1 ; k <= maze[i][j] ; k++) {
                boolean bool = maze(maze,sol, k + i ,j);

                System.out.println("BOOL >>> " + bool);

                if(bool) {
                    return true;
                }

                boolean bool1 = maze(maze,sol, i, k + j );
                System.out.println("BOOL 1  >>> " + bool1);
                if(bool1) {
                    return true;
                }
            }

            System.out.println("Resetting solution >>> ");
            sol[i][j] = 0;
        }


        return false;
    }

    public static void print(int [][] maze) {
        System.out.println("\n");
        for( int i = 0 ; i < maze.length;i++) {
            for( int j = 0 ; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");

            }
            System.out.println(" ");
        }
        System.out.println("");
    }


}
