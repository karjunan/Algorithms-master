package com.google;

public class BinarySubarraysWithSum {

    public static void main(String[] args) {
       int[] A = new int[]{1,0,1,0,1};
       int k = 2;
       int result = numSubarraysWithSum(A,k);
        System.out.println("Result is " + result);
    }

    public static int numSubarraysWithSum(int[] A, int S) {

        int total = 0;
        int windowStart = 0;
        int currentSum = 0;
        for(int windowEnd = 0; windowEnd < A.length; windowEnd++) {
            currentSum = currentSum + A[windowEnd];
            if(currentSum == S) {
                total++;
                continue;
            }
            System.out.println("Current Sum "+ currentSum + " :: " + total);
            while(currentSum >= S) {
                currentSum = currentSum - A[windowStart];
                if(currentSum == 2) {
                    total++;
                }
                windowStart++;
            }

        }
        return total;
    }

}
