package pramp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslands {

    public static void main(String[] args) {
            int [][] matrix = new int[][] {
                    {0,1,0,1,0},
                    {0,0,1,1,1},
                    {1,0,0,1,0},
                    {0,1,1,0,0},
                    {1,0,1,0,1},
            };

        System.out.println("Total number of ISLANDS => " + getNumberOfIslands(matrix));
    }

    static int getNumberOfIslands(int[][] matrix) {
        // your code goes here

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int counter = 0;
        for(int i = 0; i < matrix.length; i++ ) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                System.out.println("Working on " + i + " === " + j);
                dfs(i,j,matrix,visited);
                counter++;
            }
        }

        return counter;
    }

    static  void print(boolean[][] visited) {
        for(boolean[] bool: visited) {
            System.out.println(Arrays.toString(bool));
        }
    }


    static void dfs(int row, int col, int[][] matrix, boolean[][] visited) {

        if(visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        List<Integer[]> neighbours = getNeighbours(row, col, matrix);
        for(Integer [] neighbour: neighbours) {
            int nextRow = neighbour[0];
            int nextCol = neighbour[1];
            System.out.println("Value of next row and col  ==>> " + matrix[nextRow][nextCol]);
            if(matrix[nextRow][nextCol] == 0) {
                continue;
            }
            print(visited);
            dfs(nextRow, nextCol, matrix, visited);
        }

    }

    static List<Integer[]> getNeighbours(int row, int col, int[][] matrix) {

        List<Integer[]> list = new ArrayList<>();

        if(row > 0) {
            Integer[] in = new Integer[2];
            in[0] = row -1;
            in[1] = col;
            list.add(in);
        }

        if(row < matrix.length-1) {
            Integer[] in = new Integer[2];
            in[0] = row + 1;
            in[1] = col;
            list.add(in);
        }

        if(col < matrix[0].length-1) {
            Integer[] in = new Integer[2];
            in[0] = row;
            in[1] = col + 1;
            list.add(in);
        }

        if(col > 0) {
            Integer[] in = new Integer[2];
            in[0] = row;
            in[1] = col - 1;
            list.add(in);
        }

        return list;
    }

}
