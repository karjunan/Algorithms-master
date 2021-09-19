package com.google;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {

        helper(4);
    }

    public static void helper(int n) {
        List<List<Integer>> list = new ArrayList<>();
        solveNQueens(n,0,new ArrayList<>(),list);
        System.out.println(list);
    }
    public static void solveNQueens(int n, int rows, List<Integer> colPlacements,
                                    List<List<Integer>> solutions) {
        if(n == rows) {
            solutions.add(new ArrayList<>(colPlacements));
//            System.out.println(solutions);
        } else {
            for (int i = 0; i < n; i++) {
                colPlacements.add(i);
                if (isValidPlacement(colPlacements)) {
                    solveNQueens(n, rows + 1, colPlacements, solutions);
                }
                colPlacements.remove(colPlacements.size() - 1);
            }
        }

    }

    public static boolean isValidPlacement( List<Integer> colPlacements) {

        int row = colPlacements.size()-1;
        for(int i = 0 ; i < row; i++) {
            int diff = Math.abs(colPlacements.get(i) - colPlacements.get(row));
            int diagonal = row-i;
            if( diff == 0 || diagonal == diff ) {
                return false;
            }
        }
        return true;
    }


}


