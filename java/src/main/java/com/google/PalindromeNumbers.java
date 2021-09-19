package com.google;

public class PalindromeNumbers {

    public static void main(String[] args) {
        int val = 54678;
        int result = isPalindrome(val);
        System.out.println(result == val ? true: false);
    }

    public static int isPalindrome(int num) {
        int total = 0;
        int i = 0;
        while(num != 0) {
            int remainder = num % 10;
            total = (total * 10) + remainder;
            num = num/10;
            i++;
            System.out.println(total);
        }
        return total;
    }
}
