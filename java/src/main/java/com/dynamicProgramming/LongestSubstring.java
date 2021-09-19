package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LongestSubstring {


    static String str = "findlongestsubstring";
    static String str1 = "abcabcabb";

    public static void main(String [] args) {
        System.out.println(lengthOfLongestSubstring(str1) );
    }

    public static int lengthOfLongestSubstring(String s) {

        int i = 0;
        int j = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while( j < s.length() && i < s.length()) {

            if(!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j),j++);
            } else {
                int val = map.get(s.charAt(j)) + 1;
                while(i < val) {
                    map.remove(s.charAt(i++));
                }
                map.put(s.charAt(j),j++);
            }

            if(max < map.size()) {
                max = map.size();
            }

             System.out.println(map);
        }
        return max;

    }

    public static int longestSubstringNSquaredSolution(String s) {
        System.out.println("String is >> " + s);
        if(s == null || s.length() == 0 || s.isEmpty())  {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }

        Map<Character,Integer> map = null;
        int i = 0;
        int j = 0;
        List<Map<Character,Integer>> list = new ArrayList<>();
        while(j < s.length()) {
             map = new HashMap<>();
             while(i < s.length()) {
                 if(!map.containsKey(s.charAt(i))) {
                     map.put(s.charAt(i),1);
                 } else {
                   break;
                 }
               i++;
             }
             list.add(map);
             // System.out.println(map);
            j++;
            i = j;
         }
     // System.out.println(" List size >> "+ list);
      return list.stream().mapToInt(v -> v.size()).max().getAsInt();
    }


}