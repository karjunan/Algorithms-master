package com.google;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String str1 = "jcdli";
        String str2 = "abcdefghijl";
        int value = lcs(str1,str2,0,0);
        System.out.println(" LCS is =>  "+ value);

    }


    public static int lcs(String str1, String str2,
                           int i , int j ) {

        System.out.println(str1 +  " : " + str2 + " : " + " = " + i + " = " +j);
        if(i >= str1.length() || j >= str2.length()) {
            return 0;
        }

        if(str1.charAt(i) == str2.charAt(j)) {
            return 1 + lcs(str1,str2, i + 1, j + 1);
        }
        if(str1.charAt(i) != str2.charAt(j)) {
          return Math.max(lcs(str1,str2,i+1,j), lcs(str1,str2,i,j+1));
        }
        return 0;
    }
}
