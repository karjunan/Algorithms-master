package secondChance;

import java.util.Arrays;

public class SudukoSolver {

    public static void main(String[] args) {
        int [][] matrix = new int [][] {{7, 8, 0, 4, 0, 0, 1, 2, 0},
                                        {6, 0, 0, 0, 7, 5, 0, 0, 9},
                                        {0, 0, 0, 6, 0, 1, 0, 7, 8},
                                        {0, 0, 7, 0, 4, 0, 2, 6, 0},
                                        {0, 0, 1, 0, 5, 0, 9, 3, 0},
                                        {9, 0, 4, 0, 6, 0, 0, 0, 5},
                                        {0, 7, 0, 3, 0, 0, 0, 1, 2},
                                        {1, 2, 0, 0, 0, 7, 4, 0, 0},
                                        {0, 4, 9, 2, 0, 6, 0, 0, 7}};

        dfs(matrix,0,0);
        print(matrix);
    }


    public static void print(int [][] matrix) {
        for(int [] in: matrix) {
            System.out.println(Arrays.toString(in));
        }
    }
    public static boolean dfs(int [][] matrix, int row, int col) {
        //System.out.println(" Prining !!");
        if(row == matrix.length-1 && col == matrix[0].length) {
            return true;
        }

        if(col == matrix[0].length) {
            col = 0;
            row = row + 1;
        }

        if(matrix[row][col] != 0) {
            return dfs(matrix,row,col+1);
        }

        for(int i = 1; i < 10; i++) {
            if(isValid(row,col, matrix,i)) {
                matrix[row][col] = i;
                if(dfs(matrix, row, col+1)) {
                    return true;
                }
            }
            matrix[row][col] = 0;
        }

        return false;
    }

    public static boolean isValid(int row, int col, int [][] matrix, int element) {
        // Validate row
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][col] == element ) {
                return false;
            }
        }

        //Validate col
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[row][i] == element ) {
                return false;
            }
        }
        // Validate the 3 * 3 cells

        int startRow = row/3;
        int startCol = col/3;
        int nextRow = startRow * 3;
        int nextCol = startCol * 3;
        //	System.out.println(" next row , next Col  =>>>> " + nextRow + " == " + nextCol );
        for(int i = nextRow; i < Integer.min(nextRow + 3, matrix.length); i++) {
            for(int j = nextCol; j < Integer.min(nextCol+3, matrix[0].length); j++) {
                //	System.out.print(i+":"+j+ " ");
                if(matrix[i][j] == element) {
                    return false;
                }
            }
            System.out.println("\n");
        }


        return true;
    }
}
