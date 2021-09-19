package com.algorithms.recursion;

public class CheckIfNumberISPalindromeRecursive {
    public static void main(String [] args) {

        int n = 133321;
        boolean result = checkNumberiSPalidrome(n);
        System.out.println("Result is -> " + result);
    }

    public static boolean checkNumberiSPalidrome(int val) {

        int i = 0;
        int multiple = 0;
        int mod = 0;
        while(val > 0) {
            i = (i * 10) + (val % 10);
            val = val/10;
            System.out.println(i);
        }

        return false;
    }
}
