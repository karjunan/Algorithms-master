package com.dynamicProgramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str = "abcdefasdf";
        String str1 = "afaf";
        int i = 0;
        int j = 0;
        System.out.println("\n\n Size " +
                "is :: " +lcsRecursion(str,str1,i,j));

    }

    public static String lcsRecursion(String str, String str1,int i , int j) {
        if( i >= str.length() || j >= str1.length() ) {
            return "";
        }

        if(str.charAt(i) == str1.charAt(j)) {
            System.out.print("  " + str1.charAt(j));
            return lcsRecursion(str,str1,++i,++j);
        }

        String x = lcsRecursion(str,str1,++i,j);
        String str1New  = str1.substring(0,j)+str1.substring(j+1,str1.length());
        String y = lcsRecursion(str,str1New,i,++j);
        return  x.length() > y.length()  ? x : y;
    }


    }
