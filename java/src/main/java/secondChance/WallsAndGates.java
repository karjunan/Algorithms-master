package secondChance;

import java.util.*;

public class WallsAndGates {
    static int [][] directions = new int [][]{{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {


        int [][] matrix = {
                {Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
                {Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
                {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE},

        };

        Map<String,Integer> result = new HashMap<>();


        Set<String> visited = null;
        int total = 0;
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
//                if(matrix[i][j] == 0) {
//                    dfs(i,j,matrix,0);
//                }
                int [] current = new int[]{Integer.MAX_VALUE};

                  if(matrix[i][j] == Integer.MAX_VALUE) {
                      visited = new HashSet<>();
                      int counter = 0;
                      dfs1(i,j,matrix,visited, counter, current);
                      result.put(i+"-"+j,current[0]);
                  }

               //  print(matrix);
            }
        }
        System.out.println(" final output ");
        buildMatrix(result, matrix);
        print(matrix);

    }

    private static void buildMatrix(Map<String, Integer> result, int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 0 || matrix[i][j] == -1) {
                    continue;
                }
                matrix[i][j] = result.get(i+"-"+j);
            }
        }
    }

    public static void print(int[][] matrix) {
        for(int [] val: matrix) {
            System.out.println(Arrays.toString(val));
        }
    }

    public static void  dfs(int row, int col, int[][] matrix, int currentStep) {
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || currentStep > matrix[row][col]) {
            return;
        }

        matrix[row][col] = currentStep;
        for(int[] direction: directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            dfs(nextRow,nextCol,matrix,currentStep+1);
        }


    }

    public static void  dfs1(int row, int col, int[][] matrix, Set<String> visited, int counter, int[] current) {
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length ||
                visited.contains(row+"-"+col) || matrix[row][col] == -1) {
            return;
        }
        if(matrix[row][col] == 0) {
            int max = Integer.min(counter,current[0]);
            current[0] = max;
        }
        visited.add(row+"-"+col);
        for(int[] direction: directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            dfs1(nextRow,nextCol,matrix,visited, counter+1,current);
        }
    }



}
