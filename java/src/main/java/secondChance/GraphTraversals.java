package secondChance;

import java.util.*;

public class GraphTraversals {

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4,5},
                            {6,7,8,9,10},
                            {11,12,13,14,15},
                            {16,17,18,19,20}
                            };

        Set<String> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        dfs(matrix,visited,0,0,result);
        System.out.println(result);

        visited = new HashSet<>();
        result = new ArrayList<>();
        bfs(matrix,visited,result);
        System.out.println(result);
    }

    public static void bfs(int[][] matrix, Set<String> visited, List<Integer> result) {
        Queue<Integer[]> queue = new LinkedList<>();
        int height = matrix.length;
        int width = matrix[0].length;
        Integer[] mid = new Integer[2];

        mid[0] = 2;
        mid[1] = 2;

        queue.add(mid);
        result.add(matrix[mid[0]][mid[1]]);
        visited.add(mid[0]+"-"+mid[1]);

        while(!queue.isEmpty()) {
            Integer[] input = queue.poll();
            List<Integer[]> directions = getDirections(input,matrix);
            for(Integer[] in: directions) {
                String str = in[0]+"-"+in[1];
                if(!visited.contains(str)) {
                    result.add(matrix[in[0]][in[1]]);
                    queue.add(in);
                }

                visited.add(str);
            }
        }

    }

    public static List<Integer[]> getDirections(Integer[] val, int[][] matrix) {
        List<Integer[]> direction = new ArrayList<>();
        int row = val[0];
        int col = val[1];

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
        return direction;
    }

    public static void dfs(int [][] matrix, Set<String> visited, int row, int col, List<Integer> result) {

        String rowCol = row+"-"+col;
        if(row >= matrix.length || col >= matrix[0].length || row < 0 || col < 0 || visited.contains(rowCol)) {
            return;
        }

        visited.add(rowCol);
        result.add(matrix[row][col]);
        //System.out.println(visited);
        dfs(matrix,visited, row-1, col, result);
        dfs(matrix,visited, row, col+1, result);
        dfs(matrix,visited, row+1, col, result);
        dfs(matrix,visited, row, col-1, result);
    }
}
