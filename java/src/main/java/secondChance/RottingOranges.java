package secondChance;

import java.lang.reflect.Array;
import java.util.*;

public class RottingOranges {

    public static void main(String[] args) {
//        int [][] matrix = {
//                            {2,1,1,0,0},
//                            {1,1,1,0,0},
//                            {0,1,1,1,1},
//                            {0,1,0,0,1},
//                            };
        int [][] matrix = {
                {1,1,0,0,0},
                {2,1,0,0,0},
                {0,0,0,1,2},
                {0,1,0,0,1},
        };
        Set<String> visited = new HashSet<>();
        List<Integer[]> position = findPosition(matrix);
        int time = rottingOranges(matrix,visited, position);
        int someGoodOrangeIsAvailable = isAnyGoodOrangesStillAvailable(matrix,visited);

        System.out.println(time + " == " + someGoodOrangeIsAvailable);
    }

    public static int isAnyGoodOrangesStillAvailable(int[][] matrix, Set<String> visited) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                String str = row+"-"+col;
                if(matrix[row][col] == 1 && !visited.contains(str)) {
                    return -1;
                }
            }
        }

        return 0;
    }

    private static List<Integer[]> findPosition(int[][] matrix) {
        List<Integer[]> rottenOranges = new ArrayList<>();
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 2) {
                    Integer[] position = new Integer[2];
                    position[0] = row;
                    position[1] = col;
                    rottenOranges.add(position);
                }

            }
        }
        return rottenOranges;
    }

    public static int rottingOranges(int [][] matrix, Set<String> visited, List<Integer[]> rottenOranges) {

        Queue<Integer[]> queue = new LinkedList<>();
        for(Integer[] startingPosOfRottenOranges: rottenOranges) {
            queue.add(startingPosOfRottenOranges);
        }
        int time = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i < size; i++) {
                Integer[] current = queue.poll();
                visited.add(current[0]+"-"+current[1]);
                List<Integer[]> neighbours = getNeighbours(current,matrix );
                for(Integer[] neighbour: neighbours) {
                    int row = neighbour[0];
                    int col = neighbour[1];
                    if(matrix[row][col] == 1 && !visited.contains(row+"-"+col)) {
                        queue.add(neighbour);
                    }
                }
            }
            time++;
        }

        System.out.println(" Finally the time is => " + time);
        return time;
    }

    private static List<Integer[]> getNeighbours(Integer[] current, int[][] matrix) {
            List<Integer[]> direction = new ArrayList<>();
            int row = current[0];
            int col = current[1];

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
//            System.out.println("--------------Direction Start ---------------------");
//            System.out.println(" For row and col " + row + " == " + col);
//            direction.forEach(v -> System.out.println(Arrays.toString(v)));
//            System.out.println("--------------Direction End ---------------------");
            return direction;
    }
}
