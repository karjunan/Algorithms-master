package com.backtracking;

public class MaximumRoutesMatrix {

    public static void main(String[] args) {

        int [][] matrix  =  {{1,2,3},
                             {4,5,6},
                             {7,8,9}
                            };

        //can only move right and move down
        System.out.println(findPaths(matrix,0,0));

    }

    private static int findPaths(int [][] arr, int right, int down) {

        if(right < arr.length && down < arr[0].length) {
            if (right == arr.length-1 && down == arr[0].length-1) {
                return 1;
            }

            System.out.println("[" + arr[right][down] + "]");
            return findPaths(arr, right+1, down) + findPaths(arr, right, down+1);
        }
        return 0;
    }


}
