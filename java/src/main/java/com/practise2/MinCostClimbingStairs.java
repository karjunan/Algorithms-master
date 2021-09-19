package com.practise2;

public class MinCostClimbingStairs {
    public static void main(String[] args) {

//        int [] stairs = new int [] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int [] stairs = new int[] {10, 15, 20};
//                                  0   1   2  3  4  5    6  7  8    9
        int [] dp = new int[stairs.length];
        int result = Math.min(minRecurssion(stairs,0),minRecurssion(stairs,1));
        int resultWithDP = Math.min(minRecurssionWithCache(stairs,0,dp),minRecurssionWithCache(stairs,1,dp));
        System.out.println("this Min cost is =>" + result);
        System.out.println("this Min cost using cache is =>" + resultWithDP);
    }

    public static int minRecurssion(int [] cost, int val) {

        if(val >= cost.length) {
            return 0;
        }

        int v1 = minRecurssion(cost,val+1);
        int v2 = minRecurssion(cost,val+2);
        int minVal = Math.min(v1,v2);
        return cost[val] + minVal;
    }

    public static int minRecurssionWithCache(int[] cost, int val, int [] dp) {
        if(val >= cost.length) {
            return 0;
        }
        if(dp[val] != 0) {
            return dp[val];
        }

        int v = minRecurssionWithCache(cost,val+1,dp);
        int v1 = minRecurssionWithCache(cost, val+2,dp);
        dp[val] = cost[val] + Math.min(v,v1);
        return dp[val];
    }
}

/*
    1 + 100 + 1 + 1 + 1 + 100 + 1 + 1 + 100 + 1 = 603
    1 + 1 + 1 + 1 + 100 = 104
    1 + 100 + 1 + 100



 */

