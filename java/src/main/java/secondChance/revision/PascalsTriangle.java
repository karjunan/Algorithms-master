package secondChance.revision;

import java.util.Arrays;

public class PascalsTriangle {

    public static void main(String[] args) {
        int size = 6;
        int [][] matrix = new int[size][size];
        pascal(matrix);
        print(matrix);
    }

    public static void pascal(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 1;
        }

        for(int i =1 ; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
            }
        }

    }

    public static void print(int [][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
