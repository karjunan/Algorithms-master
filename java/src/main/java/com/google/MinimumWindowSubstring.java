package com.google;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

       String  s = "ADOBECODEBANC";
       String t = "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String s1) {

        Map<Character,Integer> lookup = new HashMap<>();
        for(char ch : s1.toCharArray()) {
            lookup.compute(ch, (k,v) -> v == null ? 1 : v+1);
        }
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        int min = Integer.MAX_VALUE;
        char [] ch = s.toCharArray();
        String finalString = "";
        System.out.println(lookup);
        for(int windowEnd = 0; windowEnd < ch.length; windowEnd++) {
            map.compute(ch[windowEnd],(k,v) -> v == null ? 1: v + 1);
            if(lookup.containsKey(ch[windowEnd])) {
                while(validateMap(s1,map)) {
                    min = Math.min(min,windowEnd-windowStart+1);
                    finalString = s.substring(windowStart,windowEnd+1);
                    System.out.println(finalString);
                    map.computeIfPresent(ch[windowStart++],(k,v) -> v == 1 ? null: v-1);
                }
            }
            System.out.println(map);
        }
        return finalString;
    }

    public static boolean validateMap(String s1, Map<Character,Integer> map) {
        if(map.size() < s1.length()) {
            return false;
        }

        for(char ch : s1.toCharArray()) {
            if(!map.containsKey(ch)) {
                return false;
            }
        }

        return true;
    }


}
