package com.algorithms.arrayproblems;

public class FindSubsequenceInTwoStrings {

    static String str1 = "gksrek";
    static String str2 = "geeksforgeeks";
    public static void main(String [] args) {

        boolean bool = findSubsequence(str1,str2);
        System.out.println("Subsequence is present ->  " + bool);
    }

    public static boolean findSubsequence(String str1 , String str2) {
        int i = 0;
        int j = 0;
        if(str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        while(i < str1.length() && j < str2.length()) {
            if(str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        if(i == str1.length()) {
            return true;
        }
        return false;
    }
}
