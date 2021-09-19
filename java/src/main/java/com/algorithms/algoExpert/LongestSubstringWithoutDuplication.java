package com.algorithms.algoExpert;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {


    static String str = "clementisacap";
    public static void main(String args [] ) {

        String result = longestSubstringWithoutDuplication(str);
        System.out.println("Result -> " + result);

    }


    public static String longestSubstringWithoutDuplication(String s)   {
        int start = 0;
        int i = 0;
        int j = 0;
        Map<Character,Integer> map = new HashMap<>();
        String str = "";
        String result = "";
        while(j < s.length()) {
            char ch = s.charAt(j);
            if(!map.containsKey(ch)) {
                str += ch;
            } else {
                i = Integer.max(i,map.get(ch)+1);
                str = s.substring(i,j+1);
            }
            map.put(ch,j);
            System.out.println(result + " = " + str);
            if(result.length() < str.length()) {
                result = str;
            }
            j++;
        }
        return result;
    }
}
