package com.graphs;

import java.util.Arrays;

public class Graph {

    public static void main(String[] args) {

        int [][] matrix = new int[5][];
        matrix[0] = new int[] {1,2,3,4};
        matrix [1] = new int[]{3};
        matrix[2] = new int[]{4,1};
        matrix[3] = new int[]{2,4};
        matrix[4] = new int[]{2,3};
        int [] visited = new int[matrix.length];
        System.out.println(Arrays.toString(matrix[1]));
        dfs(4,matrix,visited);
    }


    /*visited = [0,0,0]
                 0,1,2
    */
    public static void dfs(int val, int [][] matrix, int [] visited) {
        
         if(visited[val] == 0) {
            System.out.print("["+val+"]");
             visited[val] = 1;
             for(int i = 0 ; i < matrix[val].length; i++) {
                    // System.out.println(Arrays.toString(visited)); 
                   if(visited[matrix[val][i]] == 1 ) {
                       continue;
                   } 
                //    System.out.println("Exploring matrix => " +matrix[val][i]);
                   dfs(matrix[val][i],matrix,visited);
            }
         }

    }


    
}
