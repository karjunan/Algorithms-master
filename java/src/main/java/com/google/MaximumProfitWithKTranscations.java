package com.google;

import java.util.Arrays;

public class MaximumProfitWithKTranscations {


    public static void main(String[] args) {
        int[] prices = new int[]{5, 11, 3, 50, 60, 90};
        int k = 2;

        maxProfitWithKTransactions(prices, k);
    }

    public static int maxProfitWithKTransactions(int[] prices, int k) {

        int[][] profit = new int[k + 2][prices.length + 1];

        int l = 0;
        for (int i = 1; i < prices.length + 1 ; i++) {
            profit[0][i] = prices[l];
            l++;
        }

        for (int i = 1; i < profit.length; i++) {
            profit[i][0] = i-1;
        }

        for( int i = 2; i< profit.length;i++) {
            for( int j =2;j < profit[i].length;j++ ) {
                int calcProfit = Integer.MIN_VALUE;
                for(int m = 1; m < j; m++) {
                    if (profit[0][j] > profit[0][m]) {
                        calcProfit = Integer.max((profit[0][j] - profit[0][m]) + profit[i - 1][m], calcProfit);
                    }
                }
                profit[i][j] = Integer.max(calcProfit,profit[i][j-1]);
                print(profit);
            }
        }
        print(profit);
        return 0;
    }

    public static void print(int [][] arr) {
        for( int i = 0 ; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print("["+arr[i][j]+"]");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }



}