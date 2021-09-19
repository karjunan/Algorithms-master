package com.algorithms.algoExpert;

import java.util.Arrays;

public class KMP {

    public static void main(String[] args) {

//            String pattern = "aefaedaefaefa";
//            String pattern = "AABA";
//            String pattern = "AAAAB";
//            String pattern = "AAAA";
//            String pattern = "ABCDE";
//            String pattern = "AABAACAABAA";
//            String pattern = "AAACAAAAAC";
            String pattern = "AAABAAA";
            lps(pattern);

    }

    public static Integer[] lps(String pattern) {

        Integer[] result = new Integer[pattern.length()];
        Arrays.fill(result,-1);
        int j = 0;
        int i = 1;
        char [] ch = pattern.toCharArray();
        while( i < pattern.length()) {

            while(i < pattern.length() && ch[i] == ch[j]) {
                result[i] = j;
                j++;
                i++;
            }
            if(j > 0) {
                int prev = result[j - 1];
                if (prev == -1) {
                    j = 0;
                } else {
                    j = prev + 1;
                }
            } else {
                i++;
            }
            System.out.println(Arrays.toString(result));
        }


        return result;
    }


}
