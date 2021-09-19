package com.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
       String str = "AAAHHIBC";
       int k = 2;
        System.out.println(substringLong(str,k));
    }

    public static String substringLong(String str , int k) {
        int windowStart = 0 ;
        Map<Character,Integer> map = new HashMap<>();
        char [] ch = str.toCharArray();
        int max = Integer.MIN_VALUE;
        String result = "";
        for( int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            map.compute(ch[windowEnd],(key,value) -> value == null ? 1: value+1);
            System.out.println("Initial Map" + map);
            if(map.size() > k) {
                max = Math.max(max,windowEnd-windowStart);
                if(result.length() < max) {
                    result = str.substring(windowStart,windowEnd);
                }
            }
            while(map.size() > k) {
                map.computeIfPresent(ch[windowStart], (key,value) -> value == 1 ? null: value-1);
                System.out.println(map);
                windowStart++;
            }
        }

        return result;
    }
}
