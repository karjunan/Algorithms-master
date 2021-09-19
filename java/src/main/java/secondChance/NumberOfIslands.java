package secondChance;

import java.sql.SQLOutput;
import java.util.*;

public class NumberOfIslands {

    public static void main(String[] args) {

        int [][] matrix = {{1,1,1,1,0},
                            {1,1,0,1,0},
                            {1,1,0,0,1},
                            {0,0,0,1,1}
                            };

//        int [][] matrix = {
//                          {0,1,0,1,0},
//                          {1,0,1,0,1},
//                          {0,1,1,1,0},
//                          {1,0,1,0,1}
//        };

        Set<String> visited = new HashSet<>();
        int visitedCount = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                //System.out.println(visited);
                if(visited.contains(i+"-"+j) || matrix[i][j] == 0 ) {
                    continue;
                }
                System.out.println("Visited count till now => " + visitedCount + " === " + i + " == " + j);
                visitedCount += dfs(i,j,visited, matrix);

            }
        }

        System.out.println("The visited count is => " + visitedCount);

    }

    public static int dfs(int row, int col, Set<String> visited, int[][] matrix) {
        System.out.println(" Row and col " + row+"||"+col);
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || visited.contains(row+"-"+col) || matrix[row][col] == 0) {
            return 0;
        }
        visited.add(row+"-"+col);
        List<Integer[]> neighbours = getNeighbours(row,col, matrix);
        for(Integer[] in: neighbours) {
            int nextRow = in[0];
            int nextCol = in[1];
            System.out.println(visited + " == " + row + "||" + col + " == " + nextRow + "||" + nextCol);
            dfs(nextRow,nextCol,visited,matrix);
        }


        return 1;
    }

    private static List<Integer[]> getNeighbours(int row, int col, int[][] matrix) {
            List<Integer[]> direction = new ArrayList<>();

            if(row > 0) {
                Integer[] in = new Integer[2];
                in[0] = row - 1;
                in[1] = col;
                direction.add(in);
            }

            if(col < matrix[0].length-1) {
                Integer[] in = new Integer[2];
                in[0] = row;
                in[1] = col + 1;
                direction.add(in);
            }

            if(row < matrix.length-1) {
                Integer[] in = new Integer[2];
                in[0] = row+1;
                in[1] = col;
                direction.add(in);
            }

            if(col > 0) {
                Integer[] in = new Integer[2];
                in[0] = row;
                in[1] = col - 1;
                direction.add(in);
            }
            System.out.println("--------------Direction Start ---------------------");
            System.out.println(" For row and col " + row + " == " + col);
             direction.forEach(v -> System.out.println(Arrays.toString(v)));
            System.out.println("--------------Direction End ---------------------");
            return direction;
        }
}
