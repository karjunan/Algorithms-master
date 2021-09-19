package com.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        String s = "abcdccfghijkl";

        int result = lswrc(s);
        System.out.println("Result is => " + result);
    }

    public static int lswrc(String str) {
        if(str.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = str.toCharArray();
        int max = Integer.MIN_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < ch.length; windowEnd++) {
            System.out.println("Working on character => " + ch[windowEnd]);
            if(!map.containsKey(ch[windowEnd])) {
                map.compute(ch[windowEnd], (key, value) -> value == null ? 1 : value + 1);
                max = Math.max(max,(windowEnd - windowStart) + 1);
//                System.out.println(map  + " :: " + max);
            } else {
                while (map.containsKey(ch[windowEnd])) {
                    System.out.println(str.substring(windowStart, windowEnd) + " : : : " + max);
                    map.remove(ch[windowStart]);
                    windowStart++;
                    System.out.println(map);
                }
                map.compute(ch[windowEnd], (key, value) -> value == null ? 1 : value + 1);
            }


        }
    return max;
    }


    public int lscWithoutRepeatingCharacters(String str) {
        // abcdccfghijkl
        //Store the next greatest element

        return 0;
    }

}
