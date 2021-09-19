package com.backtracking;

import java.util.HashSet;

public class UniqueSplitString {

    public static void main(String[] args) {
        String s = "ababccc";
        int val = helper(s, new HashSet<>());
        System.out.println("Result is => " + val);
    }

    public static int helper(String s, HashSet<String> set ) {
        int max = 0;
        System.out.println(s  + "  ===>>>  " + set);
        for(int i = 1 ; i <= s.length(); i++) {
             String candiate = s.substring(0,i);
             if(!set.contains(candiate)) {
                 set.add(candiate);
                 max = Math.max(max, 1 + helper(s.substring(i),set));
                 set.remove(candiate);
                 System.out.println("Max Value is at the end " + max + "--->> " + set);
             }
         }

        return max;
    }
}
