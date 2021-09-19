package com.google;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        String first = "Krishnakumar";
        String second = "nak";
        List<String> list = new ArrayList<>();
        int val = longestCommonSubstring(first.toCharArray(), second.toCharArray(),
                0,0,list);
        System.out.println(val);
        System.out.println(list);
    }

    public static int longestCommonSubstring(char [] first, char [] second,
                                              int i , int j,
                                             List<String> list) {

        if(i >= first.length || j >= second.length) {
            return 0;
        }
        int val = 0;
        System.out.println("["+first[i]+"]  =  "+ "["+second[j]+"]" );
        if(first[i] == second[j]) {
            String s= new String(first);
            list.add(s.substring(i-val));
            val =  1 + longestCommonSubstring(first,second,i+1,j+1,list);
            return val;
        } else {
            val = Math.max(longestCommonSubstring(first,second,i+1,j,list),
            longestCommonSubstring(first,second,i,j+1,list));
        }

        return val;
    }
}
