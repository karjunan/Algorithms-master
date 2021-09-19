package com.algorithms.algoExpert;

public class MaxCoinWithShortestDistance {


    public static void main(String [] args) {

        int [][] arr = {{0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0}};

        calculate(arr);
    }

    public static void calculate(int [][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int [][] dp = new int[row+1][col+1];
        // System.out.println(Arrays.deepToString(arr));

        print(arr);

        for( int i = row; i >= 0; i--) {
            for( int j = 0; j < col; j++) {
                if(dp[i][j] < arr[i][j] ) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j]+arr[i][j]);

                }

            }

        }

        print(dp);
    }

    public static void print(int[][]arr){
        for(int i = 0 ; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
