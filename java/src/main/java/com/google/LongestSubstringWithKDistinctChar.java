package com.google;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChar {

    public static void main(String[] args) {

        String s = "AAAHHIBC";
        int k = 2;

        char [] ch = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < ch.length; windowEnd++) {
            map.compute(ch[windowEnd],(key,value) -> value == null ? 1 : value+1);
            System.out.println("Map before deletion => " + map);
            while(map.size() > k && windowStart < windowEnd) {
                max = Math.max(max, windowEnd-windowStart);
                if(map.containsKey(ch[windowStart])) {
                    int val = map.get(ch[windowStart]);
                    if(val > 1) {
                        map.put(ch[windowStart],val-1);
                    } else {
                        map.remove(ch[windowStart]);
                    }
                }
                System.out.println("Map after deletion => " + map);
                windowStart++;
            }
            System.out.println("Max value is =>> " + max );
        }

    }
}
