package com.google;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {

        int val =  uniquePaths(4,4);
        System.out.println("Total unique paths => " + val);

        int dpVal = uniquePathsDP(5,4);
        System.out.println(" Dp unique :" + dpVal);
    }


    public static int uniquePathsDP(int m, int n) {
        int [][] dp = new int[m][n];
        for(int i = 0 ; i < dp.length;i++) {
            dp[i][0] = 1;
        }

        for(int i = 0 ; i < dp[0].length;i++) {
            dp[0][i] = 1;
        }

        for(int i = 1 ; i < dp.length; i++) {
            for(int j = 1 ; j < dp[i].length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[dp.length-1][dp[dp.length-1].length-1];
    }

    public static int uniquePaths(int m, int n) {
        int [][] dp = new int[m+1][n+1];
        for(int i = 0 ; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return path(1,1,m,n,dp);
    }

    public static int path(int row, int col,
                           int m, int n,int[][] dp) {

        if(row == m  && col == n) {
            return 1;
        }

        if(row > m  || col > n) {
            return 0;
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        int result = path(row+1, col, m,n,dp) +  path(row,col+1,m,n,dp);
        dp[row][col] = result;
        return result;
    }

}
