package secondChance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberOfPasses {

    public static void main(String[] args) {


    }

    public int minimumPassesOfMatrix(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    Integer[] in = new Integer[2];
                    in[0] = i;
                    in[1] = j;
                    queue.add(in);
                }
            }
        }
        int pass = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer[] temp = queue.poll();
                int row = temp[0];
                int col = temp[1];
                if (row > 0 && matrix[row - 1][col] < 0) {
                    matrix[row - 1][col] *= -1;
                    Integer[] in = new Integer[2];
                    in[0] = row - 1;
                    in[1] = col;
                    queue.add(in);
                }
                if (row < matrix.length - 1 && matrix[row + 1][col] < 0) {
                    matrix[row + 1][col] *= -1;
                    Integer[] in = new Integer[2];
                    in[0] = row + 1;
                    in[1] = col;
                    queue.add(in);
                }
                if (col < matrix[0].length - 1 && matrix[row][col + 1] < 0) {
                    matrix[row][col + 1] *= -1;
                    Integer[] in = new Integer[2];
                    in[0] = row;
                    in[1] = col + 1;
                    queue.add(in);
                }
                if (col > 0 && matrix[row][col - 1] < 0) {
                    matrix[row][col - 1] *= -1;
                    Integer[] in = new Integer[2];
                    in[0] = row;
                    in[1] = col - 1;
                    queue.add(in);
                }
            }
            System.out.println(queue.size());
            pass += 1;

        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    return -1;
                }
            }
        }
        return pass - 1;
    }

}
