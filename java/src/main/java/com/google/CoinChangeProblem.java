package com.google;

import java.util.Arrays;

public class CoinChangeProblem {

    public static void main(String[] args) {

//        int [] coins = new int[] {1,5,10,15};
//        int total = 10;
        int [] coins = new int[] {2,3,5,10};
        int total = 15;
        coinChange(coins,total);

    }

    public static void coinChange(int [] coins, int total) {

            int [][] dp = new int[coins.length+2][total+2];
            for(int i = 0; i < dp.length; i++ ) {
                for(int j = 0; j < dp[i].length; j++) {
                    dp[i][j] = 0;
                }
            }
            for(int i = 1 ; i < dp[0].length; i++) {
                dp[0][i] = i-1;

            }
            int k = 0;
            for(int i = 2 ; i < dp.length; i++) {
                dp[i][0] =coins[k];
                dp[i][1] = 1;
                k++;
            }

            print(dp);


            for( int i = 2; i < dp.length; i++) {
                for (int j = 2; j < dp[i].length; j++) {
                    if (dp[0][j] >= dp[i][j]) {

                        int left = j - dp[i][0];
                        if (left > 0 ) {
                            dp[i][j] = dp[i - 1][j] + (dp[i][left]);
                        } else{
                                dp[i][j] = dp[i - 1][j];
                            }
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
            }
        print(dp);

    }

    public static void print(int [][] dp) {
        System.out.println("\n");
        for(int i = 0; i < dp.length; i++ ) {
            for(int j = 0; j < dp[i].length; j++) {
                System.out.print("["+dp[i][j]+"] ");
            }
            System.out.println(" \n");
        }
    }

    //


}
